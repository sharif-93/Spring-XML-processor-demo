package com.petabytecoder.xmlprocessor.service;

import com.petabytecoder.xmlprocessor.model.Person;
import com.petabytecoder.xmlprocessor.validator.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonValidationService {
	private final PersonValidator personValidator;

	@Autowired
	public PersonValidationService(PersonValidator personValidator) {
		this.personValidator = personValidator;
	}

	public void serve(Person person){
		personValidator.validate(person);
	}
}
