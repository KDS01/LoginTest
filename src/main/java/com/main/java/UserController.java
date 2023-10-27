package com.main.java;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.java.user.domain.User;
import com.main.java.user.serivce.UserService;


@Controller
public class UserController {
	@Autowired
	public UserService userService;
	@RequestMapping(value="/regist",method=RequestMethod.GET)
	public String regist() {
		return "user/regist";
	}
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String registPost(@RequestParam Map<String,String> map) {
		System.out.println(map.get("user-id"));
		userService.add(new User(
				map.get("user-name"),
				map.get("user-id"),
				map.get("user-pw")
				));
		return "redirect:/regist";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String logInPost(@RequestParam Map<String,String> map,HttpSession session) {
		User user=new User();
		user.setUserId(map.get("user-id"));
		user.setPassword(map.get("user-pw"));
		System.out.println(map.get("user-id"));
		user =userService.login(user);
		System.out.println(user.getPassword());
		//로그인이 됬으면 세션과 쿠키에 넣어준다. 위에 리퀘스트파람의 map 옆에 Httpsession을 넣어준다
		if(user!=null)session.setAttribute("userName", user.getName());
		
		return "redirect:/";
	}
	
			
	}
	


