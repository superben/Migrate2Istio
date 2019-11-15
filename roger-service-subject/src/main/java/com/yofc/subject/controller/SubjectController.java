package com.yofc.subject.controller;

import com.yofc.common.bean.BusinessException;
import com.yofc.common.bean.MessageJson;
import com.yofc.dal.subject.entity.Subject;
import com.yofc.common.enums.ColleagueTextTypeEnum;
import com.yofc.subject.service.MessageService;
import com.yofc.subject.service.SubjectCollectionService;
import com.yofc.subject.service.SubjectGoodPointService;
import com.yofc.subject.service.SubjectService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/subject")
public class SubjectController {

    @Value("${web.dropPageSize}")
    private Integer dropPageSize;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SubjectCollectionService subjectCollectionService;

    @Autowired
    private SubjectGoodPointService subjectGoodPointService;

    @Autowired
    private MessageService messageService;
    /**
     * 查询所有主题
     * @param queryParam queryParamqueryMyAttention
     * @return MessageJson
     */
    @PostMapping(value = "/list" , produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public MessageJson list(@RequestBody Map<String, Object> queryParam){
        MessageJson message = new MessageJson();
        try{
            Map<String, Object> data = new HashMap<>();
            List<Map<String, Object>> subjects = subjectService.list(queryParam, dropPageSize, false);
            subjectService.loadReadAmount(subjects);
            boolean loadTopStick = false;
            if(queryParam.get("loadTopStick") != null) {
                loadTopStick = MapUtils.getBoolean(queryParam, "loadTopStick");
            }
            if(loadTopStick){
                List<Map<String, Object>> topStickSubjects = subjectService.list(queryParam, 5, true);
                subjectService.loadReadAmount(topStickSubjects);
                data.put("topStickSubjects", topStickSubjects);
            }
            data.put("subjects", subjects);
            message.setData(data);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg("查询主题接口异常！" + ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

    /**
     * 查询一个主题详情
     * @param subjectId
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/detail/{subjectId}", produces = {"application/json;charset=UTF-8"})
    public MessageJson queryByParam(@PathVariable("subjectId") Integer subjectId, @RequestBody Map<String, Object> queryParam){
        MessageJson message = new MessageJson();
        try{
            Map<String, Object> subject = subjectService.queryByParam(subjectId, queryParam);
            message.setData(subject);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

    /**
     * 查询一个主题
     * @param subjectId
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/{subjectId}", produces = {"application/json;charset=UTF-8"})
    public MessageJson queryById( @PathVariable("subjectId") Integer subjectId){
        MessageJson message = new MessageJson();
        try{
            Subject subject = subjectService.queryById(subjectId);
            message.setData(subject);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

    /**
     * 新增主题
     * @param bean
     * @return
     */
    @PostMapping(value= "", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public MessageJson save(@RequestBody Map<String, Object> bean)  {
        MessageJson message = new MessageJson();
        try{
            subjectService.saveOrUpdateSelectiveExt(null, bean);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

    /**
     * 修改主题
     * @param subjectId subjectId
     * @param bean bean
     * @return
     */
    @PostMapping(value= "/{subjectId}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public MessageJson update(@PathVariable("subjectId") Integer subjectId, @RequestBody Map<String, Object> bean)  {
        MessageJson message = new MessageJson();
        try{
            subjectService.saveOrUpdateSelectiveExt(subjectId, bean);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
        }
        return message;
    }

    /**
     * 删除主题
     * @param bean bean
     * @return
     */
    @PostMapping(value= "/d", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public MessageJson deleteSubject(@RequestBody Subject bean)  {
        MessageJson message = new MessageJson();
        try{
            if(bean != null){
                subjectService.deleteSubjectSoft(bean);
                message.setSuccess(true);
                message.setMsg(MessageJson.SUCCESS);
            }
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
        }
        return message;
    }

    /**
     *主题点赞
     * @param subjectId
     * @param params
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/goodPoint/{subjectId}", produces = {"application/json;charset=UTF-8"})
    public MessageJson setGoodPoint(@PathVariable("subjectId") Integer subjectId, @RequestBody Map<String, Object> params){
        MessageJson message = new MessageJson();
        try{
            Integer goodPoint = subjectGoodPointService.setGoodPoint(subjectId, ColleagueTextTypeEnum.subject.toString(), params);
            message.setData(goodPoint);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
        }
        return message;
    }

    @ResponseBody
    @PostMapping(value = "/goodPoint", produces = {"application/json;charset=UTF-8"})
    public MessageJson setGoodPointList(@RequestBody Map<String, Object> params){
        MessageJson message = new MessageJson();
        try{
            List<Map<String, Object>>result = subjectGoodPointService.setGoodPointList(params);
            message.setData(result);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            ex.printStackTrace();
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
        }
        return message;
    }

    /**
     * 关注主题贴
     * @param subjectId subjectId
     * @param params params
     * @return MessageJson
     */
    @ResponseBody
    @PostMapping(value = "/collection/{subjectId}", produces = {"application/json;charset=UTF-8"})
    public MessageJson collection(@PathVariable("subjectId") Integer subjectId, @RequestBody Map<String, Object> params){
        MessageJson message = new MessageJson();
        try{
            Integer collectionFlag = subjectCollectionService.setCollectionFlag(subjectId, params);
            message.setData(collectionFlag);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

    @ResponseBody
    @PostMapping(value = "/attention", produces = {"application/json;charset=UTF-8"})
    public MessageJson myAttention( @RequestBody Map<String, Object> params){
        MessageJson message = new MessageJson();
        try{
            if(params.get("userId") == null){
                throw new BusinessException("userId is required");
            }
            Map<String, Object> myAttention = subjectService.queryMyAttention(params);
            Long hasNewMessage = messageService.countMessage(MapUtils.getString(params, "userId"));
            myAttention.put("hasNewMessage", hasNewMessage);
            message.setData(myAttention);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }
}
