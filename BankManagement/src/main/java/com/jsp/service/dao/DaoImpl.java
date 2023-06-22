package com.jsp.service.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jsp.service.entity.RecieverDto;
import com.jsp.service.entity.RegisterDto;
import com.jsp.service.entity.SenderDto;

@Component
public class DaoImpl implements Dao {

	@Autowired
	private JdbcTemplate template;
	@Override
	public int insert(RegisterDto dto) {
		try {
	String query="insert into onlinebankmanagement.bankaccountdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 //accountNo, firstname, lastname, mobile, pancard, aadhar, email, address, dob, gender, accounttype, password, amount
	int record=template.update(query,dto.getAccountno(),dto.getFirstname(),dto.getLastname(),dto.getMobile(),dto.getPancard(),dto.getAadhar(),
			dto.getEmail(),dto.getAddress(),dto.getDob(),dto.getGender(),dto.getAccounttype(),dto.getPassword(),dto.getBalance());
		
		return record;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	@Override
	public RegisterDto login(String accountno, String password) {
		String query="select * from onlinebankmanagement.bankaccountdetails where accountno=? and password=?";
		RowMapper<RegisterDto> rm=new RowMapperImpl();
		try {
			RegisterDto dto=template.queryForObject(query,rm,accountno,password);
			return dto;
		}
		catch(Exception e)
		{
		return null;
		}
	}
	@Override
	public RegisterDto viewBalance(HttpSession session) {
		String query="select * from onlinebankmanagement.bankaccountdetails where accountno=?";
		RowMapper<RegisterDto> rm=new RowMapperImpl();
		String accno1 =(String) session.getAttribute("accno");
		try {
			RegisterDto dto=template.queryForObject(query,rm,accno1);
			return dto;
		}
		catch(Exception e)
		{
		return null;
		}
	}
	@Override
	public int transfer(HttpSession session, double amount,RegisterDto dto) {
		
		String query="update onlinebankmanagement.bankaccountdetails set balance=? where accountno=?";
		String accno1 =(String) session.getAttribute("accno");
		int record=template.update(query,dto.getBalance()-amount,accno1);
		return record;
	}
	@Override
	public RegisterDto check(String accountno) {
		String query="select * from onlinebankmanagement.bankaccountdetails where accountno=?";
		RowMapper<RegisterDto> rm=new RowMapperImpl();
		try {
			RegisterDto dto=template.queryForObject(query,rm,accountno);
			return dto;
		}
		catch(Exception e)
		{
		return null;
		}
	}
	@Override
	public int reciever(RegisterDto dto,String accountno,double amount) {
		String query="update onlinebankmanagement.bankaccountdetails set balance=? where accountno=?";
		
		int record=template.update(query,dto.getBalance()+amount,accountno);
		return record;
	}
	@Override
	public void insertTransactions(SenderDto dto) {
		String query="insert into onlinebankmanagement.transactiondetails values(?,?,?,?,?)";
		int record=template.update(query,dto.getTid(),dto.getAccountno(),dto.getDescrption(),dto.getAmount(),dto.getTdate());
	}
	@Override
	public void insertTransactions2(RecieverDto dto) {
		String query="insert into onlinebankmanagement.transactiondetails values(?,?,?,?,?)";
		int record=template.update(query,dto.getTid(),dto.getAccountno(),dto.getDescrption(),dto.getAmount(),dto.getTdate());
		
	}
	@Override
	public List<SenderDto> viewHistory(String sd, String ld, String accno) {
		String query="select * from onlinebankmanagement.transactiondetails where accountno=? and tdate between ? and ?";
	     RowMapper<SenderDto> rm=new SenderDtoRowMapper();
		List<SenderDto> list=template.query(query, rm,accno,sd,ld);
		return list;
	}
}
