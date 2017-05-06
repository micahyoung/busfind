package io.young.busfind.controllers;

import io.young.busfind.Estimate;
import io.young.busfind.models.webhook.WebhookResponse;
import io.young.busfind.presenters.WebhookResponsePresenter;
import io.young.busfind.repositories.EstimateNotFoundException;
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

    @PostMapping("/api/v1/webhook")
    public ResponseEntity<WebhookResponse> create() {
        try {
            Estimate estimate = estimateRepository.findByStationId("551608");
            WebhookResponse webhookResponse = WebhookResponsePresenter.present(estimate);
            return new ResponseEntity<>(webhookResponse, HttpStatus.OK);
        } catch (EstimateNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new WebhookResponse(), HttpStatus.OK);
        }

    }

}
