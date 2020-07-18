package com.pratap.contributors.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pratap.contributors.dto.ContributorDto;
import com.pratap.contributors.entities.ContributorEntity;
import com.pratap.contributors.exceptions.ContributorServiceException;
import com.pratap.contributors.repos.ContributorRepository;

@Service
public class ContributorServiceImpl implements ContributorService {

	@Autowired
	private ContributorRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ContributorDto> getContributorsByCity(String city, int page, int limit, String sortBy) {

		Pageable pageableRequest = PageRequest.of(page, limit, Sort.by(sortBy));
		
		List<ContributorEntity> contributors = repository.findByCity(city, pageableRequest);
		
		if (contributors == null || contributors.isEmpty()) {
			throw new ContributorServiceException("No one contribute yet in this - " + city);
		}

		return contributors.stream()
				.map(contributor -> modelMapper.map(contributor, ContributorDto.class)).collect(Collectors.toList());
	}

}
