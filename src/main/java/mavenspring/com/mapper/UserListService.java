package mavenspring.com.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import mavenspring.com.dao.UserMapper;
import mavenspring.com.entity.Admin;

@Service
public class UserListService   {
	@Autowired
	private UserMapper ump;
	public List<Admin> getList(int pageNum,int pageSize){
		PageHelper.startPage(pageNum,pageSize);
		List<Admin> userList = ump.findbypage();
		return userList;
	}
		
	}
	


