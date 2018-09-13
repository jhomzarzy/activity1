package com.fimc.hello.resource;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fimc.hello.request.CalculatorRequest;
import com.fimc.hello.response.CalculatorResponse;
import com.fimc.hello.response.HttpCodeResponse;
import com.fimc.hello.service.CalculatorService;


@Component
@Path("/calculator")
public class CalculatorResource {
	
	@Autowired
	private CalculatorService calculatorService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response calculate(CalculatorRequest calculatorRequest){
		CalculatorResponse calculatorResponse = calculatorService.calculate(calculatorRequest);
		
		if(calculatorResponse.getAction() == null || calculatorResponse.getResult() == null) {
			HttpCodeResponse httpErrorResponse = new HttpCodeResponse();
			httpErrorResponse.setErrorCode(HttpServletResponse.SC_BAD_REQUEST);
			httpErrorResponse.setMessage("Invalid Operation/Operator Not Found");
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(httpErrorResponse).build();
		}
		
		return Response.ok().entity(calculatorResponse).build();
	}
}
