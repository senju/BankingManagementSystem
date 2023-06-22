package com.jsp.service.entity;

public class RegisterDto {

	//accountNo, firstname, lastname, mobile, pancard, aadhar, email, address, dob, gender, accounttype, password, amount
	private String accountno;
	private String firstname;
	private String lastname;
	private String mobile;
	private String pancard;
	private String aadhar;
	private String email;
	private String address;
	private String dob;
	private String gender;
	private String accounttype;
	private String password;
	private double balance;
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "RegisterDto [accountno=" + accountno + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", mobile=" + mobile + ", pancard=" + pancard + ", aadhar=" + aadhar + ", email=" + email
				+ ", address=" + address + ", dob=" + dob + ", gender=" + gender + ", accounttype=" + accounttype
				+ ", password=" + password + ", balance=" + balance + "]";
	}	
}
