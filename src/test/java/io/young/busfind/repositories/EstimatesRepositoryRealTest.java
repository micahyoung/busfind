package io.young.busfind.repositories;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

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
        public String stationId() {
            return "401774"; // station on busiest line;
        }

        @Override
        public LocalDate minExpectedDate() {
            return LocalDate.now(); // station on busiest line;
        }

        @Override
        public Double minExpectedDistance() {
            return 0.0; // may be very close
        }

    }
}