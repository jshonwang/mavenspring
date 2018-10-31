package mavenspring.com.rng;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class htmlController {
	
	@RequestMapping("/krspace")
	public String helloHtml(HashMap<String,Object> map){
		map.put("hello","gujichenggongbuliao");
		return "hello";
		
	}
	@RequestMapping("/upload")
	public String uploadHtml(){
		return "upload";
		
	}
	@RequestMapping("/upload.do")
	@ResponseBody
	public String upload(@RequestParam("filename") MultipartFile file){
		BufferedOutputStream BOFS = null;
		if(file==null){
			return "false";
		}
		String filename = file.getOriginalFilename();
		System.out.println(filename);
		int size = (int) file.getSize();
		String path = "F:/test";
		File dest = new File(path+"/"+filename);
		if(!dest.getParentFile().exists()){
			dest.getParentFile().mkdir();
		}
		try {
			BOFS = new BufferedOutputStream(new FileOutputStream (new File(filename)));
			try {
				
				BOFS.write(file.getBytes());
				BOFS.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		try {
			file.transferTo(dest);
			return "true";
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		}
		
		
	}
	//文件
	public static void outputContent(File file) throws IOException{
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
	/*		InputStreamReader isr = new InputStreamReader(bis);
			BufferedReader br = new BufferedReader(isr);*/
			int a = 1;
			while((a = bis.read())!=-1){
				System.out.println(a);
				System.out.println((char)a);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
