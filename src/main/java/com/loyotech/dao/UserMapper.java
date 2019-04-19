package com.loyotech.dao;

import com.loyotech.pojo.QueryVo;
import com.loyotech.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

	void register(User user);
	
	User selectUserById(String userId);

	void updatePassword(User user);

	void updatePostNum(String userId);

    void updateReplyNum(String userId);

	List<User> selectUser();

	void updateUserStatus(QueryVo qv);
}
