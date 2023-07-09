package com.simplilearn.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.sportyshoes.models.Users;

public interface UsersRepository extends JpaRepository <Users,Integer>{

	Users findByEmail(String email);
	Users findByEmailAndPass(String email, String pass);
	Users findByEmailAndPassAndAdminAndAdminPass(String email, String pass, String admin, String adminpass);

}
