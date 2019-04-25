package com.copernicana.tripregistry.services;

import com.copernicana.tripregistry.model.personalData.Guide;
import com.copernicana.tripregistry.repositories.GuideRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuideService {

    private final GuideRepository guideRepository;

    public GuideService(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    public Iterable<Guide> getAll() {
        return guideRepository.findAll();
    }

    public Guide save(Guide guide) {
        return guideRepository.save(guide);
    }

    public Optional<Guide> findById(Long id){
        return guideRepository.findById(id);
    }

    public Optional<Guide> findByLastName(String lastName){
        return guideRepository.findByLastName(lastName);
    }

}
