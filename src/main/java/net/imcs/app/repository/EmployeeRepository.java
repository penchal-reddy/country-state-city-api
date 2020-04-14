package net.imcs.app.repository;

import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import net.imcs.app.entity.Employees;

public interface EmployeeRepository extends JpaRepository<Employees,Long>{
	
	List<Employees> findByfirstName(String empName);
	
	//List<Employees> findByAll();
	
	//List<Employees> findByfirstNameOrderByidDesc(String empname);
	
	List<Employees> findByOrderByFirstNameDesc();
	
    List<Employees> findByOrderByFirstNameAsc();
	
	List<Employees> findByFirstNameIn(List<String> names);
	
	List<Employees> findByImmigrationVisaIdVisaNameIn(List<String> names);
	
	/*
	 * @Query("select e from employees e   where e.first_name=:name")
	 * List<Employees> getMyData(String name);
	 */
	//@Query("Select e from employees e   left join  immigration i on i.emp_id=e.id left join visa_types v on v.visa_id=i.visa_id") 
	//
	
	List<Employees> findByOrderByLastNameAsc();

}
