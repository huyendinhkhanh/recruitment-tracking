package com.cmc.recruitment.dao.user;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cmc.recruitment.dao.AbstractDao;
import com.cmc.recruitment.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{
	
	private final Path rootLocation = Paths.get("upload-dir");

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

	public void store(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	public void init() {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}

}
