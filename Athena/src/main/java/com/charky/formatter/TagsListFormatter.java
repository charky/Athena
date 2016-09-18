package com.charky.formatter;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.charky.domain.Tag;
import com.charky.domain.TagRepository;

@Component
public class TagsListFormatter  implements Formatter<List<Tag>>{

	private TagRepository tagRepository; 
	
	public TagsListFormatter(TagRepository tagRepository) {
		super();
		this.tagRepository = tagRepository;
	}

	@Override
	public String print(List<Tag> tagList, Locale locale) {
		String sReturn="";
		for(Tag tag: tagList){
			sReturn += ((sReturn.length() > 0)?", ":"")+tag.getName();
		}
		return sReturn;
	}
	
	@Override
	public List<Tag> parse(String sTagList, Locale locale) throws ParseException {
		String[] tagList = sTagList.split(",");
		List<Tag> tags = new LinkedList<Tag>();
        for(String tag: tagList){
        	//Check if Tag Exists
        	Tag t = tagRepository.findByName(tag);
        	if(t == null){
        		t = new Tag(tag.trim());
        	}
        	tags.add(t);
        }
        return tags;
	}

}
