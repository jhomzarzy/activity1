package com.fimc.hello.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fimc.hello.service.PeopleService;

@Component
@Path("/people")
public class PeopleResource {
	
	@Autowired
	private PeopleService peopleService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response People(PeopleRequest peopleRequest){
		HttpErrorResponse httpErrorResponse = new HttpErrorResponse();
		if(StringUtils.isEmpty(peopleRequest.getFirstName()) || 
				StringUtils.isEmpty(peopleRequest.getLastName()) || 
				StringUtils.isEmpty(peopleRequest.getBirthDate())) {
			httpErrorResponse.setErrorCode(HttpServletResponse.SC_BAD_REQUEST);
			httpErrorResponse.setMessage("all fields required");
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(httpErrorResponse).build();	
		}else if(peopleService.isDateValid(peopleRequest.getBirthDate())==false) {
			httpErrorResponse.setErrorCode(HttpServletResponse.SC_BAD_REQUEST);
			httpErrorResponse.setMessage("Date Format Invalid");
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(httpErrorResponse).build();	
		}
		List<PeopleResponse> people = peopleService.addPerson(peopleRequest);
		return Response.ok(HttpServletResponse.SC_CREATED).entity(people).build();
	}
}
