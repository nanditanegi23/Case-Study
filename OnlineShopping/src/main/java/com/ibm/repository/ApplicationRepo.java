package com.ibm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.domain.User;

@Repository
public interface ApplicationRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);	
}