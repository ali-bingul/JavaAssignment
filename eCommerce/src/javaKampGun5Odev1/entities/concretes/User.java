package javaKampGun5Odev1.entities.concretes;

import javaKampGun5Odev1.entities.abstracts.Entity;

public class User implements Entity {
	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private boolean isVerify;
	
	public User() { }
	
	public User(int id, String name, String surname, String email, String password, boolean isVerify) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.isVerify = isVerify;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isVerify() {
		return isVerify;
	}
	public void setVerify(boolean verify) {
		this.isVerify = verify;
	}	
}
