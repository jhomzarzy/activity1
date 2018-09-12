package com.fimc.hello.resource;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleResponse {
	private String firstName;
	private String lastName;
	private String birthDate;
}
