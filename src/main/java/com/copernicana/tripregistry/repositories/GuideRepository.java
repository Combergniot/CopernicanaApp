package com.copernicana.tripregistry.repositories;

import com.copernicana.tripregistry.model.personalData.Guide;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends CrudRepository<Guide, Long> {

    Iterable<Guide> findByLastName(String lastName);

    Iterable<Guide> findByLanguage(String language);

}
