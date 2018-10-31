package mavenspring.com.rng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mavenspring.com.entity.Admin;
import mavenspring.com.mapper.Service;
import mavenspring.com.util.encodeUtil;

@Controller
public class LoginController {
	@Autowired
	public Service service;
	
	public Admin admin;
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	@RequestMapping(value="/login")
	public String toLogin(){
		return "Login";
	}
	@RequestMapping(value="/loginexec")
	public String login(Admin admin,Model model){
		admin = service.getCheckAdminInfo(admin);
		if(admin==null){
			model.addAttribute("info","登录失败");
			return "Login";
		}
		return "dashboard";
	}
	
	@RequestMapping("register")
	public String toRegister(){
		return "Register";
	}
	@RequestMapping("registerexec")
	public String Register(Admin admin,Model model){
	String password  = admin.getPassword();
	if(password==null){
		model.addAttribute("registerfail", "密码为空");
		password = "";
	}
	encodeUtil encode = new encodeUtil(); 
	password = encode.encode(password);
	admin.setPassword(password);
	int count = service.insertAdminInfo(admin);
	if(count<=0){
		model.addAttribute("registerfail","注册失败");
		return "Register";
	}
		return "dashboard";
		
	}
	@RequestMapping("/userList")
	public String UserList(Model model){
		List<Admin> infoList = service.getUserList();
		if(infoList.size()<=0){
			model.addAttribute("getUserInfoFail", "获取失败");
		}
		model.addAttribute("infoList",infoList);
		return "UserList";
	}
	

}
