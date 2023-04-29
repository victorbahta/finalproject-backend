package com.finalproject.finalproject.service;

import com.finalproject.finalproject.domain.Property;
import com.finalproject.finalproject.domain.PropertyHistory;
import com.finalproject.finalproject.domain.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface PropertyService {

    public Property findById(int id);

    public List<Property> findAll();

    void addImage(MultipartFile file, int id) throws IOException;
    byte[] getImage(int propertyId);
    void save( Property property);

    void deleteById(int id);

    void update(int id, Property property);

    String updateStatus(int id, Status requestObj);
}
