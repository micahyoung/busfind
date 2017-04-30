
package io.young.busfind.models.siri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "MonitoredStopVisit"
})
public class StopMonitoringDelivery {

    @JsonProperty("MonitoredStopVisit")
    public List<MonitoredStopVisit> monitoredStopVisit = null;

}
