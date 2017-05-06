package io.young.busfind.presenters;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class SiriParserTest {
    @Test
    public void whenArrivalTimeSet_allFieldsReturn() throws Exception {
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
        assertThat(siriParser.getExtepectedArrivalTime(), equalTo(LocalDateTime.parse("2017-04-29T23:34:35.024-04:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME)));
        assertThat(siriParser.getDistance(), equalTo(3785.69));
        assertThat(siriParser.getStops(), equalTo(13));
        assertThat(siriParser.valid(), is(true));
    }

    @Test
    public void whenNoArrivalTimeSet_getExtepectedArrivalTime_returnsNull() throws Exception {
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
                "                  }\n" +
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
        assertThat(siriParser.getDistance(), equalTo(3785.69));
        assertThat(siriParser.getStops(), equalTo(13));
        assertThat(siriParser.valid(), is(true));
    }

    @Test
    public void valid_withError() throws Exception {
        String siriJson = "{\n" +
                "  \"Siri\": {\n" +
                "    \"ServiceDelivery\": {\n" +
                "      \"ResponseTimestamp\": \"2017-05-06T12:25:31.722-04:00\",\n" +
                "      \"StopMonitoringDelivery\": [\n" +
                "        {\n" +
                "          \"ResponseTimestamp\": \"2017-05-06T12:25:31.722-04:00\",\n" +
                "          \"ErrorCondition\": {\n" +
                "            \"OtherError\": {\n" +
                "              \"ErrorText\": \"No such stop: MTA_null.\"\n" +
                "            },\n" +
                "            \"Description\": \"No such stop: MTA_null.\"\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}";
        SiriParser siriParser = new SiriParser(siriJson);
        assertThat(siriParser.valid(), is(false));
    }
}