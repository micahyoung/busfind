package io.young.busfind;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Estimate {

    public LocalDateTime eta;
    public Double distance;
    private int stops;

    public Estimate(LocalDateTime eta, int stops, Double distance) {
        this.eta = eta;
        this.stops = stops;
        this.distance = distance;
    }
}
