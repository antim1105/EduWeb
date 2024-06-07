package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.User;
public class UserDwtailsServiceimpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.getUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User name not found ");
		}
		CoustomUserDetails coustomUserDetails = new CoustomUserDetails(user);
		return coustomUserDetails;
	}

}
