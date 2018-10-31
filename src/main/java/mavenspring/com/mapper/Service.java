package mavenspring.com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import mavenspring.com.entity.Admin;

@Mapper
public interface Service {
	@Select("select * from Admin where userName = #{userName} and password = #{password}")
	Admin getCheckAdminInfo(Admin admin);
	@Insert("insert into Admin(id,userName,password,realName,age,phoneNumber,headPicture,updateDate,state,addDate) values(#{id},#{userName},#{password},#{realName},#{age},#{phoneNumber},#{headPicture},#{updateDate},#{state},#{addDate})")
	int insertAdminInfo(Admin admin);
	@Select("select * from Admin")
	List<Admin> getUserList();

}
