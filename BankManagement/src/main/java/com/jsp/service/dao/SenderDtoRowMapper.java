package com.jsp.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jsp.service.entity.SenderDto;

public class SenderDtoRowMapper implements RowMapper<SenderDto>{

	@Override
	public SenderDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		SenderDto dto=new SenderDto();
		//tid, accountno, descrption, balance, tdate
		dto.setTid(rs.getString(1));
		dto.setAccountno(rs.getString(2));
		dto.setDescrption(rs.getString(3));
		dto.setAmount(rs.getString(4));
		dto.setTdate(rs.getString(5));
		return dto;
	}

}
