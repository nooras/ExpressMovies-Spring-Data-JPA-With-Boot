package com.expressMovies.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int director_Id;
	private String first_Name;
	private String last_Name;
	private String address;
	private String email;
	private long contact_Number;

	public int getDirector_Id() {
		return director_Id;
	}

	public void setDirector_Id(int director_Id) {
		this.director_Id = director_Id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContact_Number() {
		return contact_Number;
	}

	public void setContact_Number(long contact_Number) {
		this.contact_Number = contact_Number;
	}

}
