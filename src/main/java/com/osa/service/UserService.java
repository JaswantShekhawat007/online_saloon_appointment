package com.osa.service;

import com.osa.dto.UserDTO;

public interface UserService {
	
	UserDTO signIn(UserDTO userDTO);
	
	UserDTO signOut(UserDTO userDTO);
	
	UserDTO changePassword(long id, UserDTO userDTO);
	
}
