package com.my.restapi.model;

import javax.validation.constraints.Size;

import lombok.*;

@Data
@AllArgsConstructor
//@RequiredArgsConstructor (staticName = "of")
@NoArgsConstructor
public class User {
	
	int id;
	
	@Size(min = 2, message = "Name must be at least 2 characters long")
	String name;
}
