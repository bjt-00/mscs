package edu.mum.ea.crs.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import edu.mum.ea.crs.data.domain.User;

@Service
public class UserContextSecurityService {
	private static Logger logger = LogManager.getLogger();
	@Autowired
	private UserService userService;
	
	public User getCurrentUser() {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.getByUsername(authentication.getName());
			logger.info("getCurrentUser() user " + user);
			return user;
		} catch (Exception e) {
			logger.error("getCurrentUser()" + e.getMessage());
		}
		return new User();
	}
}
