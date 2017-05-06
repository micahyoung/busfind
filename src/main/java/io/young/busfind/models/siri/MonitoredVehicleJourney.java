
package io.young.busfind.models.siri;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "LineRef",
        "DirectionRef",
        "FramedVehicleJourneyRef",
        "JourneyPatternRef",
        "PublishedLineName",
        "OperatorRef",
        "OriginRef",
        "DestinationRef",
        "DestinationName",
        "Monitored",
        "Bearing",
        "ProgressRate",
        "BlockRef",
        "VehicleRef",
        "MonitoredCall"
})
@JsonIgnoreProperties({
        "FramedVehicleJourneyRef",
        "OriginAimedDepartureTime",
        "SituationRef",
        "VehicleLocation",
        "ProgressStatus",
        "OnwardCalls",
        "ResponseTimestamp",
        "StopMonitoringDelivery",
})

public class MonitoredVehicleJourney {

    @JsonProperty("LineRef")
    public String lineRef;
    @JsonProperty("DirectionRef")
    public String directionRef;
    @JsonProperty("JourneyPatternRef")
    public String journeyPatternRef;
    @JsonProperty("PublishedLineName")
    public String publishedLineName;
    @JsonProperty("OperatorRef")
    public String operatorRef;
    @JsonProperty("OriginRef")
    public String originRef;
    @JsonProperty("DestinationRef")
    public String destinationRef;
    @JsonProperty("DestinationName")
    public String destinationName;
    @JsonProperty("Monitored")
    public Boolean monitored;
    @JsonProperty("Bearing")
    public Double bearing;
    @JsonProperty("ProgressRate")
    public String progressRate;
    @JsonProperty("BlockRef")
    public String blockRef;
    @JsonProperty("VehicleRef")
    public String vehicleRef;
    @JsonProperty("MonitoredCall")
    public MonitoredCall monitoredCall;
}
