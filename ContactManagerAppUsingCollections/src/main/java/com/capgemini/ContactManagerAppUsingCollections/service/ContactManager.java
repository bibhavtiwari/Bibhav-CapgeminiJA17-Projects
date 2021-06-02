package com.capgemini.ContactManagerAppUsingCollections.service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.capgemini.ContactManagerAppUsingCollections.model.Contact;

public class ContactManager {
	// Concurrent HAsh Map is the collection which allows us to retrieve and modify the data while iteration through the objects inside the map
 
	Map<String,Contact>contactList = new ConcurrentHashMap<String,Contact>();
 /*
  * addContact Method to add contacts in to contactListObject
  * with @param fName gets first Name of contact.
  * @param lName gets Last Name of contact.
  * @param phoNe gets the phoneNo of contact.
  * */
	public void addContact(String fName,String lName,String phoneNo) {
		Contact contact = new Contact(fName,lName,phoneNo);
		validateContact(contact);
		checkIfContactAlreadyExist(contact);
		contactList.put(generateKey(contact), contact);
	}
	/**
	 * generateKey generates the Key to store a value in HashMap
	 * 
	 * @param contact
	 * @return String
	 */
public String generateKey(Contact contact) {
		// TODO Auto-generated method stub
		return String.format("%s-%s",contact.getfName(),contact.getlName());
	}
/**
 * check if Contact already added in the list
 * 
 * @param contact
 */
public void checkIfContactAlreadyExist(Contact contact) {
		// TODO Auto-generated method stub
		if( contactList.containsKey(generateKey(contact))){
			throw new RuntimeException("Contact already exists");
		}
	}
/**
 * validateContact method ,validate the contact details using some condition  
 * @param contact
 */
public void validateContact(Contact contact) {
	// TODO Auto-generated method stub
	contact.validatefName();
	contact.validatelName();
	contact.validatephoneNo();
}
/**
 * all values of contact List
 * @return contactList
 */
public Collection<Contact>getAllContacts(){
	return contactList.values();
}
	
	
}