package com.charky;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.charky.domain.Tag;
import com.charky.domain.TagRepository;
import com.charky.domain.Website;
import com.charky.domain.WebsiteRepository;

@Component
public class AthenaRunner  implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(AthenaRunner.class);
	
	private TagRepository tagRepository; 
	
	private WebsiteRepository websiteRepository; 
	
		
	public AthenaRunner(TagRepository tagRepository, WebsiteRepository websiteRepository) {
		super();
		this.tagRepository = tagRepository;
		this.websiteRepository = websiteRepository;
	}
	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0){
			for(String option: arg0){
				logger.info("arg0-option("+option+")");
				if(option.equals("initDB")){
					logger.info("Initializing Database");
					initDB();
				}
			}
		}else{
			logger.info("No Arguments for AthenaRunner");
		}
		
	}
	private void initDB(){
		//Delete all
		
		//Create Tags
		Tag aplhabet = new Tag("aplhabet");
		tagRepository.save(aplhabet);
		Tag books = new Tag("books");
		tagRepository.save(books);
		Tag chatrooms = new Tag("chatrooms");
		tagRepository.save(chatrooms);
		Tag collaboratively = new Tag("collaboratively");
		tagRepository.save(collaboratively);
		Tag dvds = new Tag("dvds");
		tagRepository.save(dvds);
		Tag ecommerce = new Tag("e-commerce");
		tagRepository.save(ecommerce);
		Tag email = new Tag("e-mail");
		tagRepository.save(email);
		Tag encyclopedia = new Tag("encyclopedia");
		tagRepository.save(encyclopedia);
		Tag find = new Tag("find");
		tagRepository.save(find);
		Tag free = new Tag("free");
		tagRepository.save(free);
		Tag friends = new Tag("friends");
		tagRepository.save(friends);
		Tag fun = new Tag("fun");
		tagRepository.save(fun);
		Tag industryexperts  = new Tag("industry experts ");
		tagRepository.save(industryexperts );
		Tag instantmessaging = new Tag("instant messaging");
		tagRepository.save(instantmessaging);
		Tag job = new Tag("job");
		tagRepository.save(job);
		Tag microblogging = new Tag("microblogging");
		tagRepository.save(microblogging);
		Tag onlineauction = new Tag("online auction");
		tagRepository.save(onlineauction);
		Tag paypal = new Tag("paypal");
		tagRepository.save(paypal);
		Tag portal = new Tag("portal");
		tagRepository.save(portal);
		Tag professionalnetworking = new Tag("professional networking");
		tagRepository.save(professionalnetworking);
		Tag sales = new Tag("sales");
		tagRepository.save(sales);
		Tag search = new Tag("search");
		tagRepository.save(search);
		Tag sharelinks = new Tag("share links");
		tagRepository.save(sharelinks);
		Tag shopping = new Tag("shopping");
		tagRepository.save(shopping);
		Tag social = new Tag("social");
		tagRepository.save(social);
		Tag tweets = new Tag("tweets");
		tagRepository.save(tweets);
		Tag uploadphotos = new Tag("upload photos");
		tagRepository.save(uploadphotos);
		Tag videos = new Tag("videos");
		tagRepository.save(videos);
		Tag web = new Tag("web");
		tagRepository.save(web);
		Tag wiki = new Tag("wiki");
		tagRepository.save(wiki);
		Tag worldwide = new Tag("worldwide");
		tagRepository.save(worldwide);
		
		//Create Websites
		List<Website> websites = new LinkedList<Website>();
		websites.add(new Website("Google","www.google.de",	
				Arrays.asList(new Tag[] { aplhabet, search, find, web })));
		websites.add(new Website("Amazon","www.amazon.de",	
				Arrays.asList(new Tag[] { shopping, books, dvds, sales  })));
		websites.add(new Website("Youtube","www.youtube.de",	
				Arrays.asList(new Tag[] { videos, fun, social, worldwide  })));
		websites.add(new Website("Facebook","www.facebook.de",	
				Arrays.asList(new Tag[] { social, friends, uploadphotos, sharelinks  })));
		websites.add(new Website("Yahoo","www.yahoo.de",	
				Arrays.asList(new Tag[] { portal, search, email, chatrooms  })));
		websites.add(new Website("Wikipedia","www.wikipedia.org",	
				Arrays.asList(new Tag[] { free, encyclopedia, collaboratively, wiki  })));
		websites.add(new Website("Twitter","www.twitter.com",	
				Arrays.asList(new Tag[] { microblogging, instantmessaging, social, tweets  })));
		websites.add(new Website("eBay","www.ebay.de",	
				Arrays.asList(new Tag[] { ecommerce, shopping, onlineauction, paypal })));
		websites.add(new Website("LinkedIn","www.linkedin.com",	
				Arrays.asList(new Tag[] { professionalnetworking, social, job, industryexperts })));
		//Save Websites
		websiteRepository.save(websites);
		logger.info("Websites and Tags are saved into the Database.");
		
	}

}
