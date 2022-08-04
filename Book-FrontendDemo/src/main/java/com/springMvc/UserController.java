	package com.springMvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HDAO.dao.UserDAO;
import com.HDAO.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserDAO usersDAO;

	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	@RequestMapping("/register")
	public String register(ModelMap map) {
		map.addAttribute("user",new User());
		return "register";
	}
	
	@RequestMapping("/add")
	public String add(@Valid @ModelAttribute("user") User u,BindingResult result)
	{
		if(!result.hasErrors())
		{
		u.setEnabled(true);
		u.setAuthority("user");
		u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
		usersDAO.addUser(u);
		return "redirect:/user/login";
		}
		else
		{
			return "register";
		}
		
	}
}
