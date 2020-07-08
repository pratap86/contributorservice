package com.pratap.contributors.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratap.contributors.dto.ContributorDto;
import com.pratap.contributors.entities.Contributor;
import com.pratap.contributors.exceptions.ContributorNotFoundException;
import com.pratap.contributors.repos.ContributorRepository;

@Service
public class ContributorServiceImpl implements ContributorService {

	@Autowired
	private ContributorRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ContributorDto> getContributorsByCity(String city) {

		List<Contributor> entities = repository.findByCity(city);
		if (entities == null || entities.isEmpty()) {
			throw new ContributorNotFoundException("No one contribute yet in this - " + city);
		}

		return entities.stream()
				.map(contributor -> modelMapper.map(contributor, ContributorDto.class)).collect(Collectors.toList());
	}

}
