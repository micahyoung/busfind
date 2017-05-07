package io.young.busfind;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EstimatesIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
	public void post_whenEstimateFound_ReturnsEstimate() throws Exception {
        File apiaiRequsetFile = ResourceUtils.getFile("classpath:apiai-request.json");
        String apiaiRequestJson = new String(Files.readAllBytes(apiaiRequsetFile.toPath()));

        HttpEntity<String> requestEntity = new HttpEntity<>(apiaiRequestJson,  new HttpHeaders(){{ setContentType(MediaType.APPLICATION_JSON); }});
        ResponseEntity<String> responseEntity = restTemplate.exchange("/api/v1/webhook", HttpMethod.POST, requestEntity, String.class);
        assertThat(responseEntity.getBody(), containsString("speech"));
    }
}
