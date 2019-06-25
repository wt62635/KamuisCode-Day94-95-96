package cn.tedu.ssm.mapper;

import cn.tedu.ssm.entity.User;

public interface UserMapper {
	
	Integer addnew(User user);
	
	User findByUsername(String username);

}
