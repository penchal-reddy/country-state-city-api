package net.imcs.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.imcs.app.entity.VisaTypes;
import net.imcs.app.repository.VisaTypesRepository;

@RestController
@RequestMapping("/visaTypes")
public class VisaTypesController {
	
	@Autowired
	private VisaTypesRepository visaTypesRepository;
	
	@GetMapping("/all")
    public ResponseEntity<List<VisaTypes>> getVisaTypes(){
                                                    
		List<VisaTypes> findVisaTpes = visaTypesRepository.findAll();
	
        return new ResponseEntity<List<VisaTypes>>(findVisaTpes, new HttpHeaders(), HttpStatus.OK);
    }

}
