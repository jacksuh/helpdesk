/**package com.system.helpdesk.controller;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@WithMockUser
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Test erro 400")
    void user_test1() throws Exception {
        var response = mvc.perform(post("/login"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }


    @Test
    @DisplayName("Test  201")
    void user_test2() throws Exception {

        String json = "{\"login\":\"jackson\",\"password\":\"123456\"}";

        var response = mvc.perform(
                        post("/login/new")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

    }


    @Test
    @DisplayName("Test http GET 200")
    @WithMockUser
    void user_test3() throws Exception {

        var response = mvc
                .perform(get("/login")
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }


    @Test
    @DisplayName("Test Update")
    @WithMockUser
    void user_test4() throws Exception {

        String json = "{\"login\":\"jacksonSantos\",\"password\":\"123456\"}";

        var response = mvc
                .perform(put("/login/{id}", 2L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }

    @Test
    @DisplayName("Test Delete")
    @WithMockUser
    void user_test5() throws Exception {

        var response = mvc
                .perform(delete("/login/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }

}
 **/