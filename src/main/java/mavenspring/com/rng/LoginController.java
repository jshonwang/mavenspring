package mavenspring.com.rng;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import mavenspring.com.entity.Admin;
import mavenspring.com.mapper.Service;
import mavenspring.com.mapper.UserListService;
import mavenspring.com.mapper.placeHelperService;
import mavenspring.com.util.encodeUtil;

@Controller
public class LoginController {
	@Autowired
	public Service service;
	@Autowired
	private placeHelperService psh;

	
	private UserListService ulservice;
	
	
	public UserListService getUlservice() {
		return ulservice;
	}
	public void setUlservice(UserListService ulservice) {
		this.ulservice = ulservice;
	}
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
	public String Register(@RequestParam("filename") MultipartFile file,Admin admin,Model model){
	String password  = admin.getPassword();
	if(file==null){
		
	}
	
	String filename = file.getOriginalFilename();
	String path = "F:/tet";
	String picPath = path+"/"+filename;
	File f = new File(path+"/"+filename);
	if(!f.getParentFile().exists()){
		f.getParentFile().mkdirs();
	}
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
			try {
				bos.write(file.getBytes());
				bos.flush();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	if(password==null){
		model.addAttribute("registerfail", "密码为空");
		password = "";
	}
	admin.setHeadPicture(picPath);
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
	@RequestMapping("/UserTypeList")
	public String getUserList(Model model,@RequestParam(value="start",defaultValue="0") int start,@RequestParam(value="size",defaultValue="5") int size){
		PageHelper.startPage(start, size,"id desc");
		List<Admin> adminList = psh.getAllUserListPage();
		System.out.println(adminList.size()+"=======================================");
		model.addAttribute("info", adminList);
		PageInfo<Admin> pi = new PageInfo<Admin>(adminList);
		model.addAttribute("page", pi);
		return "UserList";
		
	}
	

}
