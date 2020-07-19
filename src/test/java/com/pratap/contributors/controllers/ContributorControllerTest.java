package com.pratap.contributors.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pratap.contributors.dto.ContributorDto;
import com.pratap.contributors.services.ContributorService;

@WebMvcTest(ContributorController.class)
class ContributorControllerTest {

	private static final String CONTRBUTOR_ID = "ABCD1234xz";

	private static final String CITY = "Bangalore";

	private static final String FIRST_NAME = "Test";

	private static final String LAST_NAME = "Last";

	private static final String EMAIL = "test@email.com";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ContributorService contributorService;

	private List<ContributorDto> contributors = new ArrayList<>();

	@BeforeEach
	public void setup() {

		ContributorDto contributorDto = new ContributorDto();
		contributorDto.setContributorId(CONTRBUTOR_ID);
		contributorDto.setCity(CITY);
		contributorDto.setFirstName(FIRST_NAME);
		contributorDto.setLastName(LAST_NAME);
		contributorDto.setEmail(EMAIL);

		contributors.add(contributorDto);
	}

	@Test
	void testGetContributorsByCity() throws Exception {

		when(contributorService.getContributorsByCity(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString())).thenReturn(contributors);

		RequestBuilder request = MockMvcRequestBuilders.get("/contributors/search?city=")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json(
				"[{contributorId : ABCD1234xz, firstName : Test, lastName : Last, email : test@email.com, city : Bangalore}]"))
				.andReturn();
	}

}
