package io.young.busfind.repositories;

import io.young.busfind.Estimate;
import io.young.busfind.presenters.SiriParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EstimatesRepository {
    private final RestTemplate restTemplate;
    private final String apiKey;

    public EstimatesRepository(String apiKey, RestTemplate restTemplate) {
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
    }

    public Estimate findByStationId(String stationId) throws EstimateNotFoundException {
        String url = String.format("http://bustime.mta.info/api/siri/stop-monitoring.json?OperatorRef=MTA&MonitoringRef=%s&key=%s", stationId, apiKey);
        ResponseEntity<String> jsonResponse = restTemplate.getForEntity(url, String.class);

        SiriParser siriParser = new SiriParser(jsonResponse.getBody());
        if (!siriParser.valid()) throw new EstimateNotFoundException();
        return new Estimate(siriParser.getExtepectedArrivalTime(), siriParser.getStops(), siriParser.getDistance(), siriParser.getLineName());
    }

}
