package com.app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	List<Employee> findByempName(String empName);
	
	List<Employee> findByempNameOrderByEmpIdDesc(String empname);
	
	List<Employee> findByOrderByEmpNameDesc();

	List<Employee> findByOrderByEmpNameAsc();
	

}
