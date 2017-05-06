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

import java.time.LocalDateTime;

import static org.mockito.Mockito.doThrow;
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
        when(estimatesRepository.findByStationId("551608")).thenReturn(new Estimate(LocalDateTime.now(), 3, 2001.26));

        mockMvc.perform(post("/api/v1/webhook")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'speech': 'It will arrive in 0 minutes and is 3 stops and 1.2 miles away.'}"));
    }
}
