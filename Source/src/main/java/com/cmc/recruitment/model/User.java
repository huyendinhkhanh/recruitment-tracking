package com.cmc.recruitment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "UserId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@Column(name = "Name", nullable = true)
	private String name;

	@Column(name = "Avatar", nullable = false)
	private String avatar;

	@Column(name = "Password", nullable = false)
	private String password;

	@Column(name = "Email", nullable = false)
	private String email;

	@Column(name = "DepartmentId", nullable = false)
	private long departmentId;

	@Column(name = "RoleId", nullable = true)
	private long roleId;

	@Column(name = "IsActive", nullable = false)
	private int isActive;

	public User() {
		super();
	}

	public User(long userId, String name, String avatar, String password, String email, long departmentId, long roleId,
			int isActive) {
		super();
		this.userId = userId;
		this.name = name;
		this.avatar = avatar;
		this.password = password;
		this.email = email;
		this.departmentId = departmentId;
		this.roleId = roleId;
		this.isActive = isActive;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", avatar=" + avatar + ", password=" + password
				+ ", email=" + email + ", departmentId=" + departmentId + ", roleId=" + roleId + ", isActive="
				+ isActive + "]";
	}

}
