package com.fimc.hello.request;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CalculatorRequest implements Serializable {
	
	private char operator;
	private Double number1;
	private Double number2;
}
