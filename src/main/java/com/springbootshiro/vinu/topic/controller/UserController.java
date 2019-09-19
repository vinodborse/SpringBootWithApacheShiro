package com.springbootshiro.vinu.topic.controller;

/**
 * @author Vinod Borse
 * 18-Sep-2019
 */
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootshiro.vinu.topic.exception.UnauthenticatedException;
import com.springbootshiro.vinu.topic.exception.UserAlreadyExistsException;
import com.springbootshiro.vinu.topic.iservices.IUserService;
import com.springbootshiro.vinu.topic.models.UserAuthentication;
import com.springbootshiro.vinu.topic.response.GenericResponse;
import com.springbootshiro.vinu.topic.response.LogginResponse;

@RestController
public class UserController {
		
	@Autowired
	private IUserService userService;
	  
	@Autowired
	private IUserService userAuthenticationService;
	
	private String hashAlgorithmName = "SHA-256";

	private Integer hashIterations = 512;
	
	  @RequestMapping(value = "/registerUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	  public @ResponseBody GenericResponse registerPatientHandler(
	      @RequestParam("userName") String userName, @RequestParam("firstName") String firstName,
	      @RequestParam("lastName") String lastName, @RequestParam("password") String password) {
		  
		  UserAuthentication userAuth = userAuthenticationService.findByUsername(userName);
		  if(null != userAuth){
			  throw new UserAlreadyExistsException("User '"+userName+"' already exists, Failed to create user");
		  }
	
		  RandomNumberGenerator saltGenerator = new SecureRandomNumberGenerator();
		  String passwordSalt = saltGenerator.nextBytes().toBase64();
	
		  //Note it does not matter if passwordSalt is encoded as Hex or Base64 but password
		  //must be encoded as Hex or it needs special handling.
		  String hashedPassword = new SimpleHash(hashAlgorithmName, password, passwordSalt, hashIterations).toHex();
	
		  userService.addUser(userName, firstName, lastName, hashedPassword, passwordSalt);
		  return new GenericResponse("User Registered successfully");
	  }
	  
	  @RequestMapping(value = "/unauthenticated", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	  @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	  public @ResponseBody GenericResponse unauthenticatedHandler() {
	    return new GenericResponse("Unauthenticated Access Denied. Please Login and try again.");
	  }
	  
	  @RequestMapping(value = "/unauthorized", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	  @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	  public @ResponseBody GenericResponse unauthorizedHandler() {
	    return new GenericResponse("Unauthorized Access Denied. Your Role does not have sufficient permissions. Please login with a account with appropriate permissions and try again.");
	  }
	  
	  @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	  public @ResponseBody LogginResponse loginHandler(@RequestParam String username, @RequestParam String password) {
	    if (!SecurityUtils.getSubject().isAuthenticated()) {
	      UsernamePasswordToken upt = new UsernamePasswordToken(username, password);
	      try {
	        SecurityUtils.getSubject().login(upt);
	      } catch(AuthenticationException ae) {
	    	  throw new UnauthenticatedException("Please enter a valid email id or password.");
	      }
	    }

	    String sessionId = (String) SecurityUtils.getSubject().getSession().getId();
	    System.out.println("sessionId is = "+sessionId);
	    LogginResponse loggingResponse = new LogginResponse(sessionId);
	    return loggingResponse;
	  }
	  
	  @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	  public @ResponseBody GenericResponse logout() {
		  if (SecurityUtils.getSubject().isAuthenticated()) {
			  try {
				  SecurityUtils.getSubject().logout();
				  return new GenericResponse("successfully logged out.");
			  } catch (AuthenticationException ae) {
				  System.out.println("AuthenticationException = " + ae);
				  throw ae;
			  }
		  } else {
			  return new GenericResponse("No active session, ignoring logout.");
		  }
	  }
}
