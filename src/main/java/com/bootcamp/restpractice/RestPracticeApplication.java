package com.bootcamp.restpractice;

import com.bootcamp.restpractice.Model.Account;
import com.bootcamp.restpractice.Model.Bookmark;
import com.bootcamp.restpractice.Repository.AccountRepository;
import com.bootcamp.restpractice.Repository.BookmarkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class RestPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestPracticeApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AccountRepository accountRepository,
						   BookmarkRepository bookmarkRepository) {
		System.out.println("Command Line Runner is running...");
		return (evt) -> Arrays.asList(
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
