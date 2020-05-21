package net.imcs.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.imcs.app.beans.Address;
import net.imcs.app.service.RestTemplateService;

@RestController
public class AddressController {
	@Autowired(required=true)
	private RestTemplateService addressSrvice;
	
	@GetMapping(value="/addr/{query}")
	public ResponseEntity<List<Address>> getAllCountryDetails(@PathVariable("query") String query) {
	
		List<Address> listArddr = addressSrvice.getData(query);
		
			return new ResponseEntity<List<Address>>(listArddr, new HttpHeaders(), HttpStatus.OK);
	}
}
