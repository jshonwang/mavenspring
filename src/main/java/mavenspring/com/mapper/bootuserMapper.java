package mavenspring.com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mavenspring.com.entity.bootuser;
@Mapper
public interface bootuserMapper {
	@Select("SELECT * FROM bootuser")
	List<bootuser> selectAll();
	@Insert("insert into bootuser(id,username,sex) values (#{id},#{username},#{sex})")
	public void insertBoot(bootuser user);
	@Select("select * from bootuser where username = #{username}")
	public bootuser selectByName();
	@Delete("delete from bootuser where id = #{id}")
	public void deleteBoot();
	@Update("update bootuser set sex = #{sex} where id = #{id}")
	public void updateBoot(bootuser user);
	

}
