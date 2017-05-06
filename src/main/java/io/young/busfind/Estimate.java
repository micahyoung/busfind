package io.young.busfind;

import lombok.Value;

import java.time.ZonedDateTime;

@Value
public class Estimate {

    public ZonedDateTime eta;
    public Double distance;
    private int stops;

    public Estimate(ZonedDateTime eta, int stops, Double distance) {
        this.eta = eta;
        this.stops = stops;
        this.distance = distance;
    }
}
