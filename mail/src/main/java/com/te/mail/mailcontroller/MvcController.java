package com.te.mail.mailcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.te.mail.mailinfo.Mail_Info;
import com.te.mail.service.ServiceImpl;
import com.te.mail.usermodel.User_Info;

@Controller("/")
public class MvcController {
	@Autowired
	ServiceImpl serviceImpl;
	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@PostMapping("/login")
	public String login(String userName, String password, ModelMap map, HttpServletRequest request) {
		if (serviceImpl.login(userName, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			List<Mail_Info> inbox = serviceImpl.inbox(userName);
			map.addAttribute("userName", userName);
			map.addAttribute("inbox", inbox);
			return "login";
		}
		return "loginFail";
	}

	@GetMapping("/forgotPassword")
	public String forgot() {
		return "forgotPassword";
	}

	@GetMapping("/createAccount")
	public String create() {
		return "createAccount";
	}

	@PostMapping("/createAccount")
	public String createAccount(User_Info info, ModelMap map) {
		if (serviceImpl.create(info)) {
			map.addAttribute("userName", info.getUserName());
			return "loginsuccess";
		}
		return "failure";
	}

	@PostMapping("/forgotPassword")
	public String forgotPassword(String email, String password) {
		if (serviceImpl.forgotPassword(email, password)) {
			return "passwordSuccess";
		}
		return "loginFail";
	}

	@GetMapping("/compose")
	public String compose() {
		return "composeEmail";
	}

	@PostMapping("/compose")
	public String composeMail(Mail_Info info, HttpServletRequest request) {
		String parameter = request.getParameter("send");
		HttpSession session = request.getSession();
		String attribute = (String) session.getAttribute("userName");
		if (info.getFrom_Id().equals(attribute)) {
			if (serviceImpl.compose(info)) {
				return "composeEmail";
			}
			return "notSent";
		}
		return "incorrectMail";
	}

	@GetMapping("/sent")
	public String sent(HttpServletRequest request, ModelMap map) {
		HttpSession session = request.getSession(false);
		String attribute = (String) session.getAttribute("userName");
		List<Mail_Info> sent = serviceImpl.sent(attribute);
		map.addAttribute("sent", sent);
		return "sentData";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "home";
	}
	@GetMapping("/draft")
	public String draft(HttpServletRequest request, ModelMap map) {
		HttpSession session = request.getSession(false);
		String attribute = (String) session.getAttribute("userName");
		List<Mail_Info> draft = serviceImpl.draft(attribute);
		map.addAttribute("draft", draft);
		return "draft";
	}
}
