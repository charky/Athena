package com.charky.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WebsiteRepository extends CrudRepository<Website,Integer>{

	public List<Website> findByTitle(String title);
	
	//public List<Website> findTop10ByHits();
}
