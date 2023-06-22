package com.jsp.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jsp.service.entity.RegisterDto;

public class RowMapperImpl implements RowMapper<RegisterDto> {

	@Override
	public RegisterDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		RegisterDto dto=new RegisterDto();
		//accountNo, firstname, lastname, mobile, pancard, aadhar, email, address, dob, gender, accounttype, password, balance
		dto.setAccountno(rs.getString(1));
		dto.setFirstname(rs.getString(2));
		dto.setLastname(rs.getString(3));
		dto.setMobile(rs.getString(4));
		dto.setPancard(rs.getString(5));
		dto.setAadhar(rs.getString(6));
		dto.setEmail(rs.getString(7));
		dto.setAddress(rs.getString(8));
		dto.setDob(rs.getString(9));
		dto.setGender(rs.getString(10));
		dto.setAccounttype(rs.getString(11));
		dto.setPassword(rs.getString(12));
		dto.setBalance(rs.getDouble(13));
		return dto;
	}

}
