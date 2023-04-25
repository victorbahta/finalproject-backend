package com.finalproject.finalproject.controller;

import com.finalproject.finalproject.domain.Offer;
import com.finalproject.finalproject.domain.Property;
import com.finalproject.finalproject.service.OfferService;
import com.finalproject.finalproject.service.PropertyHistoryService;
import com.finalproject.finalproject.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    OfferService offerService;

    @GetMapping("/{id}")
    public Offer findById(@PathVariable("id") int id){
        return offerService.findById(id);
    }

    @GetMapping
    public List<Offer> findAll(){
        return offerService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Offer offer){
        offerService.save(offer);
    }

    @DeleteMapping({"/{id}"})
    public void deleteById(@PathVariable("id") int id){
        offerService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Offer offer){
        offerService.update(id, offer);
    }
}
