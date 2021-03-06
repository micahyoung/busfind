package io.young.busfind.repositories;

import io.young.busfind.Estimate;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

public abstract class EstimatesRepositoryContractTest {
    DataSet dataSet;
    EstimatesRepository estimatesRepository;

    @Test
    public void EstimateRepository_findByStopcode_whenSuccess_returnsEstimate() throws Exception {
        Estimate estimate = estimatesRepository.findByStationId(dataSet.validStationId());
        assertThat(estimate.distance, is(greaterThanOrEqualTo(dataSet.minExpectedDistance())));
        assertThat(ZonedDateTime.now(), is(greaterThanOrEqualTo(dataSet.minExpectedDate())));
    }

    @Test
    public void EstimateRepository_findByStopcode_whenSuccess_throwsException() throws Exception {
        try {
            estimatesRepository.findByStationId(dataSet.invalidStationId());
            fail("should have thrown");
        } catch (EstimateNotFoundException ignored) {
        }
    }

    interface DataSet {
        void setUp(RestTemplate restTemplate) throws IOException;

        void tearDown();

        String validStationId();

        String invalidStationId();

        ZonedDateTime minExpectedDate();

        Double minExpectedDistance();
    }
}
