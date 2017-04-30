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
	public void post_withLocation_ReturnsEstimate() throws Exception {
        when(estimatesRepository.findByStationId("982009")).thenReturn(new Estimate("12:05", 0.0));

        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .param("stationId", "982009")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'eta': '12:05'}"));
    }

}
