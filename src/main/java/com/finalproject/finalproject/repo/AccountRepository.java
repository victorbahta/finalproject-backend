package com.finalproject.finalproject.repo;

import com.finalproject.finalproject.domain.Accounts;
import com.finalproject.finalproject.domain.PropertyHistory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Accounts, Long> {
    Accounts save(Accounts account);

    List<Accounts> findAll();
    void deleteAccountsByAccountId(Long id);

    Optional<Accounts> findByAccountId(Long id);

    Accounts findByEmail(String email);

    List<Accounts> findFirst10ByDate(LocalDate date, Pageable pageable);
}
