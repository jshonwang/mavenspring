package mavenspring.com.rng;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mavenspring.com.entity.bootuser;
import mavenspring.com.util.ExcelUtil;



@RestController
public class hellocontroller {
	
	@RequestMapping("/hel")
	public String star(Model m){
		m.addAttribute("now",DateFormat.getDateTimeInstance().format(new Date()));
		return "hello";
	}
	
	@RequestMapping(value="/export")
	@ResponseBody
	public void export(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//获取数据
//		List<PageData> list = 
		//标题
		String title[] = {"id","性别","姓名"};
		//文件名
		String filename = "test.xls";
		bootuser boot = new bootuser();
		boot.setId(5);
		boot.setSex("1");
		boot.setUsername("kk");
		
		bootuser boot1 = new bootuser();
		boot.setId(6);
		boot.setSex("2");
		boot.setUsername("ll");
		
		bootuser boot3 = new bootuser();
		boot.setId(7);
		boot.setSex("3");
		boot.setUsername("ii");
		List<bootuser> list = new ArrayList<bootuser>();
		list.add(boot);
		list.add(boot1);
		list.add(boot3);
		//sheet名
		String sheetName = "学生信息表";
		String content[][] = {{"爱神的箭","爱神的箭","爱神的箭","爱神的箭","爱神的箭"},{"爱神的箭","爱神的箭","爱神的箭","爱神的箭","爱神的箭"},{"爱神的箭","爱神的箭","爱神的箭","爱神的箭","爱神的箭"}};
		HSSFWorkbook  wb = ExcelUtil.getHssfWorkbook(sheetName, title, content, null);
		for(int i=0;i<list.size();i++){
		}
		//响应到客户端 
		try{
			this.setResponseHeader(response, filename);
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
			
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		
		
		
		
	}
	public void setResponseHeader(HttpServletResponse response, String fileName){
		try {
			fileName = new String(fileName.getBytes(),"ISO8859-1");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/octet-stream;charset=ISO8859-1");
		response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
		response.addHeader("Pargam","no-cache");
		
		
			
	}
	
	/*@RequestMapping("/redirec")
	public String save(Map<String,String> model){
		boot = bootinf.findByid(1);
		String username = boot.getUserName();
		model.put("boot",username);
		return "index";
		
		
		
	}*/

}
