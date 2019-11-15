package com.yofc.subject.redis.service.impl;

import com.yofc.common.util.BeanMapUtil;
import com.yofc.dal.subject.entity.SubjectReadLog;
import com.yofc.common.enums.SummaryAmountTypeEnum;
import com.yofc.dal.subject.mapper.SubjectReadLogMapperExt;
import com.yofc.subject.redis.entity.SubjectReadAmount;
import com.yofc.subject.redis.repository.SubjectReadAmountRepository;
import com.yofc.subject.redis.repository.SubjectReadLogRepository;
import com.yofc.subject.redis.service.ISubjectReadRedisService;
import com.yofc.subject.redis.util.RedisIdsUtils;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/***
 * 主题阅读数
 * 主题点赞数
 * 缓存服务
 */
@Service
public class SubjectReadRedisServiceImpl implements ISubjectReadRedisService {
    private static final Logger log = LoggerFactory.getLogger(SubjectReadRedisServiceImpl.class);
    @Autowired
    private SubjectReadLogMapperExt subjectReadLogMapperExt;

    @Autowired
    private SubjectReadAmountRepository subjectReadAmountRepository;

    @Autowired
    private SubjectReadLogRepository subjectReadLogRepository;

    /**
     * 加载所有主题 阅读数，后续阅读次数再redis中完成计算
     * */
    @Override
    public void initSubjectReadAmount() {
        //1. count subject read amount from db
        //2. store to redis
        subjectReadAmountRepository.deleteAll();
        List<SubjectReadAmount> summary = summary(null);
        log.info("init redis variables SubjectReadAmount " + summary.size());
        subjectReadAmountRepository.saveAll(summary);
    }

    /***
     * 直接持久化用户行为
     * @param log log
     */
    @Override
    public void save(SubjectReadLog log) {
        //保存查看行为日志
        subjectReadLogMapperExt.insertSelectiveExt(log);
    }

    /***
     * 缓存用户阅读行为
     * @param log log
     */
    @Override
    public void saveToRedis(SubjectReadLog log) {
        //保存到redis
        log.setObjectId(log.getKeyCol());
        subjectReadLogRepository.save(log);
        //更新读取统计到redis
        updateAmount(log.getKeyCol(), SummaryAmountTypeEnum.read.name(), 1);
    }

    /***
     *  内存计算，阅读数，点赞数， 回帖数
     * @param objectId objectId
     * @param type type
     * @param num num
     */
    @Override
    public void updateAmount(Integer objectId, String type, int num) {
        //更新读取统计到redis
        SubjectReadAmount subjectReadAmount = null;
        Optional<SubjectReadAmount> optional = subjectReadAmountRepository.findById(RedisIdsUtils.getSubjectSummaryId(objectId));
        if (optional.isPresent()) {
            subjectReadAmount = optional.get();
            if (subjectReadAmount != null) {
                if (SummaryAmountTypeEnum.read.name().equals(type)) {
                    subjectReadAmount.setReadAmount(subjectReadAmount.getReadAmount() + num);
                } else if (SummaryAmountTypeEnum.goodPoint.name().equals(type)) {
                    subjectReadAmount.setGoodPointAmount(subjectReadAmount.getGoodPointAmount() + num);
                } if (SummaryAmountTypeEnum.reply.name().equals(type)) {
                    subjectReadAmount.setFollowAmount(subjectReadAmount.getFollowAmount() + num);
                }
                subjectReadAmountRepository.save(subjectReadAmount);
            }
        }
        if (optional == null || subjectReadAmount == null) {
            subjectReadAmount = new SubjectReadAmount();
            subjectReadAmount.setId(RedisIdsUtils.getSubjectSummaryId(objectId));
            subjectReadAmount.setObjectId(objectId);
            if (SummaryAmountTypeEnum.read.name().equals(type)) {
                subjectReadAmount.setReadAmount(1l);
                subjectReadAmount.setFollowAmount(0l);
                subjectReadAmount.setGoodPointAmount(0l);
            } else if (SummaryAmountTypeEnum.goodPoint.name().equals(type)) {
                subjectReadAmount.setGoodPointAmount(num < 1 ? 0 : 1l);
                subjectReadAmount.setReadAmount(0l);
                subjectReadAmount.setFollowAmount(0l);
            } else if (SummaryAmountTypeEnum.reply.name().equals(type)) {
                subjectReadAmount.setReadAmount(0l);
                subjectReadAmount.setFollowAmount(1l);
                subjectReadAmount.setGoodPointAmount(0l);
            }
            subjectReadAmountRepository.save(subjectReadAmount);
        }
    }

    /***
     * 持久化用户阅读行为
     * redis-mysql
     * */
    @Override
    public void saveSubjectReadLogFromRedis() {
        Iterable<SubjectReadLog> subjectReadLogs = subjectReadLogRepository.findAll();
        for (SubjectReadLog item : subjectReadLogs) {
            subjectReadLogMapperExt.insertSelectiveExt(item);
            subjectReadLogRepository.delete(item);
        }
    }

    /**
     * 查询阅读数，点赞数
     * catchable
     */
    @Override
    public SubjectReadAmount countAction(Integer subjectId) {
        String id = RedisIdsUtils.getSubjectSummaryId(subjectId);
        Optional<SubjectReadAmount> optional = subjectReadAmountRepository.findById(id);
        if (!optional.isPresent()) {
            SubjectReadAmount empty = new SubjectReadAmount();
            empty.setObjectId(subjectId);
            empty.setId(id);
            empty.setGoodPointAmount(0l);
            empty.setFollowAmount(0l);
            empty.setReadAmount(0l);
            return empty;
        }
        return optional.get();
    }

    /***
     * 用途：用于内存中计算
     * 加载 阅读数，点赞数
     * */
    @Override
    public List<SubjectReadAmount> summary(Integer objectId) {
        Map<String, Object> param = new HashMap<>();
        param.put("subjectId", objectId);
        List<Map<String, Object>> result = subjectReadLogMapperExt.summary(param);
        List<SubjectReadAmount> finalResult = new ArrayList<>();
        for (Map<String, Object> item : result) {
            SubjectReadAmount subjectReadAmount = new SubjectReadAmount();
            objectId = MapUtils.getInteger(item, "objectId");
            BeanMapUtil.map2Bean(item, subjectReadAmount);
            subjectReadAmount.setId(RedisIdsUtils.getSubjectSummaryId(objectId));
            finalResult.add(subjectReadAmount);
            log.debug(finalResult.toString());
        }
        return finalResult;
    }
}
