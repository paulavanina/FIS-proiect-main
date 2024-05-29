package com.fis.proiectFis;


import com.fis.proiectFis.entities.Zbor;
import com.fis.proiectFis.repositories.RezervareRepo;
import com.fis.proiectFis.restAPI.RestApiRezervare;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(RestApiRezervare.class)
public class ProiectFisApplicationTests {

		private Zbor zbor;

		@BeforeEach
		public void setUp() {
			zbor = new Zbor();
		}

		@Test
		public void testCodZbor() {
			zbor.setCod_zbor(1234);
			assertEquals(1234, zbor.getCod_zbor());
		}

		@Test
		public void testNrLocuriTotal() {
			zbor.setNr_locuri_total(160);
			assertEquals(180, zbor.getNr_locuri_total());
		}

		@Test
		public void testDataPlecare() {
			LocalDate dataPlecare = LocalDate.of(2024, 5, 28);
			zbor.setData_plecare(dataPlecare);
			assertEquals(dataPlecare, zbor.getData_plecare());
		}

		@Test
		public void testDataSosire() {
			LocalDate dataSosire = LocalDate.of(2024, 5, 29);
			zbor.setData_sosire(dataSosire);
			assertEquals(dataSosire, zbor.getData_sosire());
		}

		@Test
		public void testNumeCompanie() {
			zbor.setNume_companie("Airline");
			assertEquals("Airline", zbor.getNume_companie());
		}

	@MockBean
	private RezervareRepo rezervareRepo;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetAllRezervare() throws Exception {
		// Mock the repository's behavior
		when(rezervareRepo.findAll()).thenReturn(Collections.emptyList());

		// Perform the GET request and verify the response
		mockMvc.perform(MockMvcRequestBuilders.get("/getAll/rezervare"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());
	}

	@Test
	void testCreateRezervare() throws Exception {
		// Perform the POST request and verify the response
		mockMvc.perform(MockMvcRequestBuilders.post("/create/rezervare")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"id\": 1, \"oras_dus\": \"Bucuresti\", \"oras_intors\": \"Cluj\"}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testDeleteRezervare() throws Exception {
		// Perform the DELETE request and verify the response
		mockMvc.perform(MockMvcRequestBuilders.delete("/delete/rezervare/{id}", 1))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testUpdateRezervare() throws Exception {
		// Perform the PUT request and verify the response
		mockMvc.perform(MockMvcRequestBuilders.put("/update/rezervare")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"id\": 1, \"oras_dus\": \"Bucuresti\", \"oras_intors\": \"Cluj\"}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}


	}

