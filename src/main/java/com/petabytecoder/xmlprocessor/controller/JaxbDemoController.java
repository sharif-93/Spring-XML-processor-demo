package com.petabytecoder.xmlprocessor.controller;

import com.petabytecoder.xmlprocessor.model.Person;
import com.petabytecoder.xmlprocessor.service.PersonValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class JaxbDemoController {

	private final PersonValidationService personValidationService;

	@Autowired
	public JaxbDemoController(PersonValidationService personValidationService) {
		this.personValidationService = personValidationService;
	}

	@PostMapping(value = "xml/insert", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public Person post(@RequestBody Person personData){
		log.info("Request body: \n{}", personData.toString());
		personValidationService.serve(personData);
		return personData;
	}
}
