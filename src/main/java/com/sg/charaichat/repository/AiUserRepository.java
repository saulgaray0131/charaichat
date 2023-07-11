package com.sg.charaichat.repository;

import org.springframework.data.repository.CrudRepository;

import com.sg.charaichat.model.AIUser;

public interface AiUserRepository extends CrudRepository<AIUser, Integer> {
    
}
