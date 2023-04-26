package com.finalproject.finalproject.repo;

import com.finalproject.finalproject.domain.Property;
import com.finalproject.finalproject.domain.PropertyHistory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public interface PropertyHistoryRepo extends JpaRepository<PropertyHistory, Integer> {

    List<PropertyHistory> findFirst10ByDate(LocalDate date, Pageable pageable);
}
