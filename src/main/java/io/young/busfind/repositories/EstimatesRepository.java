package io.young.busfind.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.young.busfind.Estimate;
import io.young.busfind.presenters.SiriParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EstimatesRepository {
    private final RestTemplate restTemplate;
    private final String apiKey;
    private ObjectMapper objectMapper;

    public EstimatesRepository(String apiKey, RestTemplate restTemplate) {
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
    }

    public Estimate findByStationId(String stationId) {
        String url = String.format("http://bustime.mta.info/api/siri/stop-monitoring.json?OperatorRef=MTA&MonitoringRef=%s&key=%s", stationId, apiKey);
        ResponseEntity<String> jsonResponse = restTemplate.getForEntity(url, String.class);

        SiriParser siriParser = new SiriParser(jsonResponse.getBody());
        return new Estimate(siriParser.getExtepectedArrivalTime(), siriParser.getDistance());
    }
}
