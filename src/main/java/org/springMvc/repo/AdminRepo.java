package org.springMvc.repo;

import java.util.List;

import org.springMvc.model.Admin;
import org.springMvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Admin findByUsername(String username)
	{
        String sql = "SELECT * FROM admin WHERE username=?";

        List<Admin> list = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Admin.class),
                username);

        return list.isEmpty() ? null : list.get(0);	
	}
}
