package com.charky.repository;

import org.springframework.data.repository.CrudRepository;

import com.charky.domain.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
	public Tag findByName(String name);
}
