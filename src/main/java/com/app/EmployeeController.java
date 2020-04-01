package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository empRepository;

		//@GetMapping("/{byName}")
		@GetMapping("/name")
	    public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam("byName") String byName){
	                                                    
			List<Employee> findByempName1 = empRepository.findByempNameOrderByEmpIdDesc(byName);
			for (Employee employee : findByempName1) {
				
				System.out.println(" order by id  "+employee.getEmpId());
			}
	 
	        return new ResponseEntity<List<Employee>>(findByempName1, new HttpHeaders(), HttpStatus.OK);
	    }
	
		@GetMapping("/desc")
	    public ResponseEntity<List<Employee>> getAllEmployeeDetailsDesc(){
	                                                    
			List<Employee> findByempName1 = empRepository.findByOrderByEmpNameDesc();
			for (Employee employee : findByempName1) {
				
				System.out.println(" order by id  "+employee.getEmpId());
			}
	 
	        return new ResponseEntity<List<Employee>>(findByempName1, new HttpHeaders(), HttpStatus.OK);
	    }
		
		@GetMapping("/asc")
	    public ResponseEntity<List<Employee>> getAllEmployeeDetailsAsc(){
	                                                    
			List<Employee> findByempName1 = empRepository.findByOrderByEmpNameAsc();
			for (Employee employee : findByempName1) {
				
				System.out.println(" order by id  "+employee.getEmpId());
			}
	 
	        return new ResponseEntity<List<Employee>>(findByempName1, new HttpHeaders(), HttpStatus.OK);
	    }
		
		
	
}
