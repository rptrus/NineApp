package com.Nine.rest;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Nine.json.ErrorResponse;
import com.Nine.json.ResponseContainer;
import com.Nine.service.EpisodeService;

@RestController
public class NineController {
	
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final String errorJson = "{ \"error\": \"Could not decode request: JSON parsing failed\" }";
	
	@Autowired
	private EpisodeService logic;
		
	@GetMapping(value="/")
	public ModelAndView get() {
		 ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("index.html");
		    return modelAndView;
	}
	
	@PostMapping(value="/", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<ResponseContainer> run(@RequestBody String json) throws BadRequestException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("Hit the service at {}", format.format(new java.util.Date()));
		ResponseContainer responseContainer = null;
		
		try {
			responseContainer = logic.doRequest(json);
		} catch (IOException e) {
			throw new BadRequestException();						
		}
		return new ResponseEntity<ResponseContainer>(responseContainer,HttpStatus.OK);	
	}
	
	public static class BadRequestException extends Exception {

		public BadRequestException() {
			// dummy call
		}
	}
	
	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handle(BadRequestException e) {
		ErrorResponse err = new ErrorResponse();
		err.setError("Could not decode request: JSON parsing failed");
		
	    return new ResponseEntity<ErrorResponse>(err, HttpStatus.BAD_REQUEST);
	}
	
}