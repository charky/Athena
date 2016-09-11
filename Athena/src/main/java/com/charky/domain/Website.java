package com.charky.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;



@Entity
public class Website {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	private String title;
	private String url;
	private int hits = 0;

	@ManyToMany
	@JoinTable(
			name = "website_tag", 
			joinColumns = @JoinColumn(name = "website_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
	private List<Tag> tags;
	
	
	protected Website() {}

    public Website(String title, String url, List<Tag> tags) {
        this.title = title;
        this.url = url;
        this.tags = tags;
    }
	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
    	 String result = String.format(
                 "Book [id=%d, name='%s', url='%s', hits='%d]%n",
                 id, title, url, hits);
         if (tags != null) {
             for(Tag tag : tags) {
                 result += String.format(
                         "    Tag[id=%d, name='%s']%n",
                         tag.getId(), tag.getName());
             }
         }
         return result;
	}
}
