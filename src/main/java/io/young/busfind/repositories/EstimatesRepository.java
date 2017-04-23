package io.young.busfind.repositories;

import io.young.busfind.Estimate;
import org.springframework.stereotype.Component;

@Component
public class EstimatesRepository {

    public Estimate findByLatitudeAndLongitude(String latitude, String longitude) {
        return new Estimate("12:05");
    }
}
