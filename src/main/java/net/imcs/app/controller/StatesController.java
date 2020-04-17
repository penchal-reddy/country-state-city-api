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

import net.imcs.app.entity.States;
import net.imcs.app.repository.StatesRepository;

@RestController
@RequestMapping("/states")
public class StatesController {
	@Autowired
	private StatesRepository  statesRepository;
	@GetMapping("/id")
	public ResponseEntity<List<States>> getStateDetails(@RequestParam("byId") Integer id) {

		List<States> statesList = statesRepository.findByCountryIdOrderByNameAsc(id);
		
		return new ResponseEntity<List<States>>(statesList, new HttpHeaders(), HttpStatus.OK);
	}
}
