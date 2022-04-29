package com.petabytecoder.xmlprocessor.validator;

import com.petabytecoder.xmlprocessor.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonValidatorTest {
	private final PersonValidator personValidator;

	@Autowired
	public PersonValidatorTest(PersonValidator personValidator) {
		this.personValidator = personValidator;
	}

	@Test
	void whenNameAndNidBothValid_expectReturnTrue() {
		Person person = new Person("Johno", "1234567890", "em@i.l");
		assertTrue(personValidator.validate(person));
	}

	@Test
	void whenNameIsNull_throwRuntimeException() {
		Person person = new Person(null, "1234567890", "em@i.l");
		assertThrows(RuntimeException.class, () -> personValidator.validate(person));
	}

	@Test
	void whenNidSizeLessThanMinimum_throwRuntimeException() {
		Person person = new Person("Johno", "123456", "em@i.l");
		assertThrows(RuntimeException.class, () -> personValidator.validate(person));
	}

	@Test
	void whenEmailIsInvalid_throwRuntimeException() {
		Person person = new Person("Johno", "1234567890", "not-email");
		assertThrows(RuntimeException.class, () -> personValidator.validate(person));
	}
}