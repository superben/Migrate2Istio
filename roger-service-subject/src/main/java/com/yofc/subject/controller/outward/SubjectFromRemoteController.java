package com.yofc.subject.controller.outward;

import com.yofc.common.bean.MessageJson;
import com.yofc.common.enums.ActionsType;
import com.yofc.dal.subject.entity.SubjectFrom;
import com.yofc.dal.vote.entity.Vote;
import com.yofc.subject.service.SubjectFromService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subject/public/subject")
@Api(value = "Subject")
public class SubjectFromRemoteController {

    @Autowired
    private SubjectFromService subjectFromService;

    @ApiOperation(value = "voteFrom查询", notes = "根据subjectId查询voteFrom")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "voteId", value = "投票编号", required = true, dataType = "Integer"),
            }
    )
    @ResponseBody
    @GetMapping(value= "/from/{subjectId}",  produces = {"application/json;charset=UTF-8"})
    public MessageJson findBySubjectId(@PathVariable("subjectId") Integer subjectId){
        MessageJson message = new MessageJson();
        try {
            SubjectFrom from = subjectFromService.findBySubjectId(subjectId);
            message.setData(from);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        } catch (Exception ex) {
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

    @ApiOperation(value = "vote删除，级联删除subject", notes = "修改VOTE删除标记")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "voteId", value = "投票编号", required = true, dataType = "Integer"),
            }
    )
    @ResponseBody
    @PostMapping(value = "/d/{voteId}", produces = {"application/json;charset=UTF-8"})
    public MessageJson deleteSubjectByVoteId(@PathVariable("voteId") Integer voteId) {
        MessageJson message = new MessageJson();
        try {
            subjectFromService.deleteSubjectByVoteId(voteId);
            message.setData(null);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        } catch (Exception ex) {
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

    /**
     * 新增投票
     *
     * @param
     * @return
     */
    @ApiOperation(value = "vote新增，级联新增subject", notes = "发起投票时，新增subject")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "vote", value = "投票实体", required = true, dataType = "Vote"),
            }
    )
    @ResponseBody
    @PostMapping(value = "", produces = {"application/json;charset=UTF-8"})
    public MessageJson save(@RequestBody Vote vote) {
        MessageJson message = new MessageJson();
        try {
            subjectFromService.saveCbSubject(vote, ActionsType.vote);
            message.setSuccess(true);
            message.setMsg(MessageJson.SUCCESS);
        } catch (Exception ex) {
            message.setMsg(ex.getMessage());
            message.setSuccess(false);
            ex.printStackTrace();
        }
        return message;
    }

}
