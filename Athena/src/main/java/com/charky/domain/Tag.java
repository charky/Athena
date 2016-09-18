package com.charky.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Tag {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	@ManyToMany(mappedBy="tags")
	private List<Website> websites;
	
	protected Tag() { }

	public Tag(String name) {
		super();
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Website> getWebsites() {
		return websites;
	}

	public void setWebsites(List<Website> websites) {
		this.websites = websites;
	}

	@Override
	public String toString() {
		String result = String.format(
                "Tag [id=%d, name='%s']%n",
                id, name);
        if (websites != null) {
            for(Website website : websites) {
                result += String.format(
                        "    Website[id=%d, title='%s']%n",
                       website.getId(), website.getTitle());
            }
        }
        return result;
	}
	
	
	
	
}
