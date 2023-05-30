package com.example.springjpa.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springjpa.entity.User;

@Repository

public interface UserRepository extends CrudRepository<User, UUID>{

	

}
