package com.chinaunicom.torn.mcloud.cronjob;

import com.xxl.job.core.handler.IJobHandler;


public class SyncDiscoveryInstanceSchedulerJob extends IJobHandler {
    @Override
    public void execute() throws Exception {
        System.out.println("This is MingChao Jin's first xxl-job.");

    }


//    @Override
//    protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
//        String areaKey = ctx.getJobDetail().getJobDataMap().getString(CronJobParam.AREA_ID.toString());
//
//        this.loggerService.info(SyncDiscoveryInstanceSchedulerJob.logFactory.product()
//                .how(LogHow.SCHEDULE).what(String.format("schedule sync [area: %s] discovery instances", areaKey)).build());
//
//        this.instanceService.syncDiscoveryInstance(areaKey);
//    }
}
