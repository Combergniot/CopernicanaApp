package com.copernicana.tripregistry.repositories;

import com.copernicana.tripregistry.model.personalData.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
