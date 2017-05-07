package io.young.busfind.presenters;

import io.young.busfind.models.apiapi.ApiaiRequest;

public class ApiaiParser {
    private ApiaiRequest apiaiRequest;

    public ApiaiParser(ApiaiRequest apiaiRequest) {
        this.apiaiRequest = apiaiRequest;
    }

    public String getStopCode() {
        return apiaiRequest.result.parameters.stopcode;
    }
}
