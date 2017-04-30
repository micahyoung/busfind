package io.young.busfind.repositories;

import io.young.busfind.Estimate;
import io.young.busfind.models.siri.SiriStopMonitor;
import io.young.busfind.presenters.SiriPresenter;
import org.springframework.web.client.RestTemplate;

public class EstimatesRepository {
    private final RestTemplate restTemplate;
    private final String apiKey;

    public EstimatesRepository(String apiKey, RestTemplate restTemplate) {
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
    }

    public Estimate findByStationId(String stationId) {
        String url = String.format("http://bustime.mta.info/api/siri/stop-monitoring.json?OperatorRef=MTA&MonitoringRef=%s&key=%s", stationId, apiKey);
        SiriStopMonitor siriStopMonitor = restTemplate.getForObject(url, SiriStopMonitor.class);
        SiriPresenter siriPresenter = new SiriPresenter(siriStopMonitor);
        return new Estimate(siriPresenter.getExtepectedArrivalTime(), siriPresenter.getDistance());
    }
}
