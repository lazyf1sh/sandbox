package one;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main implements Job
{
    public static void main(String[] args)
    {

        Scheduler scheduler = null;
        try
        {
            scheduler = new StdSchedulerFactory().getScheduler();
        }
        catch (SchedulerException e)
        {
            e.printStackTrace();
        }

        Trigger trigger1 = TriggerBuilder
                .newTrigger()
                .withIdentity(TriggerKey.triggerKey("key_first", "group_one"))
                .withSchedule(
                        CronScheduleBuilder.dailyAtHourAndMinute(23, 50)).build();

        Trigger trigger2 = TriggerBuilder
                .newTrigger()
                .withIdentity(TriggerKey.triggerKey("key_second", "group_one"))
                .withSchedule(
                        CronScheduleBuilder.dailyAtHourAndMinute(23, 50)).build();


        Set<Trigger> cronTriggers = new HashSet<Trigger>();

        cronTriggers.add(trigger1);
        cronTriggers.add(trigger2);


        JobDetail jobDetail = JobBuilder.newJob().ofType(Main.class)
                .withIdentity(JobKey.jobKey("jobKey", "group_one")).build();

        try
        {
            scheduler.scheduleJob(jobDetail, cronTriggers, true);
        }
        catch (SchedulerException e)
        {
            e.printStackTrace();
        }

        try
        {
            for (String groupName : scheduler.getJobGroupNames())
            {
                for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName)))
                {
                    String jobName = jobKey.getName();
                    String jobGroup = jobKey.getGroup();

                    //get job's trigger
                    List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
                    Date nextFireTime = triggers.get(0).getNextFireTime();

                    System.out.println("[jobName] : " + jobName + " [groupName] : " + jobGroup + " - " + nextFireTime);
                }
            }
        }
        catch (SchedulerException e)
        {
            e.printStackTrace();
        }


        try
        {
            scheduler.unscheduleJob(TriggerKey.triggerKey("key_second", "group_one"));
        }
        catch (SchedulerException e)
        {
            e.printStackTrace();
        }


        try
        {
            for (String groupName : scheduler.getJobGroupNames())
            {
                for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName)))
                {
                    String jobName = jobKey.getName();
                    String jobGroup = jobKey.getGroup();

                    //get job's trigger
                    List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
                    Date nextFireTime = triggers.get(0).getNextFireTime();

                    System.out.println("[jobName] : " + jobName + " [groupName] : " + jobGroup + " - " + nextFireTime);
                }
            }
        }
        catch (SchedulerException e)
        {
            e.printStackTrace();
        }


    }



    public void execute(JobExecutionContext context) throws JobExecutionException
    {

    }
}
