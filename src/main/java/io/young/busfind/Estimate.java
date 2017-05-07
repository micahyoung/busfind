package io.young.busfind;

import lombok.Value;

import java.time.ZonedDateTime;

@Value
public class Estimate {

    public ZonedDateTime eta;
    public Double distance;
    private int stops;
    private final String lineName;

    public Estimate(ZonedDateTime eta, int stops, Double distance, String lineName) {
        this.eta = eta;
        this.stops = stops;
        this.distance = distance;
        this.lineName = lineName;
    }
}
