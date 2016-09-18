package com.charky.service;

import com.charky.domain.Tag;

public interface TagService {
	
	public Tag save(Tag tag);
	
	public Iterable<Tag> save(Iterable<Tag> tags);
	
	public Tag findByName(String name);

}
