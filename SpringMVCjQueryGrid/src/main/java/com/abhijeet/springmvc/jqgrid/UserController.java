package com.abhijeet.springmvc.jqgrid;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles CRUD requests for users
 * 
 */
@Controller
public class UserController {
	protected static Logger logger = Logger.getLogger("controller");

	/**
	 * The default method when a request to /users is made. This essentially
	 * retrieves all users, which are wrapped inside a CustomUserResponse
	 * object. The object is automatically converted to JSON when returning back
	 * the response. The @ResponseBody is responsible for this behavior.
	 */
	@RequestMapping(value = "loadData", method = RequestMethod.POST)
	@ResponseBody
	public CustomUserResponse getAll() {
		System.out.println("Inside loadData");
		logger.debug("Received request to get all users");

		// Retrieve all users from the service
		List<User> users = new ArrayList<User>();
		User User1 = new User();
		User1.setId(1000);
		User1.setFirstName("Abhijeet");
		User1.setLastName("Kulkarni");

		User User2 = new User();
		User2.setId(2000);
		User2.setFirstName("Snehal");
		User2.setLastName("Kulkarni");

		users.add(User1);
		users.add(User2);

		// Initialize our custom user response wrapper
		CustomUserResponse response = new CustomUserResponse();

		// Assign the result from the service to this response
		response.setRows(users);

		// Assign the total number of records found. This is used for paging
		response.setRecords(String.valueOf(users.size()));

		// Since our service is just a simple service for teaching purposes
		// We didn't really do any paging. But normally your DAOs or your
		// persistence layer should support this
		// Assign a dummy page
		response.setPage("1");

		// Same. Assign a dummy total pages
		response.setTotal("10");

		// Return the response
		// Spring will automatically convert our CustomUserResponse as JSON
		// object.
		// This is triggered by the @ResponseBody annotation.
		// It knows this because the JqGrid has set the headers to accept JSON
		// format when it made a request
		// Spring by default uses Jackson to convert the object to JSON
		return response;
	}
}