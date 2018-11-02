package mavenspring.com.util;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



 @Configuration
public class MyWebAppConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {   
  
    	registry.addResourceHandler("/Path/**").addResourceLocations("file:/F:/tet/images/");
        super.addResourceHandlers(registry);
    }
}  
