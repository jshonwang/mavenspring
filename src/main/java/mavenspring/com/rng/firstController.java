package mavenspring.com.rng;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication 
@MapperScan("mavenspring.com.mapper")
//@EnableEurekaClient
public class firstController {
	/**
	 * springboot应用的启动类
	 * @param args
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(firstController.class,args);
	}

}
