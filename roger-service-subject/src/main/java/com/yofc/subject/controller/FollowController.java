package com.yofc.subject.controller;

import com.github.pagehelper.PageInfo;
import com.yofc.common.bean.BusinessException;
import com.yofc.common.bean.MessageJson;
import com.yofc.subject.config.WebConfig;
import com.yofc.dal.subject.entity.SubjectFollowWithBLOBs;
import com.yofc.dal.subject.entity.vo.SubjectFollowVO;
import com.yofc.common.enums.ColleagueTextTypeEnum;
import com.yofc.subject.service.SubjectFollowService;
import com.yofc.subject.service.SubjectGoodPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/api/subject/follow")
public class FollowController {

    @Autowired
    private WebConfig webConfig;

    @Autowired
    private SubjectFollowService subjectFollowService;

    @Autowired
    private SubjectGoodPointService subjectGoodPointService;

    /**
     * 查询所有跟帖
     * @param pageNum pageNum
     * @param queryParam queryParam
     * @return MessageJson
     */
    @PostMapping(value = "list/{pageNum}")
    @ResponseBody
    public MessageJson list(@PathVariable("pageNum") Integer pageNum, @RequestBody Map<String, Object> queryParam){
        MessageJson message = new MessageJson();
        try{
            if(pageNum < 1){
                pageNum = 1;
            }
            PageInfo<Map<String, Object>> follows = subjectFollowService.list(queryParam, pageNum, webConfig.getPageSize());
            message.setData(follows);
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
     * 查询一个主题和回复
     * @param followId
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/detail/{followId}", produces = {"application/json;charset=UTF-8"})
    public MessageJson queryByParam(@PathVariable("followId") Integer followId, @RequestBody Map<String, Object> queryParam){
        MessageJson message = new MessageJson();
        try{
            SubjectFollowVO subject = subjectFollowService.queryByParam(followId, queryParam);
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
    /**S
     * 新增跟帖
     * @param bean
     * @return
     */
    @ResponseBody
    @PostMapping(value= "",  produces = {"application/json;charset=UTF-8"})
    public MessageJson save(@RequestBody SubjectFollowWithBLOBs bean)  {
        MessageJson message = new MessageJson();
        try{
            subjectFollowService.insertSelectiveExt(bean);
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
     * NOUSE
     * 修改回复
     * @param followId followId
     * @param bean bean
     * @return
     */
    @PostMapping(value= "/{followId}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public MessageJson updateFollow(@PathVariable("followId") Integer followId, @RequestBody SubjectFollowWithBLOBs bean)  {
        MessageJson message = new MessageJson();
        try{
            bean.setFollowId(followId);
            subjectFollowService.updateFollow(bean);
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
     * 删除回复
     * @param follow follow
     * @return
     */
    @ResponseBody
    @PostMapping(value= "/d", produces = {"application/json;charset=UTF-8"})
    public MessageJson deleteFollow(@RequestBody SubjectFollowWithBLOBs follow)  {
        MessageJson message = new MessageJson();
        try{
            if(follow == null || follow.getFollowId() == null){
                throw new BusinessException("followId is Required");
            }
            subjectFollowService.deleteFollowId(follow.getSubjectId(), follow.getFollowId());
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
        }
        return message;
    }

    /**
     * 回复点赞
     * @param followId
     * @param params
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/goodPoint/{followId}", produces = {"application/json;charset=UTF-8"})
    public MessageJson setGoodPoint(@PathVariable("followId") Integer followId, @RequestBody Map<String, Object> params){
        MessageJson message = new MessageJson();
        try{
            Integer goodPoint = subjectGoodPointService.setGoodPoint(followId, ColleagueTextTypeEnum.follow.name(), params);
            message.setData(goodPoint);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        }catch (Exception ex){
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
        }
        return message;
    }
}
