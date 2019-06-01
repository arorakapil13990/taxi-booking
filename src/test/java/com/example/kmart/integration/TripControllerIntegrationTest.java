package com.example.kmart.integration;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class TripControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void testCancellationResponse() throws Exception {
        mvc.perform(get("/cancellationRate?start=May 1, 2019&end=May 3, 2019")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(6)))
                .andExpect(jsonPath("$[0].day", is("2019-05-01")))
                .andExpect(jsonPath("$[0].cancellationRate", is("0.33")))
                .andExpect(jsonPath("$[1].day", is("2019-05-02")))
                .andExpect(jsonPath("$[1].cancellationRate", is("0.00")))
                .andExpect(jsonPath("$[2].day", is("2019-05-03")))
                .andExpect(jsonPath("$[2].cancellationRate", is("0.00")))
                .andExpect(jsonPath("$[3].day", is("2019-05-04")))
                .andExpect(jsonPath("$[3].cancellationRate", is("2.00")))
                .andExpect(jsonPath("$[4].day", is("2019-05-06")))
                .andExpect(jsonPath("$[4].cancellationRate", is("2.00")))
                .andExpect(jsonPath("$[5].day", is("2019-05-07")))
                .andExpect(jsonPath("$[5].cancellationRate", is("0.00")));

    }
}


