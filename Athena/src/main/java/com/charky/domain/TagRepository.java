package com.charky.domain;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {
	public Tag findByName(String name);
}
