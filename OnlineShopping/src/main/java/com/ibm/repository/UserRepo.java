package com.ibm.repository;

import org.springframework.stereotype.Repository;

import com.ibm.domain.User;

@Repository
public interface UserRepo {
	
	 User findOne(String email);

}
