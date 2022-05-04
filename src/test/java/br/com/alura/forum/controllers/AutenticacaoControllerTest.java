package br.com.alura.forum.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
@AutoConfigureMockMvc
@Profile(value = {"test", "dev"})
class AutenticacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void DeverisDevolver400CasoDadosDeAutenticacaoEstejamIncorretos() throws URISyntaxException {
        URI uri = new URI("/auth");
        String json = "{\"email\":\"test@email.com\",\"password\":\"123\"}";

        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.post(uri)
                            .content(json)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status()
                            .is(400));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void DeverisDevolver200CasoDadosDeAutenticacaoEstejamCorretos() throws URISyntaxException {
        URI uri = new URI("/auth");
        String json = "{\"email\":\"aluno@email.com\",\"senha\":\"123456\"}";

        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.post(uri)
                            .content(json)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status()
                            .is(200));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}