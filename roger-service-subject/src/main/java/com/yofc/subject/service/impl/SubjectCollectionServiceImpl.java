package com.yofc.subject.service.impl;

import com.yofc.common.bean.BusinessException;
import com.yofc.common.util.BeanMapUtil;
import com.yofc.common.util.CommonMapUtils;
import com.yofc.dal.subject.entity.SubjectCollection;
import com.yofc.dal.subject.entity.SubjectCollectionExample;
import com.yofc.dal.subject.mapper.SubjectCollectionMapperExt;
import com.yofc.subject.service.SubjectCollectionService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SubjectCollectionServiceImpl implements SubjectCollectionService {

    @Autowired
    private SubjectCollectionMapperExt subjectCollectionMapperExt;

    @Override
    public Integer setGoodPoint(Integer subjectId, Map<String, Object> param) throws BusinessException {
        SubjectCollection subjectCollection;
        String userId = MapUtils.getString(param, "goodPointUserId");
        if(StringUtils.isEmpty(userId)){
            throw new BusinessException("goodPointUserId is Required");
        }
        SubjectCollectionExample example = new SubjectCollectionExample();
        example.createCriteria().andSubjectIdEqualTo(subjectId).andGoodPointUserIdEqualTo(userId);
        List<SubjectCollection> subjectCollections = subjectCollectionMapperExt.selectByExample(example);
        if(subjectCollections != null && !subjectCollections.isEmpty()){
            subjectCollection = new SubjectCollection();
            subjectCollection.setGoodPoint(subjectCollections.get(0).getGoodPoint()==0 ? 1: 0);
            subjectCollectionMapperExt.updateByExampleSelective(subjectCollection, example);
        }else{

            subjectCollection = new SubjectCollection();
            subjectCollection.setGoodPoint(1);
            subjectCollection.setCollectionFlag(0);
            subjectCollection.setSubjectId(subjectId);
            BeanMapUtil.map2Bean(param, subjectCollection);
            subjectCollectionMapperExt.insertSelectiveExt(subjectCollection);
        }
        return subjectCollection.getGoodPoint();
    }

    @Override
    public Integer setCollectionFlag(Integer subjectId, Map<String, Object> param) throws BusinessException {
        SubjectCollection subjectCollection;
        String userId = MapUtils.getString(param, "collectionUserId");
        if(StringUtils.isEmpty(userId)){
            throw new BusinessException("collectionUserId is Required");
        }
        if(CommonMapUtils.isBlankByKey(param, "collectionUserName")){
            throw new BusinessException("collectionUserName is Required");
        }

        SubjectCollectionExample example = new SubjectCollectionExample();
        example.createCriteria().andSubjectIdEqualTo(subjectId).andCollectionUserIdEqualTo(userId);
        List<SubjectCollection> subjectCollections = subjectCollectionMapperExt.selectByExample(example);
        if(subjectCollections != null && !subjectCollections.isEmpty()){
            subjectCollection = new SubjectCollection();
            subjectCollection.setCollectionFlag(subjectCollections.get(0).getCollectionFlag()==0 ? 1: 0);
            subjectCollection.setUpdateDate(new Date());
            subjectCollection.setUpdateUser((String) param.get("collectionUserId"));
            subjectCollectionMapperExt.updateByExampleSelective(subjectCollection, example);
        }else{
            subjectCollection = new SubjectCollection();
            subjectCollection.setGoodPoint(0);
            subjectCollection.setCollectionFlag(1);
            subjectCollection.setSubjectId(subjectId);
            subjectCollection.setCreateUser((String) param.get("collectionUserId"));
            subjectCollection.setUpdateUser((String) param.get("collectionUserId"));
            subjectCollection.setCreateDate(new Date());
            subjectCollection.setUpdateDate(new Date());
            BeanMapUtil.map2Bean(param, subjectCollection);
            subjectCollectionMapperExt.insertSelectiveExt(subjectCollection);
        }
        return subjectCollection.getCollectionFlag();
    }
}
