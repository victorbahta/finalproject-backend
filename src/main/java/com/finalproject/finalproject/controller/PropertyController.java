package com.finalproject.finalproject.controller;

import com.finalproject.finalproject.domain.Property;
import com.finalproject.finalproject.domain.PropertyHistory;
import com.finalproject.finalproject.service.PropertyHistoryService;
import com.finalproject.finalproject.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Property findById(@PathVariable("id") int id){
        return propertyService.findById(id);
    }

    @GetMapping
    public List<Property> findAll(){
        return propertyService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Property property){
        propertyService.save(property);
    }

    @DeleteMapping({"/{id}"})
    public void deleteById(@PathVariable("id") int id){
        propertyService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Property property){
        propertyService.update(id, property);
    }

    @GetMapping("/first10")
    List<Property> findFirst10ByDate(Date date, Pageable pageable){
       List<PropertyHistory> propertyHistoryList = propertyHistoryService.findFirst10ByDate(date, pageable);
       List<Property> propertyList = propertyHistoryList.stream().map(propertyHistory -> propertyHistory.getProperty()).collect(Collectors.toList());
       return propertyList;
    }

}
