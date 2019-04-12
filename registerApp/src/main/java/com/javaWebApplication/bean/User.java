package com.javaWebApplication.bean;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
	private int id;
	private int i_id;
	private String fname;
	private String lname;
	private String dob;
	private String email;
	private String password;
	private String gender;
	private String lang;
	private String roll;
	private transient InputStream img;
	private String base64Image;
	private static final long serialVersionUID = 1L;
	/* private BufferedImage image; */
	
	public int getIId() {
		return i_id;	
	}
	public void setIId(int i_id) {
		this.i_id = i_id;
	}
	public InputStream getImg() {
		return img;
	}
	public void setImg(InputStream img) {
		this.img = img;
	}
	public String getBase64Image() {
	    return base64Image;
	}
	public void setBase64Image(String base64Image) {
	    this.base64Image = base64Image;
	 }
	private List<Address> address;
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public int getId() {
		return id;	
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;	
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDob()
	{
		return dob;
	}
	public void setDob(String dob) {
		this.dob=dob;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
    @Override
	public String toString() {
		return "User [ fname=" + fname + ", lname=" + lname + ", dob=" + dob + ", email=" + email
				+ ", password=" + password + ", gender=" + gender + ", lang=" + lang + ", roll=" + roll
				+ ",  getId()=" + getId() + ", getFname()="
				+ getFname() + ", getLname()=" + getLname() + ", getDob()=" + getDob() + ", getEmail()=" + getEmail()
				+ ", getPassword()=" + getPassword() + ", getGender()=" + getGender() + ", getLang()=" + getLang()
				+ ", getRoll()=" + getRoll() + ",getImg()=" + getImg() + ",getBasr64Image()=" + getBase64Image() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	/*
	 * public BufferedImage getImage() { return image; }
	 * 
	 * public void setImage(BufferedImage image) { // TODO Auto-generated method
	 * stub this.image = image;
	 * 
	 * }
	 */
}
