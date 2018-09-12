package com.fimc.hello.service;

import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fimc.hello.resource.CalculatorRequest;
import com.fimc.hello.resource.CalculatorResponse;


@Service
public class CalculatorService {
	private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);
	
	public CalculatorResponse calculate (CalculatorRequest calculatorRequest) {
		CalculatorResponse calculatorResponse = new CalculatorResponse();
		DecimalFormat df = new DecimalFormat("#.#####");
		
		switch (calculatorRequest.getOperator()) {
		case '+':
			calculatorResponse.setAction("Addition");
			calculatorResponse.setResult(Double.parseDouble(df.format(calculatorRequest.getNumber1() + calculatorRequest.getNumber2())));
			break;
		case '*':
			calculatorResponse.setAction("Multiplication");
			calculatorResponse.setResult(Double.parseDouble(df.format(calculatorRequest.getNumber1() * calculatorRequest.getNumber2())));
			break;
		case '-':
			calculatorResponse.setAction("Subtraction");
			calculatorResponse.setResult(Double.parseDouble(df.format(calculatorRequest.getNumber1() - calculatorRequest.getNumber2())));
			break;
		case '/':
			calculatorResponse.setAction("Division");
			calculatorResponse.setResult(Double.parseDouble(df.format(calculatorRequest.getNumber1() / calculatorRequest.getNumber2())));
			break;
		default:
			break;
		}
		
		logger.info(calculatorResponse.getAction()+":"+calculatorResponse.getResult());
		
		return calculatorResponse;
	}
}
