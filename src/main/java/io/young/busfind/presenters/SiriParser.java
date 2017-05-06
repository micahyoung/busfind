package io.young.busfind.presenters;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.young.busfind.models.siri.MonitoredCall;
import io.young.busfind.models.siri.SiriStopMonitor;

import java.io.IOException;

public class SiriParser {
    private ObjectMapper objectMapper;
    private String siriResponseJson;

    public SiriParser(String siriResponseJson) {
        this.siriResponseJson = siriResponseJson;
        this.objectMapper = new ObjectMapper();
    }

    public String getExtepectedArrivalTime() {
        return getMonitoredCall().expectedArrivalTime;
    }

    public Double getDistance() {
        return getMonitoredCall().extensions.distances.distanceFromCall;
    }

    private MonitoredCall getMonitoredCall() {
        return parseSiriStopMonitor(siriResponseJson).siri.serviceDelivery.stopMonitoringDelivery.get(0).monitoredStopVisit.get(0).monitoredVehicleJourney.monitoredCall;
    }

    private SiriStopMonitor parseSiriStopMonitor(String json) {
        SiriStopMonitor siriStopMonitor = null;
        try {
            siriStopMonitor = objectMapper.readValue(json, SiriStopMonitor.class);
        } catch (Exception e) {
            System.out.println("Error parsing json:");;
            System.out.println(json);;
            e.printStackTrace();
        }
        return siriStopMonitor;
    }


}
