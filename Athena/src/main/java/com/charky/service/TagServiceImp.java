package com.charky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charky.domain.Tag;
import com.charky.repository.TagRepository;

@Service
public class TagServiceImp implements TagService {

	private TagRepository tagRepository;
	
	@Autowired
	public TagServiceImp(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	@Override
	public Tag save(Tag tag) {
		Tag existing = this.findByName(tag.getName());
		if (existing != null) {
			return existing;
		}
		return tagRepository.save(tag);
	}

	@Override
	@Transactional
	public Iterable<Tag> save(Iterable<Tag> tags) {
		for(Tag tag: tags){
			if(tag.getId() == null){
				Tag existing = this.findByName(tag.getName());
				if (existing != null) {
					tag.setId(existing.getId());
				}
			}
		}
		return tagRepository.save(tags);
	}

	@Override
	public Tag findByName(String name) {
		return tagRepository.findByName(name);
	}

}
