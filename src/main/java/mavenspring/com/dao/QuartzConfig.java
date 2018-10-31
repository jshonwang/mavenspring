package mavenspring.com.dao;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class QuartzConfig {
	@Bean
	public JobDetail teatQuartzDetail(){
		return JobBuilder.newJob(TestQuartz.class).withIdentity("testQuartz").storeDurably().build();
	}
	@Bean
	public Trigger testQuartzTrigger(){
		SimpleScheduleBuilder schedualBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(10)     //设置时间周期
				.repeatForever();
		return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
                .withIdentity("testQuartz")
                .withSchedule(schedualBuilder)
                .build();

		
	}

}
