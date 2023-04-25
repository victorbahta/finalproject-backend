package com.finalproject.finalproject.service.impl;

import com.finalproject.finalproject.domain.PropertyHistory;
import com.finalproject.finalproject.repo.PropertyHistoryRepo;
import com.finalproject.finalproject.service.PropertyHistoryService;
import com.finalproject.finalproject.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PropertyHistoryServiceImpl implements PropertyHistoryService {

    @Autowired
    PropertyHistoryRepo propertyHistoryRepo;
    @Override
    public List<PropertyHistory> findFirst10ByDate(Date date, Pageable pageable) {
        return propertyHistoryRepo.findFirst10ByDate(date, pageable);
    }
}
