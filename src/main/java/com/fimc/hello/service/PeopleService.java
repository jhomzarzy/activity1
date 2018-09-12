package com.fimc.hello.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fimc.hello.resource.PeopleRequest;
import com.fimc.hello.resource.PeopleResponse;

@Service
public class PeopleService {
	
	private static final Logger logger = LoggerFactory.getLogger(PeopleService.class);
	
	List<PeopleResponse> peopleResponse = new ArrayList<>();
	
	public List<PeopleResponse> addPerson(PeopleRequest peopleRequest) {
		PeopleResponse pr = new PeopleResponse();
		
		pr.setFirstName(peopleRequest.getFirstName());
		pr.setLastName(peopleRequest.getLastName());
		pr.setBirthDate(peopleRequest.getBirthDate());
		logger.info(pr.toString());
		peopleResponse.add(pr);
		return peopleResponse;
	}
	
	public boolean isDateValid(String inDate) {
//	    return inDate.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})");
		SimpleDateFormat sdfrmt = new SimpleDateFormat("MM-dd-yyyy");
	    sdfrmt.setLenient(false);
	    try
	    {
	        Date javaDate = sdfrmt.parse(inDate); 
	        System.out.println(inDate+" is valid date format");
	    }catch (ParseException e){
	        System.out.println(inDate+" is Invalid Date format");
	        return false;
	    }
	    return true;
	}

}
