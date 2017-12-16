package com.mitrai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mitrai.pojo.Application;
import com.mitrai.pojo.Response;
import com.mitrai.repository.ApplicationRepository;

@RestController
public class ApplicationController {

	@Autowired
	ApplicationRepository applicationRepository;

	@RequestMapping(method = RequestMethod.GET, path = "esb/applications")
	public ResponseEntity<Response> getApplications() throws Exception {

		Iterable<Application> applications = applicationRepository.getAllApplications();
		Response r = new Response(true, applications);
		return new ResponseEntity<Response>(r, HttpStatus.OK);
	}
	

}
