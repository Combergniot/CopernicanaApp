package com.copernicana.tripregistry.repositories;

import com.copernicana.tripregistry.model.personalData.Guide;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuideRepository extends CrudRepository<Guide, Long> {

    Optional<Guide> findByLastName(String lastName);
}
