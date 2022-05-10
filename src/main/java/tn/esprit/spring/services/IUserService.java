package tn.esprit.spring.services;

import java.util.List;
import tn.esprit.spring.entities.User;

public interface IUserService {
	
	void addUser (User user); 
	
		 List <User> getAllUsers();
		
		void deleteUser(Long id);
		
		User getUserById(Long id);
		
		User updateUser(User user);
		
		
		
	

}
