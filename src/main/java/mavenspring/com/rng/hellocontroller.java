package mavenspring.com.rng;

import java.text.DateFormat;
import java.util.Date;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class hellocontroller {
	
	@RequestMapping("/hel")
	public String star(Model m){
		m.addAttribute("now",DateFormat.getDateTimeInstance().format(new Date()));
		return "hello";
	}
	/*@RequestMapping("/redirec")
	public String save(Map<String,String> model){
		boot = bootinf.findByid(1);
		String username = boot.getUserName();
		model.put("boot",username);
		return "index";
		
		
		
	}*/

}
