package org.springMvc.service;

import org.springMvc.model.Admin;
import org.springMvc.model.User;
import org.springMvc.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService {
	@Autowired
	AdminRepo adminRepo;
	public String login(Admin admin ,HttpSession session)
	{
		Admin dbUser = adminRepo.findByUsername(admin.getUsername());

	    if(dbUser == null){
	        return "Data is Wrong Not Found";
	    }

	    if (admin.getPassword().equals(dbUser.getPassword())) {
	    session.setAttribute("name",admin.getUsername());
	        return "Login Success";
	    } else {
	        return "Invalid Password";
	    }

	}

}
