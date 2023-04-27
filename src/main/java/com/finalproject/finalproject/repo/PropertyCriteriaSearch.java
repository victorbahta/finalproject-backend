package com.finalproject.finalproject.repo;

import com.finalproject.finalproject.domain.Property;
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
public class PropertyCriteriaSearch {

    private final EntityManager em;

    public List<Property> findAllByCriteria(PropertyCriteriaRequest propertyCriteriaRequest){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Property> criteriaQuery = criteriaBuilder.createQuery(Property.class);
        List<Predicate> predicates = new ArrayList<>();

        Root<Property> root = criteriaQuery.from(Property.class);

        if(propertyCriteriaRequest.getPropertyType() != null){
            Predicate propertyTypePredicate = criteriaBuilder.like(root.get("property_type"), "%" + propertyCriteriaRequest.getPropertyType() + "%");
            predicates.add(propertyTypePredicate);
        }

        if(propertyCriteriaRequest.getLocation() != null){
            Predicate locationTypePredicate = criteriaBuilder.like(root.get("location"), "%" + propertyCriteriaRequest.getLocation() + "%");
            predicates.add(locationTypePredicate);
        }


        if(propertyCriteriaRequest.getListingType() != null){
            Predicate listingTypePredicate = criteriaBuilder.like(root.get("listing_type"), "%" + propertyCriteriaRequest.getListingType() + "%");
            predicates.add(listingTypePredicate);
        }

        if(propertyCriteriaRequest.getRoomNo() != null){
            Predicate roomNoTypePredicate = criteriaBuilder.equal(root.get("room_no"), propertyCriteriaRequest.getRoomNo());
            predicates.add(roomNoTypePredicate);
        }

        if(propertyCriteriaRequest.getMinPrice() != null){
            Predicate minPricePredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("price"),propertyCriteriaRequest.getMinPrice());
            predicates.add(minPricePredicate);
        }

        if(propertyCriteriaRequest.getMaxPrice() != null){
            Predicate maxPricePredicate = criteriaBuilder.lessThanOrEqualTo(root.get("price"), propertyCriteriaRequest.getMaxPrice());
            predicates.add(maxPricePredicate);
        }

        criteriaQuery.where(
                criteriaBuilder.and(predicates.toArray(new Predicate[0]))
        );

        TypedQuery<Property> query = em.createQuery(criteriaQuery);
        return query.getResultList();



    }
}
