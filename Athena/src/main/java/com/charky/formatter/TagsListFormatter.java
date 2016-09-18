package com.charky.formatter;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.charky.domain.Tag;

@Component
public class TagsListFormatter  implements Formatter<List<Tag>>{

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
        	//Trim Tag
        	tag = tag.trim();
        	//Add Tag to list
        	tags.add(new Tag(tag));
        }
        return tags;
	}

}
