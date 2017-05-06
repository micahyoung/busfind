package io.young.busfind.repositories;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
public class EstimatesRepositoryRealTest extends EstimatesRepositoryContractTest {
    @Value("${busfind.mtaApiKey}")
    String mtaApiKey;

    @Before
    public void setUp() throws Exception {
        dataSet = new RealDataSet();
        estimatesRepository = new EstimatesRepository(mtaApiKey, new RestTemplate());
    }

    class RealDataSet implements DataSet {
        @Override
        public void setUp(RestTemplate restTemplate) throws IOException {
        }

        @Override
        public void tearDown() {
        }

        @Override
        public String validStationId() {
            return "401774"; // station on busiest line;
        }

        @Override
        public String invalidStationId() {
            return "";
        }

        @Override
        public LocalDateTime minExpectedDate() {
            return LocalDateTime.now(); // station on busiest line;
        }

        @Override
        public Double minExpectedDistance() {
            return 0.0; // may be very close
        }

    }
}