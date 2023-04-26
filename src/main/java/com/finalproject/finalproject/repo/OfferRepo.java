package com.finalproject.finalproject.repo;

import com.finalproject.finalproject.domain.Offer;
import com.finalproject.finalproject.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OfferRepo extends CrudRepository<Offer, Integer> {

    List<Offer> findAll();

    @Query("SELECT o FROM Offer o JOIN fetch o.customer c JOIN fetch o.owner o2 JOIN o.property p WHERE  o2.accountId = :id")
            List<Offer> getAllOwnersOffer(Long id);

//    Offer save(Offer o);

    Offer findById(int id);
}
