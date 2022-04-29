package com.petabytecoder.xmlprocessor.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
	@NotNull
	private String name;
	@Size(min = 10)
	private String nid;
	@Email
	private String email;
}
