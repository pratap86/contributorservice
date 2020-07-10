package com.pratap.contributors.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratap.contributors.dto.ContributorDto;
import com.pratap.contributors.model.ContributorResponceModel;
import com.pratap.contributors.services.ContributorService;

@RestController
@RequestMapping("/contributors")
public class ContributorController {

	@Autowired
	private ContributorService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/search")
	public ResponseEntity<List<ContributorResponceModel>> getContributorsByCity(@RequestParam(value = "city") String city, @RequestParam(value = "page", defaultValue = "0") int page, 
			@RequestParam(value = "limit", defaultValue = "25") int limit, @RequestParam(value = "sortBy", defaultValue = "firstName") String sortBy){
		
		List<ContributorDto> dtos = service.getContributorsByCity(city, page, limit, sortBy);
		List<ContributorResponceModel> respValues = dtos.stream()
				.map(dto -> modelMapper.map(dto, ContributorResponceModel.class)).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(respValues);
	}
}
