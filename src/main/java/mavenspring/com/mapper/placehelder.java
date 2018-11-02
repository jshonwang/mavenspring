package mavenspring.com.mapper;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

@Configuration
public class placehelder {
	@Bean
	public PageHelper pageHelder(){
		PageHelper pageHelper = new PageHelper();
		Properties p = new Properties();
		  //1.offsetAsPageNum:设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用.

		p.setProperty("offsetAsPageNum", "true");
		//2.rowBoundsWithCount:设置为true时，使用RowBounds分页会进行count查询.
		p.setProperty("rowBoundsWithCount", "true");
		//3.reasonable：启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页。
		p.setProperty("reasonable", "true");
		pageHelper.setProperties(p);
		return pageHelper;
		

		
		
	}

}
