package mavenspring.com.dao;

import java.util.List;

import mavenspring.com.entity.Admin;

public interface UserMapper {
	public List<Admin> findbypage();

}
