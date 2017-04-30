package io.young.busfind.presenters;

import io.young.busfind.models.siri.MonitoredCall;
import io.young.busfind.models.siri.SiriStopMonitor;

public class SiriPresenter {
    private final MonitoredCall monitoredCall;

    public SiriPresenter(SiriStopMonitor siriStopMonitor) {
        monitoredCall = parseResponse(siriStopMonitor);
    }

    private MonitoredCall parseResponse(SiriStopMonitor siriStopMonitor) {
        return siriStopMonitor.siri.serviceDelivery.stopMonitoringDelivery.get(0).monitoredStopVisit.get(0).monitoredVehicleJourney.monitoredCall;
    }

    public String getExtepectedArrivalTime() {
        return monitoredCall.expectedArrivalTime;
    }

    public Double getDistance() {
        return monitoredCall.extensions.distances.distanceFromCall;
    }
}
