package com.example.indra.controller;

import com.example.indra.dto.ResponseDTO;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@Rollback
class ControllerPriceTest {

    @Autowired
    private MockMvc mvc;

    @Order(1)
    @ParameterizedTest
    @MethodSource("arg")
    @DisplayName("rate")
    @Transactional(readOnly = true)
    void rate(String date, String startDate, String endDate) throws Exception {

        String url = String.format("/price/rate?date=%s&productId=35455&brandId=1", date);
        mvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(response -> {
                    ResponseDTO responseDTO = new Gson().fromJson(response.getResponse().getContentAsString(), ResponseDTO.class);
                    LinkedTreeMap<?, ?> result = ((LinkedTreeMap<?, ?>) responseDTO.getValue());
                    assertEquals(startDate, result.get("startDate"));
                    assertEquals(endDate, result.get("endDate"));
                });
    }

    static Stream<Arguments> arg() {
        return Stream.of(
                Arguments.of("14 10:00", "2020-06-14T00:00:00", "2020-12-31T23:59:59"),
                Arguments.of("14 16:00", "2020-06-14T15:00:00", "2020-06-14T18:30:00"),
                Arguments.of("14 21:00", "2020-06-14T00:00:00", "2020-12-31T23:59:59"),
                Arguments.of("15 10:00", "2020-06-15T00:00:00", "2020-06-15T11:00:00"),
                Arguments.of("16 21:00", "2020-06-15T16:00:00", "2020-12-31T23:59:59")
        );
    }
}
