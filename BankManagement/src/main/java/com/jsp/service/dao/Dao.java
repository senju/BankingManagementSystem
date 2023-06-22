package com.jsp.service.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jsp.service.entity.RecieverDto;
import com.jsp.service.entity.RegisterDto;
import com.jsp.service.entity.SenderDto;

public interface Dao {
int insert(RegisterDto dto);
RegisterDto login(String accountno,String password);
RegisterDto viewBalance(HttpSession session);
int transfer(HttpSession session,double amount,RegisterDto dto);
RegisterDto check(String accountno);
int reciever(RegisterDto dto,String accountno,double amount);
void insertTransactions(SenderDto dto);
void insertTransactions2(RecieverDto dto);
List<SenderDto> viewHistory(String sd,String ld,String accno);
}
