
package io.young.busfind.models.apiapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "result",
})
@JsonIgnoreProperties({
        "id",
        "originalRequest",
        "lang",
        "status",
        "timestamp",
        "sessionId",
})
public class ApiaiRequest {

    @JsonProperty("result")
    public Result result;

}
