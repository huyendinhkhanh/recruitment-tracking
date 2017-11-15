package com.cmc.recruitment.dao.user;

import java.util.List;
import com.cmc.recruitment.model.User;

public interface UserDao {
	User findUserById(long id);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(long id);

	List<User> getAllUsers();

}