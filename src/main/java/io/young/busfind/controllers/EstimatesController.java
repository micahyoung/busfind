package io.young.busfind.controllers;

import io.young.busfind.Estimate;
import io.young.busfind.repositories.EstimatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstimatesController {
    @Autowired
    private EstimatesRepository estimateRepository;

    @PostMapping("/")
    public ResponseEntity<Estimate> create(String latitude, String longitude) {
        Estimate estimate = estimateRepository.findByLatitudeAndLongitude(latitude, longitude);
        return new ResponseEntity<>(estimate, HttpStatus.OK);
    }

}
