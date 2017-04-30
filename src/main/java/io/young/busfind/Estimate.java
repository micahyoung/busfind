package io.young.busfind;

import lombok.Value;

@Value
public class Estimate {

    public String eta;
    public Double distance;

    public Estimate(String eta, Double distance) {
        this.eta = eta;
        this.distance = distance;
    }
}
