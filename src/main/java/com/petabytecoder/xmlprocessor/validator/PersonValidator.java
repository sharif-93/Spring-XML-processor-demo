package com.petabytecoder.xmlprocessor.validator;

import com.petabytecoder.xmlprocessor.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import jakarta.validation.*;
import java.util.Set;

@Slf4j
@Component
public class PersonValidator {
	public boolean validate(Person person){
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();
		Set<ConstraintViolation<Person>> constraintViolationSet = validator.validate(person);
		if(!constraintViolationSet.isEmpty()){
			log.error("Validation Failed");
			throw new RuntimeException("Validation Failed");
		}
		return true;
	}
}
