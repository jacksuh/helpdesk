package com.system.helpdesk.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@WithMockUser
class TicketControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Test erro 400")
    @WithMockUser
    void user_test1() throws Exception {
        var response = mvc.perform(post("/ticket"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }


    @Test
    @DisplayName("Test  201")
    @WithMockUser
    void createdTicket() throws Exception{

        String json = "{\"description\":\"aberto chamado teste\",\"status\":\"OPEN\",\"user\":{\"id\":\"2\"}}";

        var response = mvc.perform(
                        post("/ticket")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

    }

    @Test
    @DisplayName("Test http GET 200")
    @WithMockUser
    void getAllTicket()  throws Exception{
        var response = mvc
                .perform(get("/ticket")
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }


    @Test
    @DisplayName("Test http update 200")
    @WithMockUser
    void updateTicket() throws Exception{

        String json = "{\"solution\":\"Chamado Fechado\",\"status\":\"CLOSED\",\"userclosed\":\"Jackson\"}";

        var response = mvc.perform(
                put("/ticket/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }

    @Test
    @DisplayName("Test Delete")
    @WithMockUser
    void deleteTicket() throws Exception {
        var response = mvc.perform(
                delete("/ticket/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }
}