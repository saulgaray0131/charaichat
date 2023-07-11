package com.sg.charaichat.repository;

import org.springframework.data.repository.CrudRepository;

import com.sg.charaichat.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}
