package com.example.kmart.controller;


import com.example.kmart.dto.CancellationRateResponse;
import com.example.kmart.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(TripController.class)
public class TripControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private List<CancellationRateResponse> responses;

    @Before
    public void createDummyResponse() {
        this.responses = new ArrayList<>();
        CancellationRateResponse resp1 = new CancellationRateResponse("2019-05-01", "0.33");
        CancellationRateResponse resp2 = new CancellationRateResponse("2019-05-02", "0.00");
        responses.addAll(Arrays.asList(resp1, resp2));
    }


    @Test
    public void testCancellationRateResponse() throws Exception {
        when(userService.getCancellationRate("May 1, 2019", "May 2, 2019")).thenReturn(responses);
        mockMvc.perform(get("/cancellationRate?start=May 1, 2019&end=May 2, 2019"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].day", is("2019-05-01")))
                .andExpect(jsonPath("$[0].cancellationRate", is("0.33")))
                .andExpect(jsonPath("$[1].day", is("2019-05-02")))
                .andExpect(jsonPath("$[1].cancellationRate", is("0.00")));

    }

    @Test
    public void shouldCallObjectOnce() throws Exception {
        when(userService.getCancellationRate("May 1, 2019", "May 2, 2019")).thenReturn(responses);
        mockMvc.perform(get("/cancellationRate?start=May 1, 2019&end=May 2, 2019"));
        verify(userService, times(1)).getCancellationRate("May 1, 2019", "May 2, 2019");
        verifyNoMoreInteractions(userService);
    }


    @Test
    public void shouldThrowExceptionIfEndDateIsMissing() throws Exception {
        when(userService.getCancellationRate("May 1, 2019", "May 2, 2019")).thenReturn(responses);
        mockMvc.perform(get("/cancellationRate?start=May 1, 2019"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError());
    }


}

