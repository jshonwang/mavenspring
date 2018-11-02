package mavenspring.com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import mavenspring.com.entity.Admin;

@Mapper
public interface placeHelperService {
	@Select("select * from Admin")
	List<Admin> getAllUserListPage();

}
