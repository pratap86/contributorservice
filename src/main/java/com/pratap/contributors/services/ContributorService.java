package com.pratap.contributors.services;

import java.util.List;

import com.pratap.contributors.dto.ContributorDto;

public interface ContributorService {

	List<ContributorDto> getContributorsByCity(String city);
}
