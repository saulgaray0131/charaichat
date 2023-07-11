package com.sg.charaichat.repository;

import org.springframework.data.repository.CrudRepository;

import com.sg.charaichat.model.Chat;

public interface ChatRepository extends CrudRepository<Chat, Integer> {
    public Iterable<Chat> findByUserId(Integer id);
}
