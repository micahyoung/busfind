
package io.young.busfind.models.siri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "MonitoredVehicleJourney",
    "RecordedAtTime"
})
public class MonitoredStopVisit {

    @JsonProperty("MonitoredVehicleJourney")
    public MonitoredVehicleJourney monitoredVehicleJourney;
    @JsonProperty("RecordedAtTime")
    public String recordedAtTime;

}
