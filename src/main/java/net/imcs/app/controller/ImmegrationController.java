package net.imcs.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.imcs.app.entity.Employees;
import net.imcs.app.entity.Immigration;
import net.imcs.app.repository.ImmigrationRepository;

@RestController
@RequestMapping("/img")
public class ImmegrationController {

	@Autowired
	private ImmigrationRepository immigrationRepository;

	@GetMapping("/all")
	public ResponseEntity<List<Immigration>> getImmigrationsDetails() {

		List<Immigration> findImmigrations = immigrationRepository.findAll();

		return new ResponseEntity<List<Immigration>>(findImmigrations, new HttpHeaders(), HttpStatus.OK);
	}

	/*
	 * @GetMapping("/emp") public ResponseEntity<List<Immigration>>
	 * getByEmployeeID(@RequestParam("byId") int byId){
	 * 
	 * List<Immigration> findByEmpId =
	 * immigrationRepository.FindAllWithDescriptionQuery(byId);
	 * 
	 * for (Employees employee : findByempName1) {
	 * 
	 * System.out.println(" order by id  "+employee.getEmpId()); }
	 * 
	 * 
	 * return new ResponseEntity<List<Immigration>>(findByEmpId, new HttpHeaders(),
	 * HttpStatus.OK); }
	 */
}
