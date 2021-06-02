package com.capgemini.ContactManagerAppUsingCollections.model;

public class Contact {
	/**
	 * fName first name of contact
	 */
private String fName;
/**
 * lName last name of contact
 */
private String lName;
/**
 * phNo phone number of contact
 */
private String phNo;
/**
 * default constructor
 */
public Contact() {
	super();
}
/**
 * Parameterized constructors
 * @param fName
 * @param lName
 * @param phNo
 */
public Contact(String fName, String lName, String phNo) {
	super();
	this.fName = fName;
	this.lName = lName;
	this.phNo = phNo;
}
/**
 * get first name
 * @return f name
 */
public String getfName() {
	return fName;
}
/**
 * accepts the fName
 * @param fName
 */
public void setfName(String fName) {
	this.fName = fName;
}
/**
 * get last Name
 * @returnlName
 */
public String getlName() {
	return lName;
}
/**
 * accepts last name
 * @param lName
 */
public void setlName(String lName) {
	this.lName = lName;
}
/**
 * get phone number
 * @return phNo
 */
public String getPhNo() {
	return phNo;
}
/**
 * accepts PNo.
 * @param phNo
 */
public void setPhNo(String phNo) {
	this.phNo = phNo;
}
/**
 * Overriding  hashCode
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((fName == null) ? 0 : fName.hashCode());
	result = prime * result + ((lName == null) ? 0 : lName.hashCode());
	result = prime * result + ((phNo == null) ? 0 : phNo.hashCode());
	return result;
}
/**
 * Overriding equals method of object class
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Contact other = (Contact) obj;
	if (fName == null) {
		if (other.fName != null)
			return false;
	} else if (!fName.equals(other.fName))
		return false;
	if (lName == null) {
		if (other.lName != null)
			return false;
	} else if (!lName.equals(other.lName))
		return false;
	if (phNo == null) {
		if (other.phNo != null)
			return false;
	} else if (!phNo.equals(other.phNo))
		return false;
	return true;
}
/**
 * Overriding toString
 */
@Override
public String toString() {
	return "Contact [fName=" + fName + ", lName=" + lName + ", phNo=" + phNo + "]";
}
/**
 * Method for validating first Name
 */
public void validatefName() {
	// TODO Auto-generated method stub
	if(this.fName.isBlank()) {
		throw new RuntimeException("First Name Cannot Be null or empty");
	}
}
/**
 * Method for validating last name
 */
public void validatelName() {
	// TODO Auto-generated method stub
	if(this.lName.isBlank()) {
		throw new RuntimeException("Last name cannot be null");
	}
}
/**
 * Method for validating Phone Number
 */
public void validatephoneNo() {
	// TODO Auto-generated method stub
	if(this.phNo.isBlank()) {
		throw new RuntimeException("Cannot to null phnone");
	}
	if(!(this.phNo.length()!=10)) {
		throw new RuntimeException("Phone number should be 10 digit long");
	}
	if(!this.phNo.matches("\\d+")) {
		throw new RuntimeException("Only digits are allowed");
		
	}
	if(!this.phNo.startsWith("0")) {
		throw new RuntimeException("Phone number should Starts with 0");
	}
}

}
