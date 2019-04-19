package com.loyotech.service;

import com.loyotech.dao.UserMapper;
import com.loyotech.pojo.QueryVo;
import com.loyotech.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	public void register(User user){
		userMapper.register(user);
	}
	
	public User selectUserById(String userId) {
		return userMapper.selectUserById(userId);
	}

	@Override
	public void updateUserById(String userId) {
		
	}

	@Override
	public void updatePassword(User user) {
		userMapper.updatePassword(user);
	}

	@Override
	public List<User> selectUser() {
		return userMapper.selectUser();
	}

	@Override
	public void updateUserStatus(String userId, Integer status) {
		QueryVo qv = new QueryVo();
		qv.setStatus(status);
		qv.setUserId(userId);
		userMapper.updateUserStatus(qv);
	}
}
