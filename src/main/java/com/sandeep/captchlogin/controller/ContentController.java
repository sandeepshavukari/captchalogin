package com.sandeep.captchlogin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController {

	@GetMapping("/req/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login?logout";
	}



	@GetMapping("/req/signup")
	public String signup(){
		return "signup";
	}
	@GetMapping("/index")
	public String home(){
		return "index";
	}

	@GetMapping("/req/setSession")
	public String setSession(HttpSession session) {
		session.setAttribute("username", "Sandeep");
		return "redirect:/index";
	}
	@GetMapping("/req/forgot-password")
	public String forgotPasswordPage() {
		return "forgotpassword"; // this should be your HTML/JSF page
	}

}