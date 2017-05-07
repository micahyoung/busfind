package io.young.busfind.presenters;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.young.busfind.models.siri.MonitoredCall;
import io.young.busfind.models.siri.MonitoredStopVisit;
import io.young.busfind.models.siri.MonitoredVehicleJourney;
import io.young.busfind.models.siri.SiriStopMonitor;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SiriParser {
    private ObjectMapper objectMapper;
    private String siriResponseJson;
    private String lineName;

    public SiriParser(String siriResponseJson) {
        this.siriResponseJson = siriResponseJson;
        this.objectMapper = new ObjectMapper();
    }

    public ZonedDateTime getExtepectedArrivalTime() {
       String etaText = getMonitoredCall().expectedArrivalTime;
       if (etaText != null) {
           return ZonedDateTime.parse(etaText, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
       } else {
           return null;
       }
    }

    public Double getDistance() {
        return getMonitoredCall().extensions.distances.distanceFromCall;
    }

    public int getStops() {
        return getMonitoredCall().extensions.distances.stopsFromCall;
    }

    public boolean valid() {
        return getMonitoredStopVisits() != null;
    }

    private List<MonitoredStopVisit> getMonitoredStopVisits() {
        return parseSiriStopMonitor(siriResponseJson).siri.serviceDelivery.stopMonitoringDelivery.get(0).monitoredStopVisit;
    }

    private MonitoredCall getMonitoredCall() {
        return getMonitoredVehicleJourney().monitoredCall;
    }

    private MonitoredVehicleJourney getMonitoredVehicleJourney() {
        return getMonitoredStopVisits().get(0).monitoredVehicleJourney;
    }

    private SiriStopMonitor parseSiriStopMonitor(String json) {
        SiriStopMonitor siriStopMonitor = null;
        try {
            siriStopMonitor = objectMapper.readValue(json, SiriStopMonitor.class);
        } catch (Exception e) {
            System.out.println("Error parsing json:");
            System.out.println(json);
            e.printStackTrace();
        }
        return siriStopMonitor;
    }

    public String getLineName() {
        return getMonitoredVehicleJourney().publishedLineName;
    }
}
