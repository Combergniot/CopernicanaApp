package com.copernicana.tripregistry.controller;

import com.copernicana.tripregistry.model.Trip;
import com.copernicana.tripregistry.services.MapValidationErrorService;
import com.copernicana.tripregistry.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/trip")
@CrossOrigin
public class TripController {

    @Autowired
    private TripService tripService;
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewTrip(@Valid @RequestBody Trip trip, BindingResult bindingResult) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(bindingResult);
        if (errorMap != null) return errorMap;
        Trip trip1 = tripService.save(trip);
        return new ResponseEntity<Trip>(trip1, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Trip> getAll() {
        Iterable<Trip> tripIterable = tripService.getAll();
        return tripIterable;
    }

    @GetMapping("/{id}")
    public Optional<Trip> getTripById(@PathVariable Long id) {
        Optional<Trip> guide =
                tripService.findById(id);
        return guide;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrip(@PathVariable Long id) {
        tripService.deleteTripById(id);
        return new ResponseEntity<String>("Trip with ID " + id + " was deleted", HttpStatus.OK);

    }
}
