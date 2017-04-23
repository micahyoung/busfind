package io.young.busfind;

import lombok.Value;

@Value
public class Estimate {

    public String eta;

    public Estimate(String eta) {
        this.eta = eta;
    }
}
