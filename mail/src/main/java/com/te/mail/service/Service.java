package com.te.mail.service;

import java.util.List;


import com.te.mail.mailinfo.Mail_Info;
import com.te.mail.usermodel.User_Info;

public interface Service {
	public boolean create(User_Info info);
	public boolean login(String userName,String password);
	public boolean forgotPassword(String email,String password);
	public boolean compose(Mail_Info info);
	public List<Mail_Info> inbox(String userName);
	public List<Mail_Info> sent(String userName);
	public List<Mail_Info> draft(String userName);
	
}
