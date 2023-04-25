package com.finalproject.finalproject.repo;

import com.finalproject.finalproject.domain.Accounts;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Accounts, Long> {
    Accounts save(Accounts account);
}
