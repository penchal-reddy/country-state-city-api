package net.imcs.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.imcs.app.entity.Countries;
import net.imcs.app.repository.CuntriesRepository;

@RestController
@RequestMapping("/countries")
public class CountriesController {

	@Autowired
	private CuntriesRepository CountriesRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Countries>> getCountriesDetails() {

		List<Countries> allCountryList = CountriesRepository.findByOrderByNameAsc();
		
		return new ResponseEntity<List<Countries>>(allCountryList, new HttpHeaders(), HttpStatus.OK);
	}
	
}
