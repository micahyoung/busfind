
package io.young.busfind.models.siri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ServiceDelivery"
})
public class Siri {

    @JsonProperty("ServiceDelivery")
    public ServiceDelivery serviceDelivery;

}
