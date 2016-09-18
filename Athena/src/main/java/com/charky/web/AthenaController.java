package com.charky.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.charky.domain.TagRepository;
import com.charky.domain.Website;
import com.charky.domain.WebsiteRepository;

@Controller
public class AthenaController {
	
	private static final Logger logger = LoggerFactory.getLogger(AthenaController.class);
	
	@Autowired
	private WebsiteRepository websiteRepository;
	
	@Autowired
	private TagRepository tagRepository; 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("website", new Website()); 
		model.addAttribute("websites", websiteRepository.findAll());
		return "index";
	}
	
	@RequestMapping(value="/websites",method=RequestMethod.POST)
	public RedirectView addWebsite(@ModelAttribute("website") Website website, RedirectAttributes attributes, BindingResult result){
		if (result.hasErrors()) 
        {
            logger.debug(result.toString());
        }
		tagRepository.save(website.getTags());
		websiteRepository.save(website);
		attributes.addFlashAttribute("message", "Website-Entry has been added.");
		return new RedirectView("/"); 
	}
	
	
}
