package com.te.mail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.te.mail.dao.DaoImpl;
import com.te.mail.mailinfo.Mail_Info;
import com.te.mail.usermodel.User_Info;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	@Autowired
	DaoImpl daoImpl;

	@Override
	public boolean create(User_Info info) {
		if (daoImpl.create(info))
			return true;
		return false;
	}

	@Override
	public boolean login(String userName, String password) {
		if (daoImpl.login(userName, password)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean forgotPassword(String email, String password) {
		if (email != null && password != null) {
			if (daoImpl.forgotPassword(email, password)) {
				return true;
			}
		}
		return false;
	}

	public boolean findById(String id) {
		if (daoImpl.findById(id)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean compose(Mail_Info info) {
		if (findById(info.getFrom_Id())) {
			if (findById(info.getTo_Id())) {
				if (daoImpl.compose(info)) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public List<Mail_Info> inbox(String userName) {
		List<Mail_Info> inbox = daoImpl.inbox(userName);
		return inbox;
		
	}

	@Override
	public List<Mail_Info> sent(String userName) {
		List<Mail_Info> sent = daoImpl.sent(userName);
		return sent;
		
	}

	@Override
	public List<Mail_Info> draft(String userName) {
		 List<Mail_Info> draft = daoImpl.draft(userName);
		 return draft;
	}


}
