package com.cmc.recruitment.dao.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cmc.recruitment.dao.AbstractDao;
import com.cmc.recruitment.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{
	
	public User findUserById(long id) {return (User) getSession().get(User.class, id); }

	public void saveUser(User user) {	}

	public void updateUser(User user) {
		User u = findUserById(user.getUserId());
		u.setName(user.getName());
		u.setAvatar(user.getAvatar());
		u.setPassword(user.getPassword());
		u.setEmail(user.getEmail());
		u.setDepartmentId(user.getDepartmentId());
		u.setRoleId(user.getRoleId());
		u.setIsActive(user.getIsActive());
		getSession().save(u);
	}

	public void deleteUserById(long id) {	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {return (List<User>) createEntityCriteria().list();}

}
