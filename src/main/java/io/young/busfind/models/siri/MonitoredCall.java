
package io.young.busfind.models.siri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ExpectedArrivalTime",
    "ExpectedDepartureTime",
    "Extensions",
    "StopPointRef",
    "VisitNumber",
    "StopPointName"
})
public class MonitoredCall {

    @JsonProperty("ExpectedArrivalTime")
    public String expectedArrivalTime;
    @JsonProperty("ExpectedDepartureTime")
    public String expectedDepartureTime;
    @JsonProperty("Extensions")
    public Extensions extensions;
    @JsonProperty("StopPointRef")
    public String stopPointRef;
    @JsonProperty("VisitNumber")
    public Integer visitNumber;
    @JsonProperty("StopPointName")
    public String stopPointName;

}
