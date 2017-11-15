package com.cmc.recruitment.service.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmc.recruitment.dao.user.UserDao;
import com.cmc.recruitment.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User findUserById(long id) {return userDao.findUserById(id);}

	public void saveUser(User user) {}

	public void updateUser(User user) {userDao.updateUser(user);}

	public void deleteUserById(long id) {}

	public List<User> getAllUsers() {return userDao.getAllUsers();}
	
}
