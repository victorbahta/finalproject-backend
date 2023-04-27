package com.finalproject.finalproject.repo;

import com.finalproject.finalproject.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Integer> {
    @Query("select m from Message m where m.owner.accountId=:ownerId")
    List<Message> findOwnerMsgs(long ownerId);
}
