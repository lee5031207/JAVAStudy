package com.kh.toy.user.model.service;

import com.kh.toy.user.model.vo.User;

public interface UserService {

	User authenticateUser(User user);
	
	void authEmail(User persistInfo, String authPath);
}
