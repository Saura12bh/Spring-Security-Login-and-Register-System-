package org.springMvc.controller;

import org.springMvc.model.Admin;
import org.springMvc.model.User;
import org.springMvc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@ResponseBody
    @PostMapping("/adminlogin")
    public String login(@RequestBody Admin admin)
    {
    	return adminService.login(admin);
    }
	@GetMapping("/adminDashboard")
	public String openDashboard() {
	    return "adminDashborad";
	}
}
