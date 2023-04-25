package com.finalproject.finalproject.repo;

import com.finalproject.finalproject.domain.Offer;
import com.finalproject.finalproject.domain.Property;
import com.finalproject.finalproject.dto.input.OfferCriteriaRequest;
import com.finalproject.finalproject.dto.input.PropertyCriteriaRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OfferCriteriaSearch {

    private final EntityManager em;

    public List<Offer> findAllByCriteria(OfferCriteriaRequest offerCriteriaRequest){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Offer> criteriaQuery = criteriaBuilder.createQuery(Offer.class);
        List<Predicate> predicates = new ArrayList<>();

        Root<Offer> root = criteriaQuery.from(Offer.class);

        if(offerCriteriaRequest.getProperty() != null){
            Predicate propertyTypePredicate = criteriaBuilder.like(root.get("property").get("id"), "%" + offerCriteriaRequest.getProperty() + "%");
            predicates.add(propertyTypePredicate);
        }

        if(offerCriteriaRequest.getLocation() != null){
            Predicate locationTypePredicate = criteriaBuilder.like(root.get("location"), "%" + offerCriteriaRequest.getLocation() + "%");
            predicates.add(locationTypePredicate);
        }

        if(offerCriteriaRequest.getStartDate() != null){
            Predicate startDatePredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("date"),offerCriteriaRequest.getStartDate());
            predicates.add(startDatePredicate);
        }

        if(offerCriteriaRequest.getEndDate() != null){
            Predicate endDatePredicate = criteriaBuilder.lessThanOrEqualTo(root.get("date"), offerCriteriaRequest.getEndDate());
            predicates.add(endDatePredicate);
        }

        criteriaQuery.where(
                criteriaBuilder.and(predicates.toArray(new Predicate[0]))
        );

        TypedQuery<Offer> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
