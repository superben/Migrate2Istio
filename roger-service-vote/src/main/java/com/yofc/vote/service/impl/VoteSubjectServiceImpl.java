package com.yofc.vote.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yofc.common.util.BeanMapUtil;
import com.yofc.dal.vote.entity.VoteSubject;
import com.yofc.dal.vote.entity.VoteSubjectExample;
import com.yofc.dal.vote.entity.VoteSubjectItem;
import com.yofc.dal.vote.mapper.VoteSubjectMapperExt;
import com.yofc.vote.service.VoteSubjectItemService;
import com.yofc.vote.service.VoteSubjectService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VoteSubjectServiceImpl implements VoteSubjectService {

    @Autowired
    private VoteSubjectMapperExt voteSubjectMapperExt;

    @Autowired
    private VoteSubjectItemService voteSubjectItemService;

    @Override
    public PageInfo<Map<String, Object>> list(Map<String, Object> queryParam, Integer pageNum, Integer pageSize) {
        VoteSubjectExample example = new VoteSubjectExample();
        example.createCriteria().andVoteIdEqualTo(MapUtils.getInteger(queryParam, "voteId"));
        PageHelper.startPage(pageNum, pageSize);
        List<VoteSubject> list = voteSubjectMapperExt.selectByExample(example);
        PageInfo result = new PageInfo(list);
        return result;
    }

    @Override
    public VoteSubject findByKeys(Integer id) {
        return voteSubjectMapperExt.selectByPrimaryKey(id);
    }

    @Override
    public List<VoteSubject> findByParentKey(Integer voteId) {
        VoteSubjectExample example = new VoteSubjectExample();
        example.createCriteria().andVoteIdEqualTo(voteId);
        return voteSubjectMapperExt.selectByExample(example);
    }

    @Override
    public void save(VoteSubject bean) {
        voteSubjectMapperExt.insertSelective(bean);
    }

    @Override
    public void delete(VoteSubject bean) {
        voteSubjectMapperExt.deleteByPrimaryKey(bean.getVoteSubjectId());
    }

    @Override
    public void saveOrUpdate(VoteSubject voteSubject) {
        if (voteSubject.getVoteSubjectId() == null) {
            voteSubjectMapperExt.insertSelectiveExt(voteSubject);
        } else {
            voteSubjectMapperExt.updateByPrimaryKeySelective(voteSubject);
        }
    }

    @Override
    public void saveOrUpdateSubject(List<Map<String, Object>> voteSubjects, Integer voteId) {
        for (Map<String, Object> item : voteSubjects) {
            VoteSubject voteSubject = new VoteSubject();
            BeanMapUtil.map2Bean(item, voteSubject);
            voteSubject.setVoteId(voteId);
            saveOrUpdate(voteSubject);

            voteSubjectItemService.deleteOthers((Integer) item.get("voteSubjectId"));
            List<Map<String, Object>> subjectItems = (List<Map<String, Object>>) item.get("subjectItem");
            for (Map<String, Object> one : subjectItems) {
                VoteSubjectItem voteSubjectItem = new VoteSubjectItem();
                BeanMapUtil.map2Bean(one, voteSubjectItem);
                voteSubjectItem.setVoteSubjectId(voteSubject.getVoteSubjectId());
                voteSubjectItemService.saveOrUpdate(voteSubjectItem);
            }

        }
    }

}
