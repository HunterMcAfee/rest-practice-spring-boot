package com.bootcamp.restpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class RestPracticeApplication {
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	BookmarkRepository bookmarkRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestPracticeApplication.class, args);
	}

	@PostConstruct
	public void runInit() throws Exception {
		System.out.println("RUNNING....");
		Arrays.asList(
				"jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
				.forEach(
						a -> {
							Account account = accountRepository.save(new Account(a,
									"password"));
							bookmarkRepository.save(new Bookmark(account,
									"http://bookmark.com/1/" + a, "A description"));
							bookmarkRepository.save(new Bookmark(account,
									"http://bookmark.com/2/" + a, "A description"));
						});
	}

}
