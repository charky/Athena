package com.charky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charky.domain.Website;
import com.charky.repository.WebsiteRepository;

@Service
public class WebsiteServiceImp implements WebsiteService {

	private WebsiteRepository websiteRepository;
	private TagService tagService;
	
	@Autowired
	public WebsiteServiceImp(WebsiteRepository websiteRepository, TagService tagService) {
		this.websiteRepository = websiteRepository;
		this.tagService = tagService;
	}

	@Override
	public Website save(Website website) {
		tagService.save(website.getTags());
		return websiteRepository.save(website);
	}

	@Override
	public Iterable<Website> findAll(){
		return websiteRepository.findAll();
	}
	@Override
	public Website findById(int id) {
		return websiteRepository.findOne(id);
	}
	
	@Override
	public void delete(int id){
		websiteRepository.delete(id);
	}

}
