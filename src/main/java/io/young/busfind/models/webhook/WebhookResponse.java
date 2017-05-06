package io.young.busfind.models.webhook;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "speech",
        "displayText",
        "data",
        "contextOut",
        "source"
})
public class WebhookResponse {

    @JsonProperty("speech")
    public String speech;
    @JsonProperty("displayText")
    public String displayText;
    @JsonProperty("data")
    public Data data;
    @JsonProperty("contextOut")
    public List<Object> contextOut = null;
    @JsonProperty("source")
    public String source;

}
