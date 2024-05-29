package com.fis.proiectFis;

import com.fis.proiectFis.entities.Rezervare;
import com.fis.proiectFis.repositories.RezervareRepo;
import com.fis.proiectFis.restAPI.RestApiRezervare;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.when;

@WebMvcTest(RestApiRezervare.class)
public class RestApiRezervareTest {

    @MockBean
    private RezervareRepo rezervareRepo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllRezervare() throws Exception {
        when(rezervareRepo.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/getAll/rezervare/test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());
    }

    @Test
    void testCreateRezervare() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/create/rezervare")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteRezervare() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/rezervare/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testUpdateRezervare() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/update/rezervare")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1, \"oras_dus\": \"Bucuresti\", \"oras_intors\": \"Cluj\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
