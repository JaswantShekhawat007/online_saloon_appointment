package com.osa.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.osa.dto.UserDTO;
import com.osa.exception.CustomerNotFoundException;
import com.osa.exception.UserNotFoundException;
import com.osa.model.Admin;
import com.osa.model.Customer;
import com.osa.model.User;
import com.osa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDTO signIn(UserDTO userDTO) {
		Admin admin = new Admin();
		Customer customer = new Customer();
		User user = new User();
		
		if(userDTO.getUserId() == "admin" && userDTO.getPassword() == "Admin@5653") {
			System.out.println("Welcome Admin");
		} else if(userDTO.getUserId() == customer.getUserId() && userDTO.getPassword() == customer.getPassword()) {

			System.out.println("Welcome Customer");

		}
		return userDTO;
	}

	@Override
	public UserDTO signOut(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO changePassword(long id, UserDTO userDTO) {
		User user = userRepository.findById(String.valueOf(id)).orElseThrow(()->new UserNotFoundException("User With ID :"+id+" Not Exist!"));
		
		user.setPassword(userDTO.getPassword());
		userRepository.save(user);
		
		return null;
	}


}
