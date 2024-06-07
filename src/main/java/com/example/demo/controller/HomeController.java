package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.healper.Massage;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;
	
// home page 
	@GetMapping("/")
	public String home(Model model)
	{
		model.addAttribute("title", "EduWeb - ");
		return "home";
	}
	
// register 
	@RequestMapping("/register")
	public String requestMethodName(Model model) {
		model.addAttribute("title","Register");
		model.addAttribute("user",new User());
		return "signup";
	}
	
  // /do_register
	@PostMapping("/do_register")
	public String doRegister(@ModelAttribute("user") User user,	@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model modle,
 HttpSession session)
	{
		try {

			user.setEnabled(true);
			user.setRole("ROLE_USER");
			System.out.println("User" + user);
			String n=user.getPassword();
			BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
			user.setPassword(passwordEncoder.encode(n));
			modle.addAttribute("user",new User());
			session.setAttribute("massage", new Massage("Successfully Registered !!", "alert-success"));
            // save
			User result=userRepository.save(user);
			return "signup";
			
		} catch (Exception e) {
		modle.addAttribute("user",user);
		e.printStackTrace();
		session.setAttribute("massage", new Massage("Something Went wrong !!" + e.getMessage(), "alert-danger"));

		return "signup";
		
		}
	}
	
	// about page 
	@RequestMapping("/about")
	public String aboutpage(Model model)
	{
		model.addAttribute("title","about page ");
		return "about";
		
	}
	
	
	// Login page 
	@RequestMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("title","Login ");
		return "login";
	}
	public String requestMethodName(@RequestParam String param) {
		return new String();
	}
	
	
}
