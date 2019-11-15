package com.yofc.vote.service.impl;

import com.yofc.dal.vote.entity.VoteRecord;
import com.yofc.dal.vote.mapper.VoteMapperExt;
import com.yofc.dal.vote.mapper.VoteRecordMapperExt;
import com.yofc.dal.vote.mapper.VoteSubjectItemMapperExt;
import com.yofc.dal.vote.mapper.VoteSubjectMapperExt;
import com.yofc.vote.service.RedisVoteService;
import com.yofc.vote.service.VoteDetailService;
import com.yofc.vote.service.VoteRecordService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class VoteDetailServiceImpl implements VoteDetailService {

    @Autowired
    private VoteRecordService voteRecordService;

    @Autowired
    private VoteMapperExt voteMapperExt;

    @Autowired
    private VoteSubjectMapperExt voteSubjectMapperExt;

    @Autowired
    private VoteSubjectItemMapperExt voteSubjectItemMapperExt;

    @Autowired
    private VoteRecordMapperExt voteRecordMapperExt;

    @Autowired
    private RedisVoteService redisVoteService;
    /**
     * TODO 加cache
     */
    @Override
    public Map<String, Object> queryEmptyVote(Integer voteId) {
        return redisVoteService.queryEmptyVote(voteId);
    }

    @Override
    public Map<String, Object> queryFilledVote(Integer voteId, String userId) {
        Map<String, Object> result = queryEmptyVote(voteId);
        if (!StringUtils.isEmpty(userId)) {
            List<VoteRecord> voteRecords = voteRecordService.queryVoteRecordDetail(voteId, userId);
            Map<Integer, Object> tempMap = new HashMap<>();
            for (VoteRecord item : voteRecords) {
                tempMap.put(item.getVoteSubjectItemId(), item);
            }

            List<Map<String, Object>> voteSubjects = (List<Map<String, Object>>) result.get("voteSubjects");
            for (Map<String, Object> item : voteSubjects) {
                List<Map<String, Object>> subjectItems = (List<Map<String, Object>>) item.get("subjectItem");
                String voteOther = null;
                Integer voteOtherId = null;
                List<Integer> checkList = new ArrayList<>();
                for (Map<String, Object> one : subjectItems) {
                    Object obj = tempMap.get(one.get("voteItemId"));
                    if (obj != null) {
                        //没有选择改项
                        checkList.add((Integer) one.get("voteItemId"));
                        String tempOther = ((VoteRecord) obj).getVoteSubjectItemOther();
                        if (!StringUtils.isEmpty(tempOther)) {
                            voteOther = tempOther;
                        }
                    }

                }
                item.put("shwoOtherInput", !StringUtils.isEmpty(voteOther));
                item.put("voteOther", voteOther);
                item.put("checkList", checkList);
            }
        }
        return result;
    }

    @Override
    public void saveVoteRecord(Integer voteId, Map<String, Object> param) {
        String userId = MapUtils.getString(param, "userId");
        String userName = MapUtils.getString(param, "userName");
        List<Map<String, Object>> list = (List<Map<String, Object>>) param.get("voteResult");
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> tempList = list.get(i);
            Integer voteSubjectId = (Integer) tempList.get("voteSubjectId");
            List<Integer> checkList = (List<Integer>) tempList.get("checklist");
            String voteOther = (String) tempList.get("voteOther");
            for (int m = 0; m < checkList.size(); m++) {
                Integer id = checkList.get(m);
                VoteRecord vr = new VoteRecord();
                vr.setVoteId(voteId);
                vr.setVoteSubjectId(voteSubjectId);
                vr.setVoteSubjectItemId(id);
                vr.setVoteUserId(userId);
                vr.setVoteUserName(userName);
                vr.setVoteDate(new Date());
                if (m == (checkList.size() - 1) && !StringUtils.isEmpty(voteOther)) {
                    vr.setVoteSubjectItemOther(voteOther);
                }
                voteRecordService.save(vr);
            }
        }
    }

    /***
     * 统计投票结果
     * */
    @Override
    //@Cacheable(value = "cache.countVoteSubject4Summary", key = "#voteId")
    public List<Map<String, Object>> countVoteSubject4Summary(Integer voteId) {
        Map<String, Object> param = new HashMap<>();
        param.put("voteId", voteId);
        List<Map<String, Object>> voteCount = voteRecordMapperExt.countVoteSubject4Summary(param);
        Map<Integer, Object> voteCountMap = voteCount2Map(voteCount);
        Map<String, Object> emptyVote = queryEmptyVote(voteId);
        List<Map<String, Object>> emptyVoteSubject = (List<Map<String, Object>>) emptyVote.get("voteSubjects");
        for (Map<String, Object> item : emptyVoteSubject) {
            List<Map<String, Object>> subjectItems = (List<Map<String, Object>>) item.get("subjectItem");
            for (Map<String, Object> one : subjectItems) {
                Integer voteItemId = (Integer) one.get("voteItemId");
                one.put("voteCount", voteCountMap.get(voteItemId));
            }
        }
        return emptyVoteSubject;
    }

    protected Map<Integer, Object> voteCount2Map(List<Map<String, Object>> voteCount){
        Map<Integer, Object> result = new HashMap<>();
        for(Map<String, Object> item : voteCount){
            result.put((Integer) item.get("voteItemId"), item.get("voteCount"));
        }
        return result;
    }
}
