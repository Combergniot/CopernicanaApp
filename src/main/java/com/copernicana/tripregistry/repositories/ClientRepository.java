package com.copernicana.tripregistry.repositories;

import com.copernicana.tripregistry.model.personalData.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    Iterable<Client> findByName(String name);
}
