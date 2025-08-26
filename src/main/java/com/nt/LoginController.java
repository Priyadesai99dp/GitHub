package com.nt;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}


	@RequestMapping(value = "/login-form")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@RequestParam String uname, @RequestParam String pwd,Model model,HttpSession session) {
		if(uname.equals(pwd)) {
			session.setAttribute("user", uname);
			return "home";
		}else {
			model.addAttribute("errorMsg","Invalid Username or Password");
			return "login";
		}
		
	}
}
