package com.finalproject.finalproject.controller;

import com.finalproject.finalproject.domain.Offer;
import com.finalproject.finalproject.domain.Property;
import com.finalproject.finalproject.dto.input.OfferCriteriaRequest;
import com.finalproject.finalproject.dto.input.PropertyCriteriaRequest;
import com.finalproject.finalproject.repo.OfferCriteriaSearch;
import com.finalproject.finalproject.repo.PropertyCriteriaSearch;
import com.finalproject.finalproject.service.OfferService;
import com.finalproject.finalproject.service.PropertyHistoryService;
import com.finalproject.finalproject.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    OfferService offerService;

    @Autowired
    OfferCriteriaSearch offerCriteriaSearch;

    @GetMapping("/{id}")
    public Offer findById(@PathVariable("id") int id){
        return offerService.findById(id);
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

    @GetMapping
    public List<Offer> findAll(
            @RequestParam(value = "property", required = false)String property,
            @RequestParam(value = "startDate", required = false) Date startDate,
            @RequestParam(value = "endDate", required = false)Date endDate,
            @RequestParam(value = "location", required = false)String location){
        if(property != null || startDate != null || endDate != null || location != null){
            var req = new OfferCriteriaRequest(property, startDate, endDate, location);
            return offerCriteriaSearch.findAllByCriteria(req);
        }else{
            return offerService.findAll();
        }
    }
}
