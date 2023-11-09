package com.osa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.osa.dto.UserDTO;
import com.osa.model.Admin;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO signOut(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO changePassword(long id, UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}


}
