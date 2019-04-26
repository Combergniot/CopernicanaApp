package com.copernicana.tripregistry.controller;

import com.copernicana.tripregistry.model.personalData.Guide;
import com.copernicana.tripregistry.services.GuideService;
import com.copernicana.tripregistry.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/przewodnicy")
@CrossOrigin
public class GuideController {

    @Autowired
    private GuideService guideService;
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewGuide(@Valid @RequestBody Guide guide, BindingResult bindingResult) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(bindingResult);
        if (errorMap != null) return errorMap;
        Guide guide1 = guideService.save(guide);
        return new ResponseEntity<Guide>(guide1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGuide(@PathVariable Long id) {
        guideService.deleteGuideById(id);
        return new ResponseEntity<String>("Guide with ID " + id + " was deleted", HttpStatus.OK);
    }

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
    public Iterable<Guide> getGuideByLastName(@PathVariable String lastName) {
        Iterable<Guide> guides = guideService.findByLastName(lastName);
        return guides;
    }

    @GetMapping("/language={language}")
    public Iterable<Guide> getGuideByLanguage(@PathVariable String language) {
        Iterable<Guide> guides = guideService.findByLanguage(language);
        return guides;
    }
}
