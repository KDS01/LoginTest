package com.main.java;

import java.text.DateFormat;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller // 우리가 사용하게 될 어노테이션
//우리가 서블릿을 쓸 때, view랑 엮이는 놈
//views 폴더, jsp와 자동으로 엮인다
//HTML,CSS,JAVASCRIPT 등이 아닌, JSON을 사용하게 된다면 @RestController 사용
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//로그남기는용
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)//.POST로 하면, post로 들어온 애를 처리하는 메서드만 모을수도 있음
	//@RequestMapping ==> 요청에 대한 처리를 메서드 단위로 처리한다.(기존에 서블릿에서는 하나의 서블릿 단위로 처리했으나, 리퀘스트맵핑을 통해서 메서드별로 다른 처리를 할 수 있게 함.)
	
	public String home(Locale locale, Model model) {//model=> request와 session(데이터를 주고받는 통합적인 내용 전체)000000000000000000
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
