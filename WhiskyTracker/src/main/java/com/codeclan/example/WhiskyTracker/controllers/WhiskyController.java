package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/whiskies/year")
    public ResponseEntity<List<Whisky>> getAllWhiskiesByYear(@RequestParam(value = "year", required = false) Integer year) {
        if (year != null) {
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping(value = "/whiskies/distillery")
    public ResponseEntity<List<Whisky>> getAllWhiskiesByDistillery(@RequestParam(value = "distillery", required = false) String distilleryName) {
        if (distilleryName != null) {
            return new ResponseEntity<>(whiskyRepository.findByDistilleryName(distilleryName), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/age")
    public ResponseEntity<List<Whisky>> getAllWhiskiesByAge(@RequestParam(value = "age", required = false) Integer age) {
        if (age != null) {
            return new ResponseEntity<>(whiskyRepository.findByAge(age), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/distilleryandage")
    public ResponseEntity<List<Whisky>> getAllWhiskiesByDistilleryAndAge(@RequestParam(value = "distillery", required = false) String distilleryName, @RequestParam(value = "age", required = false) Integer age) {
        if (distilleryName != null && age != null) {
            return new ResponseEntity<>(whiskyRepository.findByDistilleryNameAndAge(distilleryName, age), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/{id}")
    public ResponseEntity<Optional<Whisky>> getWhiskyById(@PathVariable Long id) {
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
    }

//    @GetMapping(value = "/whiskies/region")
//    public ResponseEntity<List<Whisky>> getAllWhiskiesByRegion(@RequestParam(value = "region", required = false) String region) {
//        if (region != null) {
//            List<Distillery> foundByRegion = distilleryRepository.findByRegion(region);
//            for (Distillery distillery : foundByRegion) {
//                return new ResponseEntity<>(whiskyRepository.findByDistilleryName(distillery.getName()), HttpStatus.OK);
//            }
//        }
//        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
//    }
//}

    @GetMapping(value = "/whiskies/region")
    public ResponseEntity<List<Whisky>> getAllWhiskiesByRegion(@RequestParam(value = "region", required = false) String region) {
        if (region != null) {
            return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
            }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }
}