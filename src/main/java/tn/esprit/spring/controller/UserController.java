package tn.esprit.spring.controller;

import java.util.List;

import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tn.esprit.spring.entities.User;
@RestController
@RequestMapping(path = "/user")
@CrossOrigin


public class UserController {
	@Autowired
	UserService userserv;

	// http://localhost:8084/SpringMVC/user/findByEmail
		@GetMapping("/findByEmail/{email}")
		@ResponseBody
		public User findByEmail(@PathVariable("email") String email){
			return userserv.findByEmail(email);
		}
	
	
	// http://localhost:8084/SpringMVC/user/add-user
		@PostMapping("/add-user")
		@ResponseBody
		public void addUser(@RequestBody User user)
		{
		userserv.addUser(user);
		}
		
		// http://localhost:8084/SpringMVC/user/users
	    @GetMapping("/users")
	    @ResponseBody
	    public List<User> getUser() {
	        List<User> listuser = userserv.getAllUsers();
	        return listuser;
	    }
	

	//  http://localhost:8084/SpringMVC/user/find-user/
		@GetMapping("/find-user/{user-id}")
		@ResponseBody 
		public User getUserById(@PathVariable("user-id") Long id) {
		return userserv.getUserById(id);
		}
		 
		// http://localhost:8084/SpringMVC/user/delete-user/
				@DeleteMapping("/delete/{id}")
				
				public String deleteUser(@PathVariable("id") Long id) {
				 userserv.deleteUser(id);
				return "OK";
				}
				
		
		
				// http://localhost:8084/SpringMVC/user/update-user/
				@PutMapping("/update-user")
				@ResponseBody
				public  String updateUser(@RequestBody User user)
				{				

				userserv.updateUser(user);
				return "ok";
				}

}
