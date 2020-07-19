package com.pratap.contributors.repos;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import com.pratap.contributors.entities.ContributorEntity;

@DataJpaTest
class ContributorRepositoryTest {
	
	private static final int PAGE = 0;

	private static final int LIMIT = 25;

	private static final String SORTBY = "firstName";

	private static final String CITY = "Noida";

	@Autowired
	private ContributorRepository contributorRepository;
	
	Pageable pageableRequest;
	
	@BeforeEach
	public void setup() {
		pageableRequest = PageRequest.of(PAGE, LIMIT, Sort.by(SORTBY));
	}

	@Test
	void testFindByCity() {
		
		List<ContributorEntity> contributors = contributorRepository.findByCity(CITY, pageableRequest);
		
		assertThat(contributors, hasSize(10));
		
	}

}
