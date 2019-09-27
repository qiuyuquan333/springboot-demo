package com.qyq.scheduled.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 可以传参
 */
public class MyJob2 extends QuartzJobBean {

    PlayService playService;

    public PlayService getPlayService() {
        return playService;
    }

    public void setPlayService(PlayService playService) {
        this.playService = playService;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        playService.play();
    }
}
