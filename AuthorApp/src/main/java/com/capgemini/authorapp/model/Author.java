package com.capgemini.authorapp.model;

public class Author {
private String Name;
private String Email;
private char Gender;
public Author() {
	super();
}
public Author(String name, String email, char gender) {
	super();
	Name = name;
	Email = email;
	Gender = gender;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public char getGender() {
	return Gender;
}
public void setGender(char gender) {
	Gender = gender;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Email == null) ? 0 : Email.hashCode());
	result = prime * result + Gender;
	result = prime * result + ((Name == null) ? 0 : Name.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Author other = (Author) obj;
	if (Email == null) {
		if (other.Email != null)
			return false;
	} else if (!Email.equals(other.Email))
		return false;
	if (Gender != other.Gender)
		return false;
	if (Name == null) {
		if (other.Name != null)
			return false;
	} else if (!Name.equals(other.Name))
		return false;
	return true;
}
@Override
public String toString() {
	return "Author [Name=" + Name + ", Email=" + Email + ", Gender=" + Gender + "]";
}
/**
 * Method for validating  Name
 */
public void validateName() {
	// TODO Auto-generated method stub
	if(this.Name.isBlank()) {
		throw new RuntimeException("Name Cannot Be null or empty");
	}
}
/**
 * Method for validating Email
 */
public void validateEmail() {
	// TODO Auto-generated method stub
	if(this.Email.isBlank()) {
		throw new RuntimeException("Email Cannot be Null or Empty");
	}
	if(this.Email.indexOf('@')<0) {
		throw new RuntimeException("Email Must Contain @");
	}
}
/**
 * Method for validating Gender
 */
public void validateGender() {
	// TODO Auto-generated method stub
	if(!(this.Gender=='m'||this.Gender=='f'|| this.Gender=='u')) {
		throw new RuntimeException("Gender Should be either m or f or u(Unknown)");
	}
}


}

