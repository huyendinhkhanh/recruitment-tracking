package com.cmc.recruitment.service.department;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmc.recruitment.dao.department.DepartmentDao;
import com.cmc.recruitment.model.Department;

@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao ;

	public Department findDepartmentById(long id) { return null; }

	
	public void saveDepartment(Department department) { }

	
	public void updateDepartment(Department department) { }

	
	public void deleteDepartmentById(long id) { }

	
	public List<Department> getAllDepartments() {
		return departmentDao.getAllDepartments();
	}

}
