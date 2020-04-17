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

import net.imcs.app.entity.Cities;
import net.imcs.app.repository.CitiesRepository;

@RestController
@RequestMapping("/cities")
public class CitiesController {

	@Autowired
	private CitiesRepository  citiesRepository;
	@GetMapping("/id")
	public ResponseEntity<List<Cities>> getCityDetails(@RequestParam("byId") Integer id) {

		List<Cities> citiesList = citiesRepository.findByStateIdOrderByNameAsc(id);
		
		return new ResponseEntity<List<Cities>>(citiesList, new HttpHeaders(), HttpStatus.OK);
	}
}
