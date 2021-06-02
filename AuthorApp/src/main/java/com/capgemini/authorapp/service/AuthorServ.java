package com.capgemini.authorapp.service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.capgemini.authorapp.model.Author;



public class AuthorServ {
	Map<String,Author>authorList = new ConcurrentHashMap<String,Author>();
	public void addAuthor(String Name,String Email,char Gender) {
		Author author = new Author(Name,Email,Gender);
		validateAuthor(author);
		checkIfAuthorAlreadyExist(author);
		authorList.put(generateKey(author), author);
	}
	private String generateKey(Author author) {
		// TODO Auto-generated method stub
		return String.format("%s",author.getName());
	}
	private void checkIfAuthorAlreadyExist(Author author) {
		// TODO Auto-generated method stub
		if( authorList.containsKey(generateKey(author))){
			throw new RuntimeException("Author already exists");
		}
		
	}
	private void validateAuthor(Author author) {
		// TODO Auto-generated method stub
		author.validateName();
		author.validateEmail();
		author.validateGender();
		
	}
	public Collection<Author>getAllAuthors(){
		return authorList.values();
	}
}
