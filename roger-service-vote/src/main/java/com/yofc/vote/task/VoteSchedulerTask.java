package com.yofc.vote.task;

import com.yofc.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class VoteSchedulerTask {

    @Autowired
    private com.yofc.vote.service.VoteService VoteService;

    @Scheduled(cron = "0 0/5 * * * ? ")
    public void monitorVote() {
        VoteService.updateVoteStatus();
    }

}
