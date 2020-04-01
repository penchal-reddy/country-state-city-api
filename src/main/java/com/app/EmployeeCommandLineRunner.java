/*
 * package com.app;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.CommandLineRunner; import
 * org.springframework.stereotype.Component;
 * 
 * @Component public class EmployeeCommandLineRunner implements
 * CommandLineRunner{
 * 
 * @Autowired private EmployeeRepository empRepository;
 * 
 * @Override public void run(String... args) throws Exception {
 * 
 * 
 * // List<Employee> findByempName = empRepository.findByempName("ramu");
 * List<Employee> findByempName=empRepository.findByOrderByEmpNameAsc();
 * for(Employee employee : findByempName) {
 * 
 * System.out.println(" id id "+employee.getEmpId()); }
 * 
 * 
 * List<Employee> findByempName1 =
 * empRepository.findByempNameOrderByEmpIdDesc("omkar"); for (Employee employee
 * : findByempName1) {
 * 
 * System.out.println(" order by id  "+employee.getEmpId()); }
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * }
 */