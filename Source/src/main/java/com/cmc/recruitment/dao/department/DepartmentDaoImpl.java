package com.cmc.recruitment.dao.department;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.cmc.recruitment.dao.AbstractDao;
import com.cmc.recruitment.model.Department;

@Repository("departmentDao")
@Transactional
public class DepartmentDaoImpl extends AbstractDao<Integer, Department> implements DepartmentDao{

	public Department findDepartmentById(long id) {return null; }

	public void saveDepartment(Department department) { }

	public void updateDepartment(Department department) { }

	public void deleteDepartmentById(long id) { }

	public List<Department> getAllDepartments() {
		return (List<Department>) createEntityCriteria().list();
	}
}