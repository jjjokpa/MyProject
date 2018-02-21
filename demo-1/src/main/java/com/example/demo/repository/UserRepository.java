package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.UserVO;


public interface UserRepository extends JpaRepository<UserVO, Integer>{

}
