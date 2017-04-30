package io.young.busfind.repositories;

import io.young.busfind.Estimate;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

public abstract class EstimatesRepositoryContractTest {
    DataSet dataSet;
    EstimatesRepository estimatesRepository;

    @Test
    public void EstimateRepository_findByLatitudeAndLongitude_returnsEstimate() throws Exception {
        Estimate estimate = estimatesRepository.findByStationId(dataSet.stationId());
        assertThat(estimate.distance, is(greaterThanOrEqualTo(dataSet.minExpectedDistance())));
        assertThat(LocalDate.parse(estimate.eta, DateTimeFormatter.ISO_OFFSET_DATE_TIME), is(greaterThanOrEqualTo(dataSet.minExpectedDate())));
    }

    interface DataSet {
        String stationId();
        LocalDate minExpectedDate();
        Double minExpectedDistance();
    }
}
