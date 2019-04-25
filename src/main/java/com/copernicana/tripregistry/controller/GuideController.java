package com.copernicana.tripregistry.controller;

import com.copernicana.tripregistry.model.personalData.Client;
import com.copernicana.tripregistry.model.personalData.Guide;
import com.copernicana.tripregistry.services.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/przewodnicy")
@CrossOrigin
public class GuideController {

    @Autowired
    private GuideService guideService;

    @GetMapping("/all")
    public Iterable<Guide> getAll() {
        Iterable<Guide> guides = guideService.getAll();
        return guides;
    }

    @GetMapping("/{id}")
    public Optional<Guide> getGuideById(@PathVariable Long id) {
        Optional<Guide> guide =
                guideService.findById(id);
        return guide;
    }

    @GetMapping("/lastName={lastName}")
    public Optional<Guide> getGuideByLastName(@PathVariable String lastName) {
        Optional<Guide> guide = guideService.findByLastName(lastName);
        return guide;
    }
}
