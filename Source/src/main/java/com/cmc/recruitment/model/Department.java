package com.cmc.recruitment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "deptName", nullable = false)
	private String deptName;
	
	@Column(name = "description", nullable = false)
	private String descripton;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(long id, String deptName, String descripton) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.descripton = descripton;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDescripton() {
		return descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

	
}

