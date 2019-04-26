package com.copernicana.tripregistry.services;

import com.copernicana.tripregistry.exceptions.IdException;
import com.copernicana.tripregistry.model.Trip;
import com.copernicana.tripregistry.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }

    public Iterable<Trip> getAll() {
        return tripRepository.findAll();
    }

    public Optional<Trip> findById(Long id) {
        return tripRepository.findById(id);
    }

    public void deleteTripById(Long id) {
        Trip trip = tripRepository.findById(id)
                .orElse(null);

        if (trip == null) {
            throw new IdException("Cannot delete trip with ID " + id + ". This trip does not exist");
        }
        tripRepository.delete(trip);
    }
}
