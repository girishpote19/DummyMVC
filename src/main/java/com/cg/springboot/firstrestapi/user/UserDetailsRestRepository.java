package com.cg.springboot.firstrestapi.user;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDetailsRestRepository extends PagingAndSortingRepository<UserDetails, Long> {
	List<UserDetails> findByRole(String role);
}