package org.springMvc.repo;

import java.util.List;

import org.springMvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {

	@Autowired
	JdbcTemplate jdbc;
	// Check username already exists or not
    public boolean existsByUsername(String username) {
        String sql = "SELECT COUNT(*) FROM user WHERE username = ?";
        Integer count = jdbc.queryForObject(sql, Integer.class, username);
        return count != null && count > 0;
    }

    // Insert user
    public int save(User user) {
        String sql = "INSERT INTO user(uid,username,password) VALUES(?,?,?)";
        return jdbc.update(sql,user.getUid(),user.getUsername(), user.getPassword());
    }
    
    public User findByUsername(String username) {

        String sql = "SELECT * FROM user WHERE username=?";

        List<User> list = jdbc.query(sql,
                new BeanPropertyRowMapper<>(User.class),
                username);

        return list.isEmpty() ? null : list.get(0);
    }


}
