package com.sg.charaichat.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.sg.charaichat.model.ChatLine;

public interface ChatLineRepository extends CrudRepository<ChatLine, Integer> {
    
    List<ChatLine> findByChatIdOrderByCreatedAtAsc(Integer id);
}
