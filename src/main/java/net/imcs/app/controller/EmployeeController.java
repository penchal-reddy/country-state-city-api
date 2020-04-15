package net.imcs.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.imcs.app.entity.Employees;
import net.imcs.app.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepository;

	// @GetMapping("/{byName}")
	/*
	 * @GetMapping("/name") public ResponseEntity<List<Employees>>
	 * getEmployeeByName(@RequestParam("byName") String byName){
	 * 
	 * //List<Employees> findByempName1 =
	 * empRepository.findByempNameOrderByEmpIdDesc(byName); List<Employees>
	 * findByempName1 = empRepository.findByAll(); for (Employees employee :
	 * findByempName1) {
	 * 
	 * System.out.println(" order by id  "+employee.getEmpId()); }
	 * 
	 * return new ResponseEntity<List<Employees>>(findByempName1, new HttpHeaders(),
	 * HttpStatus.OK); }
	 */

	@GetMapping("/names")
	public ResponseEntity<List<Employees>> getEmployeeByNames(@RequestParam("byNames") List<String> byNames) {

		List<Employees> findByempName1 = empRepository.findByFirstNameIn(byNames);
		/*
		 * for (Employees employee : findByempName1) {
		 * 
		 * System.out.println(" order by id  "+employee.getEmpId()); }
		 */

		return new ResponseEntity<List<Employees>>(findByempName1, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/desc")
	public ResponseEntity<List<Employees>> getAllEmployeeDetailsDesc() {

		List<Employees> findByempName1 = empRepository.findByOrderByFirstNameDesc();
		/*
		 * for (Employees employee : findByempName1) {
		 * 
		 * System.out.println(" order by id  "+employee.getEmpId()); }
		 */

		return new ResponseEntity<List<Employees>>(findByempName1, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/asc")
	public ResponseEntity<List<Employees>> getAllEmployeeDetailsAsc() {

		List<Employees> findByempName1 = empRepository.findByOrderByFirstNameAsc();
		/*
		 * for (Employees employee : findByempName1) {
		 * 
		 * System.out.println(" order by id  "+employee.getEmpId()); }
		 */

		return new ResponseEntity<List<Employees>>(findByempName1, new HttpHeaders(), HttpStatus.OK);
	}

	// @GetMapping("/filters")
	@RequestMapping(value = { "/filters1" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<Employees>> getEmployeeDetailWithFilter(
			@RequestBody Map<String, List<String>> filtersListMap) {

		for (Map.Entry<String, List<String>> entry : filtersListMap.entrySet()) {
			System.out.println("Key = " + entry.getKey());

			for (String fiter : entry.getValue()) {

				System.out.println("Value:" + fiter);

			}

		}

		// List<Employees> findByempName1 =
		// empRepository.findByOrderByFirstNameAndLastNameAsc();

		List<Employees> findByempName1 = empRepository.findByImmigrationVisaIdVisaNameIn(filtersListMap.get("visaName"));

		// List<Employees> findByempName1=new ArrayList<>();

		/*
		 * for (Employees employee : findByempName1) {
		 * 
		 * System.out.println(" order by id  "+employee.getEmpId()); }
		 */

		return new ResponseEntity<List<Employees>>(findByempName1, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = { "/filters" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<Employees>> getEmployeeDetailWithFilters(
			@RequestBody Map<String, List<String>> filtersListMap) {

		/*
		 * for (Map.Entry<String, List<String>> entry : filtersListMap.entrySet()) {
		 * System.out.println("Key = " + entry.getKey());
		 * 
		 * for (String fiter : entry.getValue()) {
		 * 
		 * System.out.println("Value:" + fiter);
		 * 
		 * }
		 * 
		 * }
		 */

		// List<Employees> findByempName1 =
		// empRepository.findByOrderByFirstNameAndLastNameAsc();

		List<Employees> findByempName1 = findByInCriteria(filtersListMap);

		// List<Employees> findByempName1=new ArrayList<>();

		/*
		 * for (Employees employee : findByempName1) {
		 * 
		 * System.out.println(" order by id  "+employee.getEmpId()); }
		 */

		return new ResponseEntity<List<Employees>>(findByempName1, new HttpHeaders(), HttpStatus.OK);
	}
	public List<Employees> findByInCriteria(Map<String, List<String>> filtersListMap) {
		return empRepository.findAll(new Specification<Employees>() {
			@Override
			public Predicate toPredicate(Root<Employees> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();

				if (filtersListMap != null && !filtersListMap.isEmpty()) {

					for (Map.Entry<String, List<String>> entry : filtersListMap.entrySet()) {
						System.out.println("Key = " + entry.getKey());

						//predicates.add(root.get(entry.getKey()).in(entry.getValue()));
						if(entry.getKey().equals("visaName")) {
						predicates.add(root.join("immigration").join("visaId").get(entry.getKey()).in(entry.getValue()));
						
						}else {
							predicates.add(root.get(entry.getKey()).in(entry.getValue()));
						}
						/*
						 * for (String fiter : entry.getValue()) {
						 * 
						 * System.out.println("Value:"+fiter);
						 * 
						 * }
						 */

					}

				}

				/*
				 * if(names!=null && !names.isEmpty()) {
				 * predicates.add(root.get("employeeName").in(names));
				 * predicates.add(root.get("employeeName").in(names)); }
				 */
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
	}
}
