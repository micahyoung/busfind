package io.young.busfind.presenters;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class SiriParserTest {
    @Test
    public void getExtepectedArrivalTime_whenArrivalTimeSet_returnsDateString() throws Exception {
        String siriJson = "{\n" +
                "  \"Siri\": {\n" +
                "    \"ServiceDelivery\": {\n" +
                "      \"StopMonitoringDelivery\": [\n" +
                "        {\n" +
                "          \"MonitoredStopVisit\": [\n" +
                "            {\n" +
                "              \"MonitoredVehicleJourney\": {\n" +
                "                \"MonitoredCall\": {\n" +
                "                  \"ExpectedArrivalTime\": \"2017-04-29T23:34:35.024-04:00\",\n" +
                "                  \"ExpectedDepartureTime\": \"2017-04-29T23:34:35.024-04:00\",\n" +
                "                  \"Extensions\": {\n" +
                "                    \"Distances\": {\n" +
                "                      \"PresentableDistance\": \"2.4 miles away\",\n" +
                "                      \"DistanceFromCall\": 3785.69,\n" +
                "                      \"StopsFromCall\": 13\n" +
                "                    }\n" +
                "                  },\n" +
                "                  \"StopPointName\": \"74 ST/34 AV\"\n" +
                "                }\n" +
                "              }\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}\n";
        SiriParser siriParser = new SiriParser(siriJson);
        assertThat(siriParser.getExtepectedArrivalTime(), equalTo("2017-04-29T23:34:35.024-04:00"));
    }

    @Test
    public void getExtepectedArrivalTime_whenNoArrivalTimeSet_returnsNull() throws Exception {
        String siriJson = "{\n" +
                "  \"Siri\": {\n" +
                "    \"ServiceDelivery\": {\n" +
                "      \"StopMonitoringDelivery\": [\n" +
                "        {\n" +
                "          \"MonitoredStopVisit\": [\n" +
                "            {\n" +
                "              \"MonitoredVehicleJourney\": {\n" +
                "                \"MonitoredCall\": {\n" +
                "                  \"Extensions\": {\n" +
                "                    \"Distances\": {\n" +
                "                      \"PresentableDistance\": \"2.4 miles away\",\n" +
                "                      \"DistanceFromCall\": 3785.69,\n" +
                "                      \"StopsFromCall\": 13\n" +
                "                    }\n" +
                "                  },\n" +
                "                  \"StopPointName\": \"74 ST/34 AV\"\n" +
                "                }\n" +
                "              }\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}\n";
        SiriParser siriParser = new SiriParser(siriJson);
        assertThat(siriParser.getExtepectedArrivalTime(), is(nullValue()));
    }

    @Test
    public void getDistance() throws Exception {
        String siriJson = "{\n" +
                "  \"Siri\": {\n" +
                "    \"ServiceDelivery\": {\n" +
                "      \"StopMonitoringDelivery\": [\n" +
                "        {\n" +
                "          \"MonitoredStopVisit\": [\n" +
                "            {\n" +
                "              \"MonitoredVehicleJourney\": {\n" +
                "                \"MonitoredCall\": {\n" +
                "                  \"Extensions\": {\n" +
                "                    \"Distances\": {\n" +
                "                      \"PresentableDistance\": \"2.4 miles away\",\n" +
                "                      \"DistanceFromCall\": 3785.69,\n" +
                "                      \"StopsFromCall\": 13\n" +
                "                    }\n" +
                "                  },\n" +
                "                  \"StopPointName\": \"74 ST/34 AV\"\n" +
                "                }\n" +
                "              }\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}\n";
        SiriParser siriParser = new SiriParser(siriJson);
        assertThat(siriParser.getDistance(), equalTo(3785.69));
    }
}