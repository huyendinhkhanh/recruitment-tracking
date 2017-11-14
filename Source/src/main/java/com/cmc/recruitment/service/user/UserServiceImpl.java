package com.cmc.recruitment.service.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cmc.recruitment.dao.user.UserDao;
import com.cmc.recruitment.dao.user.UserDaoImpl;
import com.cmc.recruitment.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	private UserDaoImpl userDaoImpl;

	public User findUserById(long id) {return userDao.findUserById(id);}

	public void saveUser(User user) {}

	public void updateUser(User user) {userDao.updateUser(user);}

	public void deleteUserById(long id) {}

	public List<User> getAllUsers() {return userDao.getAllUsers();}
	
	public void store(MultipartFile file) {
		userDaoImpl.store(file);
	}

	public Resource loadFile(String filename) {
		return userDaoImpl.loadFile(filename);
	}

	public void deleteAll() {
		userDaoImpl.deleteAll();
	}

	public void init() {
		userDaoImpl.init();
	}

}
