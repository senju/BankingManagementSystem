package com.jsp.service.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.service.dao.Dao;
import com.jsp.service.entity.RecieverDto;
import com.jsp.service.entity.RegisterDto;
import com.jsp.service.entity.SenderDto;
@Controller
public class ApplicationController {
@RequestMapping("/welcome")
	public ModelAndView welcomePage()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Welcome");
		return mv;
	}
@Autowired
private Dao dao;
@RequestMapping(path="/register",method = RequestMethod.POST)
public ModelAndView insert(@ModelAttribute RegisterDto dto)
{
	ModelAndView mv=new ModelAndView();
	
		Random r=new Random();
		int accno=r.nextInt();
		if(accno<0)
		{
			accno*=-1;
		}
		if(accno<1000000000)
		{
			accno+=1000000000;
		}
		String accountno="BSI"+accno;
		dto.setAccountno(accountno);
			int record=dao.insert(dto);
			if(record>0)
			{
			mv.addObject("msg", dto.getAccountno());
			mv.setViewName("Display");
			}
			if(record==0)
			{
				mv.addObject("acno", "invalid Details");
				mv.setViewName("Registration");	
			}

	return mv;
}
@Autowired
private HttpServletRequest req;
@Autowired
private HttpSession session;
RegisterDto mdto;
@RequestMapping(path="/login",method = RequestMethod.POST)
public ModelAndView login(@RequestParam("accno")String accno,@RequestParam("pwd") String pwd)
{
	 session=req.getSession();
	ModelAndView mv=new ModelAndView();
	RegisterDto dto=dao.login(accno, pwd);
	 mdto=dao.login(accno, pwd);
	if(dto!=null)
	{
		session.setAttribute("accno", accno);
		mv.addObject("msg", dto.getFirstname());
		mv.setViewName("Home");
		
		
	}
	else
	{
		mv.setViewName("Login");
		mv.addObject("msg1", "Invalid Details");
	}
	
	return mv;
}
@RequestMapping(path="/home",method = RequestMethod.POST)
public ModelAndView homePage()
{
	ModelAndView mv=new ModelAndView();
	RegisterDto dto1 = dao.viewBalance(session);
	if(dto1!=null)
	{
		mv.addObject("msg", dto1.getFirstname());
		mv.addObject("msg2", dto1);
		mv.setViewName("ViewBalance");
	}
	else
	{
		mv.addObject("msg2","null");
		mv.setViewName("ViewBalance");
	}
	return mv;
}
@RequestMapping(path="/transfer",method = RequestMethod.POST)
public ModelAndView transfer(@RequestParam("raccno")String raccno,@RequestParam("amt") double amount )
{
	ModelAndView mv=new ModelAndView();
	RegisterDto check = dao.check(raccno);
	SenderDto sdto=new SenderDto();
	RecieverDto rdto=new RecieverDto();
	if(check!=null)
	{
	if(mdto.getBalance()>amount)
	{
		int record = dao.transfer(session, amount, mdto);
		if(record>0)
		{
			Random r=new Random();
			int tid=r.nextInt();
			if(tid<0)
			{
				tid*=-1;
			}
			if(tid<1000000000)
			{
				tid+=1000000000;
			}
			String stid="TID"+tid;
			sdto.setTid(stid);
			sdto.setAccountno(mdto.getAccountno());
			sdto.setDescrption("");
			String setamt="-"+amount;
			sdto.setAmount(setamt);
		    Date date=new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd");
			String transactionDate =dateformat.format(date);
			sdto.setTdate(transactionDate);
			dao.insertTransactions(sdto);//method to insert senderdto
			int reciever = dao.reciever(check, raccno, amount);
			if(reciever!=0)
			{
				rdto.setTid(stid);
				rdto.setAccountno(raccno);
				rdto.setDescrption("");
				String reamt="+"+amount;
				rdto.setAmount(reamt);
				rdto.setTdate(transactionDate);
				dao.insertTransactions2(rdto);
			mv.addObject("status", "paymentSuccess");
			mv.setViewName("MoneyTransfer");
			}
		}
		else
		{
			mv.addObject("status", "paymentFailed");
			mv.setViewName("MoneyTransfer");
		}
	}
	else
	{
		mv.addObject("status", "InsuffientBalance");
		mv.setViewName("MoneyTransfer");
	}
	}
	else
	{
		mv.addObject("status", "InvalidAccountno");
		mv.setViewName("MoneyTransfer");
	}
	return mv;
}
@RequestMapping(path="/history",method = RequestMethod.POST)
public ModelAndView history(@RequestParam("sd")String sd,@RequestParam("ed") String ed)
{
	ModelAndView mv=new ModelAndView();
	String accno1 =(String) session.getAttribute("accno");
	List<SenderDto> list = dao.viewHistory(sd, ed, accno1);
	if(list.size()>0)
	{
		mv.addObject("record", list);
		mv.setViewName("History");
	}
	else
	{
		mv.addObject("record", "no records found");
		mv.setViewName("ViewStatement");
	}
	return mv;
}
@Autowired
HttpServletResponse resp;
@RequestMapping(path="/LogoutController",method = RequestMethod.GET)
public ModelAndView logout()
{
	ModelAndView mv=new ModelAndView();
	session=req.getSession(false);
	
	if(session!=null)
	{
		resp.setHeader("cache-control", "no-cache,no-store,must-revalidate");
		resp.setHeader("pragma", "no-cache");
		resp.setDateHeader("expires", 0);
		/* To destory session object */
		session.invalidate();
		session=null;
		mv.setViewName("Login");
	}
	else
	{
		mv.setViewName("Login");
		
	}
	return mv;
}
}
