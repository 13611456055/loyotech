package com.loyotech.service;

import com.loyotech.pojo.User;

import java.util.List;

public interface UserService {

    void register(User user);

	User selectUserById(String userId);

	void updateUserById(String userId);

	void updatePassword(User user);

    List<User> selectUser();

    void updateUserStatus(String userId, Integer status);
}
