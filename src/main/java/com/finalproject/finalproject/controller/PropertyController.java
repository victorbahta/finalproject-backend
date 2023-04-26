package com.finalproject.finalproject.controller;

import com.finalproject.finalproject.domain.Property;
import com.finalproject.finalproject.domain.PropertyHistory;
import com.finalproject.finalproject.dto.input.PropertyCriteriaRequest;
import com.finalproject.finalproject.repo.PropertyCriteriaSearch;
import com.finalproject.finalproject.service.PropertyHistoryService;
import com.finalproject.finalproject.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/properties")
public class PropertyController {
    @Autowired
    PropertyService propertyService;

    @Autowired
    PropertyHistoryService propertyHistoryService;

    @Autowired
    PropertyCriteriaSearch propertyCriteriaSearch;

    @GetMapping("/{id}")
    public Property findById(@PathVariable("id") int id){
        return propertyService.findById(id);
    }

    @GetMapping
    public List<Property> findAll(
            @RequestParam(value = "propertyType", required = false)String propertyType,
            @RequestParam(value = "location", required = false)String location,
            @RequestParam(value = "roomNo", required = false)Integer roomNo,
            @RequestParam(value = "minPrice", required = false)Integer minPrice,
            @RequestParam(value = "maxPrice", required = false)Integer maxPrice){
        if(propertyType != null || location != null || roomNo != null || minPrice != null || maxPrice != null){
            var req = new PropertyCriteriaRequest(minPrice, maxPrice, propertyType,roomNo, location);
            return propertyCriteriaSearch.findAllByCriteria(req);
        }else
            return propertyService.findAll();

    }

    @PostMapping
    public void save( @RequestBody Property property) {
        propertyService.save(property);

    }

    @PutMapping("/{id}/upload")
    public void addImage(@RequestBody MultipartFile file, @PathVariable("id") int id) throws  Exception{
        propertyService.addImage(file, id);

    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") int propertyId){
        byte[] image = propertyService.getImage(propertyId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public void deleteById(@PathVariable("id") int id){
        propertyService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Property property){
        property.setId(id);
        propertyService.update(id, property);
    }

    @GetMapping("/first10")
    List<Property> findFirst10ByDate(Date date, Pageable pageable){
       List<PropertyHistory> propertyHistoryList = propertyHistoryService.findFirst10ByDate(date, pageable);
       List<Property> propertyList = propertyHistoryList.stream().map(propertyHistory -> propertyHistory.getProperty()).collect(Collectors.toList());
       return propertyList;
    }


}
