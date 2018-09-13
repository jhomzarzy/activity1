package com.fimc.hello.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fimc.hello.request.PeopleRequest;
import com.fimc.hello.response.HttpCodeResponse;
import com.fimc.hello.response.PeopleResponse;
import com.fimc.hello.service.PeopleService;

@Component
@Path("/people")
public class PeopleResource {
	
	@Autowired
	private PeopleService peopleService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPeople(PeopleRequest peopleRequest){
		HttpCodeResponse httpCodeResponse = new HttpCodeResponse();
		if(StringUtils.isEmpty(peopleRequest.getFirstName()) || 
				StringUtils.isEmpty(peopleRequest.getLastName()) || 
				StringUtils.isEmpty(peopleRequest.getBirthDate())) {
			httpCodeResponse.setErrorCode(HttpServletResponse.SC_BAD_REQUEST);
			httpCodeResponse.setMessage("all fields required");
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(httpCodeResponse).build();	
		}else if(peopleService.isDateValid(peopleRequest.getBirthDate())==false) {
			httpCodeResponse.setErrorCode(HttpServletResponse.SC_BAD_REQUEST);
			httpCodeResponse.setMessage("Date Format Invalid");
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(httpCodeResponse).build();	
		}
		peopleService.addPerson(peopleRequest);
		
		httpCodeResponse.setErrorCode(HttpServletResponse.SC_CREATED);
		httpCodeResponse.setMessage("Created");
		return Response.ok(HttpServletResponse.SC_CREATED).entity(httpCodeResponse).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(){
		List<PeopleResponse> people = peopleService.findAllPerson();
		return Response.ok().entity(people).build();
	}
}
