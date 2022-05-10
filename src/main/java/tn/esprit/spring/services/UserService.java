package tn.esprit.spring.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.registration.token.ConfirmationToken;
import tn.esprit.spring.registration.token.ConfirmationTokenService;
import tn.esprit.spring.repository.UserRepository;
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString

@Service
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

    private final UserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = appUserRepository.findByEmail(email).orElse(null);
		if(user == null){
			throw new UsernameNotFoundException("User not found in the data base");
		}
		if(user.getEnabled()==false) {
			throw new UsernameNotFoundException("You need To Confirm your email");
		
		}
		List<SimpleGrantedAuthority> authorities = getUserAuthority(user.getRole().name());
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities);
	}
	
	
	private List<SimpleGrantedAuthority> getUserAuthority(String userRoles) {
		Set<SimpleGrantedAuthority> roles = new HashSet<SimpleGrantedAuthority>();
		
		roles.add(new SimpleGrantedAuthority(userRoles)); 
		List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
	}
	
   
	

    public String signUpUser(User appUser) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {
        	User u = appUserRepository.findByEmail(appUser.getEmail()).orElse(null);
        	if(u.getEnabled()==false){
        		appUserRepository.save(u);
                String token = UUID.randomUUID().toString();

                ConfirmationToken confirmationToken = new ConfirmationToken(
                		token,
                		LocalDateTime.now(),
                		LocalDateTime.now().plusMinutes(15),
                		u
                		
                		);
                confirmationTokenService.saveConfirmationToken(confirmationToken);
                return token;
        	}else{
        		throw new IllegalStateException("email already taken");
        	}
            
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);
        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
        		token,
        		LocalDateTime.now(),
        		LocalDateTime.now().plusMinutes(15),
        		appUser
        		
        		);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }
    
    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

	public List<User> getAllUsers() {
		return (List<User>) appUserRepository.findAll();
	}


	public User addUser(User user) {
return appUserRepository.save(user);		
	}


	


	public void deleteUser(Long id) {
		User u = appUserRepository.getById(id);
        appUserRepository.deleteById(id);		
	}


	public User updateUser(User user) {
return appUserRepository.save(user);
	}


	public User getUserById(Long id) {
		return appUserRepository.findById(id).orElse(null);
	}


	public User findByEmail(String email) {
		return appUserRepository.findByEmail(email).orElse(null);
	}

	
	
	
	
}

	
    
    
    
