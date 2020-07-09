package com.pratap.contributors.repos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratap.contributors.entities.ContributorEntity;
@Repository
public interface ContributorRepository extends PagingAndSortingRepository<ContributorEntity, Long> {

	List<ContributorEntity> findByCity(@Param(value = "city") String city);
}
