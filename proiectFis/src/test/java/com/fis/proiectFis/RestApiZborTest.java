package com.fis.proiectFis;

import com.fis.proiectFis.entities.Zbor;
import com.fis.proiectFis.repositories.ZborRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fis.proiectFis.restAPI.RestApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RestApi.class)
public class RestApiZborTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ZborRepo zborRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAll() throws Exception {
        when(zborRepo.findAll()).thenReturn(Collections.singletonList(new Zbor()));

        mockMvc.perform(get("/getAll/zbor"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testCreate() throws Exception {
        Zbor zbor = new Zbor();
        zbor.setId(1);
        zbor.setOrasdus("Bucharest");
        zbor.setDestinatie("New York");

        mockMvc.perform(post("/create/zbor/test-wrong-path")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(zbor)))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdate() throws Exception {
        Zbor zbor = new Zbor();
        zbor.setId(1);
        zbor.setOrasdus("Bucharest");
        zbor.setDestinatie("New York");

        when(zborRepo.save(any(Zbor.class))).thenReturn(zbor);

        mockMvc.perform(put("/update/zbor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(zbor)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        int id = 1;

        mockMvc.perform(delete("/delete/zbor/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testSearchFlight() throws Exception {
        when(zborRepo.findZborsByOrasdusAndDestinatie("Bucharest", "New York"))
                .thenReturn(Collections.singletonList(new Zbor()));

        mockMvc.perform(get("/getZbor/Bucharest/New York"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testGetById() throws Exception {
        int id = 1;
        Zbor zbor = new Zbor();
        zbor.setId(id);

        when(zborRepo.findById(id)).thenReturn(Optional.of(zbor));

        mockMvc.perform(get("/getzborById/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id));
    }
}