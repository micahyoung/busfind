
package io.young.busfind.models.siri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "PresentableDistance",
    "DistanceFromCall",
    "StopsFromCall",
    "CallDistanceAlongRoute"
})
public class Distances {

    @JsonProperty("PresentableDistance")
    public String presentableDistance;
    @JsonProperty("DistanceFromCall")
    public Double distanceFromCall;
    @JsonProperty("StopsFromCall")
    public Integer stopsFromCall;
    @JsonProperty("CallDistanceAlongRoute")
    public Double callDistanceAlongRoute;

}
