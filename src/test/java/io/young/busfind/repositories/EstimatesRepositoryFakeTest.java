package io.young.busfind.repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.client.ExpectedCount.manyTimes;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
public class EstimatesRepositoryFakeTest extends EstimatesRepositoryContractTest {
    MockRestServiceServer server;

    @Before
    public void setUp() throws Exception {
        File siriResponseFile = ResourceUtils.getFile("classpath:siri-response.json");
        String siriResponseJson = new String(Files.readAllBytes(siriResponseFile.toPath()));

        RestTemplate restTemplate = new RestTemplate();
        server = MockRestServiceServer.bindTo(restTemplate).build();

        server.expect(once(), requestTo("http://bustime.mta.info/api/siri/stop-monitoring.json?OperatorRef=MTA&MonitoringRef=404165&key=foo")).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(siriResponseJson, MediaType.APPLICATION_JSON));

        dataSet = new FakeDataSet();
        estimatesRepository = new EstimatesRepository("foo", restTemplate);
    }

    @After
    public void after() throws Exception {
        server.verify();
    }

    class FakeDataSet implements DataSet {
        @Override
        public String stationId() {
            return "404165"; // station on busiest line;
        }

        @Override
        public LocalDate minExpectedDate() {
            return LocalDate.parse("2017-04-29T23:34:35.024-04:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }

        @Override
        public Double minExpectedDistance() {
            return 3785.69;
        }
    }
}