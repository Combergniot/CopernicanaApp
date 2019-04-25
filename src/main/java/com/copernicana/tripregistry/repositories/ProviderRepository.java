package com.copernicana.tripregistry.repositories;

import com.copernicana.tripregistry.model.personalData.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {
}
