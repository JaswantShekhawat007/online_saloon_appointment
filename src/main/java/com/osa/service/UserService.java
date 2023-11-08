package com.osa.service;

import com.osa.model.User;

public interface UserService {
	
	User signIn(User user);
	
	User signOut(User user);
	
	User changePassword(long id, User user);
	
}
