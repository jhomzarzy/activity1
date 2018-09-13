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
		
		switch (calculatorRequest.getOperator()) {
		case '+':
			calculatorResponse.setResult(Double.parseDouble(new DecimalFormat("#.#####").format(calculatorRequest.getNumber1() + calculatorRequest.getNumber2())));
			calculatorResponse.setAction("Addition");
			break;
		case '*':
			calculatorResponse.setResult(Double.parseDouble(new DecimalFormat("#.#####").format(calculatorRequest.getNumber1() * calculatorRequest.getNumber2())));
			calculatorResponse.setAction("Multiplication");
			break;
		case '-':
			calculatorResponse.setResult(Double.parseDouble(new DecimalFormat("#.#####").format(calculatorRequest.getNumber1() - calculatorRequest.getNumber2())));
			calculatorResponse.setAction("Subtraction");
			break;
		case '/':
			try {
				calculatorResponse.setResult(Double.parseDouble(new DecimalFormat("#.#####").format(calculatorRequest.getNumber1() / calculatorRequest.getNumber2())));
				calculatorResponse.setAction("Division");
			}catch (Exception e) {}
			break;
		default:
			break;
		}
		
		logger.info(calculatorResponse.getAction()+":"+calculatorResponse.getResult());
		
		return calculatorResponse;
	}
}
