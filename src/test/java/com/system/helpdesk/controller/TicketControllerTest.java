package com.system.helpdesk.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@WithMockUser
class TicketControllerTest {

    @Test
    void createdTicket() {
    }

    @Test
    void getAllTicket() {
    }

    @Test
    void updateTicket() {
    }

    @Test
    void deleteTicket() {
    }
}