package io.young.busfind.controllers;

import io.young.busfind.Estimate;
import io.young.busfind.models.apiapi.ApiaiRequest;
import io.young.busfind.models.webhook.WebhookResponse;
import io.young.busfind.presenters.ApiaiParser;
import io.young.busfind.presenters.WebhookResponsePresenter;
import io.young.busfind.repositories.EstimateNotFoundException;
import io.young.busfind.repositories.EstimatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EstimatesController {
    @Autowired
    private EstimatesRepository estimateRepository;

    @PostMapping("/api/v1/webhook")
    public ResponseEntity<WebhookResponse> create(@RequestBody ApiaiRequest apiaiRequest) {
        ApiaiParser apiaiParser = new ApiaiParser(apiaiRequest);
        String stopcode = apiaiParser.getStopCode();

        try {
            Estimate estimate = estimateRepository.findByStationId(stopcode); //404303 is busiest
            WebhookResponse webhookResponse = WebhookResponsePresenter.present(estimate);
            return new ResponseEntity<>(webhookResponse, HttpStatus.OK);
        } catch (EstimateNotFoundException e) {
            e.printStackTrace();
            WebhookResponse webhookResponse = WebhookResponsePresenter.error(stopcode);

            return new ResponseEntity<>(webhookResponse, HttpStatus.NOT_FOUND);
        }

    }

}
