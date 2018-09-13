package com.fimc.hello.request;

import java.io.Serializable;
import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class PeopleRequest implements Serializable{
	private String firstName;
	private String lastName;
	private String birthDate;
}
