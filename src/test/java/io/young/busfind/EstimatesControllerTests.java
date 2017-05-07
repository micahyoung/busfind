package io.young.busfind;

import io.young.busfind.controllers.EstimatesController;
import io.young.busfind.repositories.EstimatesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.ZonedDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EstimatesController.class)
public class EstimatesControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    EstimatesRepository estimatesRepository;

    @Test
	public void post_whenEstimateFound_ReturnsEstimate() throws Exception {
        when(estimatesRepository.findByStationId("551608")).thenReturn(new Estimate(ZonedDateTime.now(), 3, 2001.26, "Q47"));

        mockMvc.perform(post("/api/v1/webhook")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"result\": { \"parameters\": { \"stopcode\": \"551608\" }}}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'speech': 'The Q47 bus will arrive in 0 minutes and is 3 stops and 1.2 miles away.'}"));
    }
}
