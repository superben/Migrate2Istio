package com.yofc.subject.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yofc.common.bean.BusinessException;
import com.yofc.common.bean.ValidationException;
import com.yofc.common.util.BeanMapUtil;
import com.yofc.common.util.CommonMapUtils;
import com.yofc.dal.subject.entity.*;
import com.yofc.common.enums.ColleagueTextTypeEnum;
import com.yofc.common.enums.NitificationTypeEnum;
import com.yofc.common.enums.PublicEnum;
import com.yofc.common.enums.TopStickEnum;
import com.yofc.dal.subject.mapper.*;
import com.yofc.subject.redis.entity.SubjectReadAmount;
import com.yofc.subject.redis.service.ISubjectReadRedisService;
import com.yofc.subject.service.*;
import org.apache.commons.collections4.MapUtils;
import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapperExt subjectMapperExt;

    @Autowired
    private SubjectFollowMapperExt subjectFollowMapperExt;

    @Autowired
    private SubjectGoodPointMapperExt subjectGoodPointMapperExt;

    @Autowired
    private SubjectCollectionMapperExt subjectCollectionMapperExt;

    @Autowired
    private SubjectParagraphMapperExt subjectParagraphMapperExt;

    @Autowired
    private SubjectReplyService subjectReplyService;

    @Autowired
    private PushSubjectTaskService pushSubjectTaskService;

    @Autowired
    private ISubjectReadRedisService subjectReadService;

    @Autowired
    private ClassifyGroupMapperExt classifyGroupMapperExt;

    @Autowired
    private RedisSubjectGoodPointService redisSubjectGoodPointService;

    @Autowired
    private RedisSubjectCollectionService redisSubjectCollectionService;

    @Autowired
    private RedisSubjectFollowService redisSubjectFollowService;

    @Autowired
    private RedisSubjectService redisSubjectService;

    @Autowired
    private SubjectClassifyService subjectClassifyService;

    @Autowired
    private RedisSubjectParagraphService redisSubjectParagraphService;

    @Override
    public int insertExt(Subject record) {
        record.setCreateDate(new Date());
        record.setUpdateDate(new Date());
        record.setCreateUser(record.getOwnerId());
        record.setUpdateUser(record.getOwnerId());
        return subjectMapperExt.insertExt(record);
    }

    @Override
    public int insertSelectiveExt(Map<String, Object> params) throws BusinessException {
        Subject subject;
        List<SubjectParagraph> paragraphs = new ArrayList<>();
        try {
            subject = new Subject();
            BeanMapUtil.map2Bean((Map<String, Object>) params.get("subject"), subject);
            List<Map<String,Object>> paragraphList = (List<Map<String,Object>>) params.get("paragraphs");
            if(!paragraphList.isEmpty()){
                for(Map<String,Object> p : paragraphList){
                    SubjectParagraph sp = new SubjectParagraph();
                    BeanMapUtil.map2Bean(p, sp);
                    if(StringUtils.isEmpty(sp.getParagraph()) && sp.getImgSrc().equals("[]")){
                        continue;
                    }else{
                        paragraphs.add(sp);
                    }
                }
            }
        }catch (Exception ex){
            throw new BusinessException("subject or paragraphs is required", ex);
        }
        if(StringUtils.isEmpty(subject.getSubjectClassifyCode())){
            throw new BusinessException("subjectClassifyCode is required");
        }
        if(StringUtils.isEmpty(subject.getSubject())){
            throw new BusinessException("subject is required");
        }
        if(StringUtils.isEmpty(subject.getOwnerId())){
            throw new BusinessException("ownerId is required");
        }
        if(StringUtils.isEmpty(subject.getOwnerName())){
            throw new BusinessException("ownerName is required");
        }
        subject.setCreateUser(subject.getOwnerId());
        subject.setUpdateUser(subject.getOwnerId());
        subject.setCreateDate(new Date());
        subject.setUpdateDate(new Date());
        int result = subjectMapperExt.insertSelectiveExt(subject);

        for(SubjectParagraph p:paragraphs){
            p.setSubjectId(subject.getSubjectId());
            subjectParagraphMapperExt.insertSelectiveExt(p);
        }

        return result;
    }

    @Override
    public void insertTask(Subject subject, List<SubjectParagraph> paragraphs){
        //insert task
        Map<String, Object> requestMap = new HashMap();
        //requestMap.put("userid", "@all");
        requestMap.put("title", subject.getSubject());
        requestMap.put("description", paragraphs.get(0).getParagraph());
        String address = "/follow?subjectId=" + subject.getSubjectId();
        /*address = new StringBuffer()
                .append("/page?html=")
                .append(Base64.encode(address.getBytes()))
                .append("&token=")
                .append(SignatureUtil.getToken(subject.getOwnerId(), String.valueOf(subject.getSubjectId())))
                .toString();*/
        address = new StringBuffer()
                .append("/index?page=")
                .append(Base64.encode(address.getBytes()))
                .toString();
        requestMap.put("url", address);

        ClassifyGroupExample example = new ClassifyGroupExample();
        example.createCriteria().andSubjectClassifyCodeEqualTo(subject.getSubjectClassifyCode());
        List<ClassifyGroup> cgms = classifyGroupMapperExt.selectByExample(example);
        for(ClassifyGroup cg : cgms){
            String[] acs = cg.getAncestors().split(",");
            if(acs.length < 5){
                requestMap.put("userid", "@all");
                pushSubjectTaskService.send(requestMap, NitificationTypeEnum.all);
            }else{
                requestMap.put("deptId", cg.getGroupCode());
                requestMap.put("ancestors", cg.getAncestors());
                pushSubjectTaskService.send(requestMap, NitificationTypeEnum.dept);
            }
            break;
        }
        /*Task task = new Task();
        task.setKeyProperty(subject.getSubjectId());
        task.setRequestBody(JSONObject.toJSONString(requestMap));
        task.setTaskType(TaskScheduledTypeEnum.subjectPush.name());
        task.setStatus(TaskScheduledStatusEnum.waiting.name());
        task.setCreateTime(new Date());
        task.setCreateUser(ColleagueBarConstants.systemUser);
        taskMapperExt.insertSelectiveExt(task);*/
    }

    @Transactional
    @Caching(
            evict = {
                    @CacheEvict(value = "cache.subject.list.view", allEntries = true),
                    @CacheEvict(value = "cache.paragraph.bypid.list", key = "#subjectId", condition="#subjectId != null")
            }
    )
    @Override
    public Integer saveOrUpdateSelectiveExt(Integer subjectId, Map<String, Object> params) throws BusinessException {
        int result = 0;
        Subject subject;
        List<SubjectParagraph> paragraphs = new ArrayList<>();
        try {
            subject = new Subject();
            BeanMapUtil.map2Bean((Map<String, Object>) params.get("subject"), subject);
            List<Map<String,Object>> paragraphList = (List<Map<String,Object>>) params.get("paragraphs");
            if(!paragraphList.isEmpty()){
                for(Map<String,Object> p : paragraphList){
                    SubjectParagraph sp = new SubjectParagraph();
                    BeanMapUtil.map2Bean(p, sp);
                    if(StringUtils.isEmpty(sp.getParagraph()) && sp.getImgSrc().equals("[]")){
                        continue;
                    }else{
                        paragraphs.add(sp);
                    }
                }
            }
        }catch (Exception ex){
            throw new BusinessException("subject or paragraphs is required", ex);
        }
        if(StringUtils.isEmpty(subject.getSubjectClassifyCode())){
            throw new BusinessException("subjectClassifyCode is required");
        }
        if(StringUtils.isEmpty(subject.getSubject())){
            throw new BusinessException("subject is required");
        }
        if(StringUtils.isEmpty(subject.getOwnerId())){
            throw new BusinessException("ownerId is required");
        }
        if(StringUtils.isEmpty(subject.getOwnerName())){
            throw new BusinessException("ownerName is required");
        }
        if(StringUtils.isEmpty(subjectId)){
            subject.setCreateUser(subject.getOwnerId());
            subject.setUpdateUser(subject.getOwnerId());
            subject.setCreateDate(new Date());
            subject.setUpdateDate(new Date());
            subject.setRemoveFlag(PublicEnum.N.name());
            subject.setTopStick(TopStickEnum.normal.name());
            redisSubjectService.save(subject);

            for(SubjectParagraph p:paragraphs){
                p.setSubjectId(subject.getSubjectId());
                subjectParagraphMapperExt.insertSelectiveExt(p);
            }

            insertTask(subject, paragraphs);
        }else{
            subject.setSubjectId(subjectId);
            subject.setUpdateDate(new  Date());
            redisSubjectService.update(subject);
            for(SubjectParagraph p:paragraphs){
                if(StringUtils.isEmpty(p.getParagraphId())){
                    p.setSubjectId(subjectId);
                    subjectParagraphMapperExt.insertSelectiveExt(p);
                }else{
                    subjectParagraphMapperExt.updateByPrimaryKeySelective(p);
                }
            }
        }
        return result;
    }

    @Override
    public void deleteSubject(Integer subjectId) throws BusinessException {
        if(subjectId == null){
            throw new BusinessException("subjectId is Required");
        }
        SubjectFollowExample example = new SubjectFollowExample();
        example.createCriteria().andSubjectIdEqualTo(subjectId);
        //删除所有跟帖
        subjectFollowMapperExt.deleteByExample(example);
        //删除关注
        SubjectCollectionExample subjectCollectionExample = new  SubjectCollectionExample();
        subjectCollectionExample.createCriteria().andSubjectIdEqualTo(subjectId);
        subjectCollectionMapperExt.deleteByExample(subjectCollectionExample);
        //删除点赞
        SubjectGoodPointExample subjectGoodPointExample = new SubjectGoodPointExample();
        subjectGoodPointExample.createCriteria().andSubjectIdEqualTo(subjectId);
        subjectGoodPointMapperExt.deleteByExample(subjectGoodPointExample);
        //删除跟帖回复
        subjectReplyService.deleteBySubject(subjectId);
        //删除主题
        subjectMapperExt.deleteByPrimaryKey(subjectId);
    }

    /***
     * 删除主题，设置删除标记
     * @param bean
     * @throws ValidationException
     */
    @Override
    @Caching(
            evict={
                    @CacheEvict(value = "cache.subject.list.view", allEntries = true),
            }
    )
    public void deleteSubjectSoft(Subject bean) throws ValidationException {
        if(bean.getSubjectId() == null || StringUtils.isEmpty(bean.getUpdateUser())){
            throw new ValidationException("subjectId and updateUser is required");
        }
        bean.setUpdateDate(new Date());
        bean.setRemoveFlag(PublicEnum.Y.name());
        subjectMapperExt.updateByPrimaryKeySelective(bean);
    }

    /***
     * 查询主题列表，
     * 采用cache:主题列表
     * 阅读数量变化快，内存中计算
     * @param queryParam queryParam
     * @param pageSize pageSize
     * @param fixable 是否固定查询，   false：上拉加载，下拉加载
     * @return List
     * @throws Exception throw
     */
    @Override
    @Cacheable(value = "cache.subject.list.view", key = "#queryParam['subjectClassifyCode'] + '_'+#queryParam['keywords'] + '_' +#queryParam['startRow'] + '_' +#queryParam['endRow']+#queryParam['userId']+#fixable")
    public List<Map<String, Object>>  list(Map<String, Object> queryParam, Integer pageSize, boolean fixable) throws Exception {
        if(CommonMapUtils.isBlankByKey(queryParam,"userId")){
            throw new Exception("userId is required");
        }
        if(fixable){
            queryParam.put("topStick", TopStickEnum.top.name());
        }else{
            queryParam.put("topStick", TopStickEnum.normal.name());
            if(MapUtils.getInteger(queryParam, "endRow") == null){
                queryParam.put("endRow", 0);
            }
        }
        if("9999".equals(MapUtils.getString(queryParam, "subjectClassifyCode"))){
            queryParam.put("subjectClassifyCode", null);
        }else if("9988".equals(MapUtils.getString(queryParam, "subjectClassifyCode"))){
            queryParam.put("subjectClassifyCode", null);
            queryParam.put("collectionFlag", 1);
        }
        queryParam.put("pageSize", pageSize);
        List<Map<String, Object>> list = subjectMapperExt.queryListByParam(queryParam);

        if(fixable){
            if(!list.isEmpty() && MapUtils.getInteger(queryParam, "startRow") != null){
                Collections.reverse(list);
            }
        }

        for(Map<String, Object> item:list){
            String imgSrc = MapUtils.getString(item, "imgSrc");
            if(!StringUtils.isEmpty(imgSrc)){
                List<Map<String, Object>> imgs = (List<Map<String, Object>>) JSONObject.parse(imgSrc);
                item.put("paraImages", imgs);
            }
        }
        return list;
    }

    @Override
    public void loadReadAmount(List<Map<String, Object>> list){
        for(Map<String, Object> item:list){
            Integer objectId = MapUtils.getInteger(item, "subjectId");
            //加载 阅览数
            SubjectReadAmount subjectReadAmount = subjectReadService.countAction(objectId);
            item.put("subjectReadAmount", subjectReadAmount);
            //switch to redis load
            /*long count = userActionService.countAction(MapUtils.getInteger(item, "subjectId"));
            item.put("readCount", count);*/
        }
    }

    @Override
    public Map<String, Object> queryByParam(Integer subjectId, Map<String, Object> params) throws BusinessException {
        String userId = MapUtils.getString(params, "userId");
        params.put("subjectId", subjectId);

        //加载主题信息
        Map<String, Object> result = querySubjectByParam(subjectId, params);

        //加载点赞信息
        SubjectGoodPoint subjectGoodPoint = redisSubjectGoodPointService.findByKeys(subjectId, userId, ColleagueTextTypeEnum.subject.name());
        Integer cGoodPoint = 0;
        if(subjectGoodPoint != null){
            cGoodPoint = subjectGoodPoint.getGoodPoint();
        }
        Subject subject = (Subject)result.get("subject");
        subject.setGoodPoint(cGoodPoint);

        //加载关注信息
        SubjectCollection subjectCollection = redisSubjectCollectionService.findByKeys(subjectId, userId);
        Integer collectionFlag = 0;
        if(subjectCollection != null){
            collectionFlag = subjectCollection.getCollectionFlag();
        }
        subject.setCollectionFlag(collectionFlag);
        //统计点赞数
        Long goodPointCount = redisSubjectGoodPointService.count(subjectId, ColleagueTextTypeEnum.subject.name());
        subject.setGoodPointCount(goodPointCount);
        //统计关注数
        //通知回复数
        long followCount = redisSubjectFollowService.countFollows(subjectId);
        subject.setFollowCount(followCount);
        return result;
    }

    public Map<String, Object> querySubjectByParam(Integer subjectId, Map<String, Object> params) throws BusinessException {
        // 查询当前用户关注状态
        Map<String, Object> result = new HashMap<>();
        params.put("subjectId", subjectId);
        Subject subject = this.redisSubjectService.findByKeys(subjectId);
        if(subject == null){
            throw new BusinessException("作者已删除帖子，未查询到主题帖");
        }
        subject.setSubjectClassifyName(subjectClassifyService.getClassifyName(subject.getSubjectClassifyCode()));
        result.put("subject", subject);
        List<SubjectParagraph> ps = redisSubjectParagraphService.findAllByParentId(subjectId);
        result.put("paragraphs", ps);
        return result;
    }

    @Override
    public Subject queryById(Integer subjectId) {
        return this.redisSubjectService.findByKeys(subjectId);
    }

    @Override
    public Map<String, Object> queryMyAttention(Map<String, Object> queryParam) {
        return subjectMapperExt.queryMyAttention(queryParam);
    }
}
