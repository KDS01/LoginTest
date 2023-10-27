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
@Controller // �츮�� ����ϰ� �� ������̼�
//�츮�� ������ �� ��, view�� ���̴� ��
//views ����, jsp�� �ڵ����� ���δ�
//HTML,CSS,JAVASCRIPT ���� �ƴ�, JSON�� ����ϰ� �ȴٸ� @RestController ���
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//�α׳���¿�
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)//.POST�� �ϸ�, post�� ���� �ָ� ó���ϴ� �޼��常 �������� ����
	//@RequestMapping ==> ��û�� ���� ó���� �޼��� ������ ó���Ѵ�.(������ ���������� �ϳ��� ���� ������ ó��������, ������Ʈ������ ���ؼ� �޼��庰�� �ٸ� ó���� �� �� �ְ� ��.)
	
	public String home(Locale locale, Model model) {//model=> request�� session(�����͸� �ְ�޴� �������� ���� ��ü)000000000000000000
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
