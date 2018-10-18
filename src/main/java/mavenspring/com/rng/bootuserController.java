package mavenspring.com.rng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mavenspring.com.entity.bootuser;
import mavenspring.com.mapper.bootuserMapper;

@Controller
public class bootuserController {
	@Autowired
	private bootuserMapper bootum;

	public bootuserMapper getBootum() {
		return bootum;
	}

	public void setBootum(bootuserMapper bootum) {
		this.bootum = bootum;
	}

	@RequestMapping("/requestmapper")
	public String test(Model model){
		model.addAttribute("bootuser",bootum.selectAll());
		return "listbootuser";
		
	}
	@RequestMapping("/addUser")
	public String addBoot(bootuser bootu){
		System.out.println("add============================");
		bootum.insertBoot(bootu);
		return "hello";
		
	}
	@RequestMapping("/updateUser")
	public String updateBoot(bootuser bootu){
		bootum.updateBoot(bootu);
		return "hello";
		
	}
}
