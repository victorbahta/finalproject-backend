package com.finalproject.finalproject.repo;

import com.finalproject.finalproject.domain.Offer;
import com.finalproject.finalproject.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepo extends JpaRepository<Offer, Integer> {

    List<Offer> findAll();

    @Query("select o from Offer o join fetch o.owner o1 join fetch o.property p where o1.accountId=:id")
            List<Offer> getAllOwnersOffer(Long id);

//    Offer save(Offer o);

    Offer findById(int id);
}
