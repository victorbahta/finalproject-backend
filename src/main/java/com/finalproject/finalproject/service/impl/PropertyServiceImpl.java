package com.finalproject.finalproject.service.impl;

import com.finalproject.finalproject.domain.Property;
import com.finalproject.finalproject.domain.Status;
import com.finalproject.finalproject.repo.PropertyRepo;
import com.finalproject.finalproject.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    public PropertyRepo propertyRepo;

    @Override
    public Property findById(int id) {

        Property p = propertyRepo.findById(id);
//        if(p.getOwner()==null){
//            System.out.println("property owner is null");
//        }else System.out.println(p.getOwner());
        return p;
    }

    @Override
    public List<Property> findAll() {
        return propertyRepo.findAll();
    }

    @Override
    public void addImage(MultipartFile file, int id) throws IOException {
        Property property = propertyRepo.findById(id);
        try (InputStream inputStream = file.getInputStream()) {
            byte[] imageBytes = inputStream.readAllBytes();
            property.setImage(imageBytes);
            propertyRepo.save(property);
        } catch (IOException e) {
            throw new IOException("Failed to read or save uploaded image", e);
        }
        propertyRepo.save(property);
    }
    public byte[] getImage(int propertyId){
        Property property =  propertyRepo.findById(propertyId);
        byte[] imageData = property.getImage();
        if (imageData != null) {
            return imageData;
        }

        return null;
    }
    @Override
    public void save(Property p) {
        propertyRepo.save(p);
    }

    @Override
    public void deleteById(int id) {
        propertyRepo.deleteById(id);
    }

    @Override
    public void update(int id, Property request) {
        Property p = propertyRepo.findById(id);
        p.setViews(request.getViews());
        propertyRepo.save(p);
    }

    @Override
    public String updateStatus(int id, Status requestObj) {
        Property p = propertyRepo.findById(id);
        p.setStatus(requestObj.getStatus());
        propertyRepo.save(p);
        return "status changed";
    }
}
