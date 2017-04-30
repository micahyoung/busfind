
package io.young.busfind.models.siri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ResponseTimestamp",
    "StopMonitoringDelivery"
})
public class ServiceDelivery {

    @JsonProperty("ResponseTimestamp")
    public String responseTimestamp;
    @JsonProperty("StopMonitoringDelivery")
    public List<StopMonitoringDelivery> stopMonitoringDelivery = null;

}
