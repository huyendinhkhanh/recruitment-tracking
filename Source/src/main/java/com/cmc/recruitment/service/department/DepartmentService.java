package com.cmc.recruitment.service.department;

import java.util.List;

import com.cmc.recruitment.model.Department;

public interface DepartmentService {
	Department findDepartmentById(long id);

	void saveDepartment(Department department);

	void updateDepartment(Department department);

	void deleteDepartmentById(long id);

	List<Department> getAllDepartments();


}
