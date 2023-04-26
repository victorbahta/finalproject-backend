package com.finalproject.finalproject.repo;

import com.finalproject.finalproject.domain.Accounts;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Accounts, Long> {
    Accounts save(Accounts account);
    List<Accounts> findAll();
    Accounts findByEmail(String email);
}
