package com.jsp.service.entity;

public class SenderDto {
	//tid, accountno, descrption, balance, tdate
private String tid;
private String accountno;
private String descrption;
private String tdate;
private String amount;
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
public String getTid() {
	return tid;
}
public void setTid(String tid) {
	this.tid = tid;
}
public String getAccountno() {
	return accountno;
}
public void setAccountno(String accountno) {
	this.accountno = accountno;
}
public String getDescrption() {
	return descrption;
}
public void setDescrption(String descrption) {
	this.descrption = descrption;
}
public String getTdate() {
	return tdate;
}
public void setTdate(String tdate) {
	this.tdate = tdate;
}

}
