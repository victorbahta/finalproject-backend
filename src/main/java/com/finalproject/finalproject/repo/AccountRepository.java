package com.finalproject.finalproject.repo;

import com.finalproject.finalproject.domain.Accounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Accounts, Long> {
    Accounts save(Accounts account);

    List<Accounts> findAll();

    Optional<Accounts> findByAccountId(Long id);
}
