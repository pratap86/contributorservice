package com.pratap.contributors.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import com.pratap.contributors.dto.ContributorDto;
import com.pratap.contributors.entities.ContributorEntity;
import com.pratap.contributors.exceptions.ContributorServiceException;
import com.pratap.contributors.repos.ContributorRepository;

@ExtendWith(MockitoExtension.class)
class ContributorServiceImplTest {
	
	private static final String CONTRBUTOR_ID = "ABCD1234xz";

	private static final String CITY = "Bangalore";

	private static final String FIRST_NAME = "Test";

	private static final String LAST_NAME = "Last";

	private static final String EMAIL = "test@email.com";
	
	@InjectMocks
	private ContributorServiceImpl contributorService;
	
	@Mock
	private ContributorRepository repository;
	
	private List<ContributorEntity> contributors = new ArrayList<>();
	
	@BeforeEach
	public void setup() {
		ContributorEntity entity = new ContributorEntity();
		entity.setContributorId(CONTRBUTOR_ID);
		entity.setFirstName(FIRST_NAME);
		entity.setLastName(LAST_NAME);
		entity.setCity(CITY);
		entity.setEmail(EMAIL);
		
		contributors.add(entity);
	}

	@Test
	void testGetContributorsByCity() {
	
		when(repository.findByCity(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(contributors);
		
		List<ContributorDto> contributorsDto = contributorService.getContributorsByCity(CITY, 1, 1, "firstName");
		
		assertThat(contributorsDto, hasSize(1));
		
	}
	
	@Test
	void testGetContributorsByCityException_Null() {
	
		when(repository.findByCity(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(null);
		
		assertThrows(ContributorServiceException.class, () -> {
			contributorService.getContributorsByCity(CITY, 1, 1, "firstName");
		});
		
	}
	
	@Test
	void testGetContributorsByCityException_Empty() {
	
		when(repository.findByCity(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(new ArrayList<ContributorEntity>());
		
		assertThrows(ContributorServiceException.class, () -> {
			contributorService.getContributorsByCity(CITY, 1, 1, "firstName");
		});
		
	}

}
