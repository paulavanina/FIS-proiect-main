package com.fis.proiectFis;

import com.fis.proiectFis.entities.Utilizator;
import com.fis.proiectFis.repositories.RezervareRepo;
import com.fis.proiectFis.repositories.UserRepo;
import com.fis.proiectFis.restAPI.RestApiUser;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest(RestApiUser.class)
public class RestApiUserTest {

    @MockBean
    private UserRepo userRepo;

    @MockBean
    private RezervareRepo rezervareRepo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllUsers() throws Exception {
        when(userRepo.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/getAll/user/test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());
    }

    @Test
    void testCreateUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/create/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nume\": \"John\", \"parola\": \"password\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testUpdateUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/update/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1, \"nume\": \"John\", \"parola\": \"newpassword\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteUser() throws Exception {
        Mockito.doNothing().when(userRepo).deleteById(1);

        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/user/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetUserByUsernameAndPassword() throws Exception {
        Utilizator utilizator = new Utilizator();
        utilizator.setNume("John");
        utilizator.setParola("password");
        when(userRepo.findUtilizatorByNumeAndAndParola("John", "password")).thenReturn(utilizator);

        mockMvc.perform(MockMvcRequestBuilders.get("/getUser/John/password"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nume").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.parola").value("password"));
    }

    @Test
    void testGetUserById() throws Exception {
        Utilizator utilizator = new Utilizator();
        utilizator.setId(1);
        utilizator.setNume("John");
        utilizator.setParola("password");
        when(userRepo.findById(1)).thenReturn(Optional.of(utilizator));

        mockMvc.perform(MockMvcRequestBuilders.get("/getuserById/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nume").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.parola").value("password"));
    }

}
