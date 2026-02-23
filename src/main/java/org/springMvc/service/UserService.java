package org.springMvc.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springMvc.model.User;
import org.springMvc.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private static final Logger logger=LoggerFactory.getLogger(UserService.class);
	 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	@Autowired
	UserRepo repo;
	public String register(User user)
	{		
		
				//check krt ki apn jo user cha data insert krto to already present ahe ka nahi
				//jr user name already asel tr to tr insert hou nahi mhnun he 
		        if (repo.existsByUsername(user.getUsername())) {
		        	logger.info("User name is already exist in database uid ="+user.getUid());
		            return "Username already exists";
		      
		        }
		        //user cha password incrpt kele
		        user.setPassword(encoder.encode(user.getPassword()));
		        int v=repo.save(user);
		        if(v>0) {
		        return "Registered Successfully";
		        }
		        else {
		        	 return "Registered not  Successfully";
		        }
	}
	public String login(User user)
	{
	  
		User dbUser = repo.findByUsername(user.getUsername());

	    if(dbUser == null){
	        return "User Not Found";
	    }

	    if (encoder.matches(user.getPassword(), dbUser.getPassword())) {
	        return "Login Success";
	    } else {
	        return "Invalid Password";
	    }
	}

}
