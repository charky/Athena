package com.charky.service;

import com.charky.domain.Website;

public interface WebsiteService {

	public Website save(Website website);
	
	public Iterable<Website> findAll();
	
	public Website findById(int id);
	
	public void delete(int id);
	
}
