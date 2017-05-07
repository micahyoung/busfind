
package io.young.busfind.models.apiapi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "parameters",
})
@JsonIgnoreProperties({
        "contexts",
        "resolvedQuery",
        "source",
        "score",
        "speech",
        "fulfillment",
        "actionIncomplete",
        "action",
        "metadata",
})
public class Result {

    @JsonProperty("parameters")
    public Parameters parameters;

}
