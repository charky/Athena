package com.charky.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.charky.domain.Website;

public interface WebsiteRepository extends CrudRepository<Website,Integer>{

	public List<Website> findByTitle(String title);
		
	//public List<Website> findTop10ByHits();
}
