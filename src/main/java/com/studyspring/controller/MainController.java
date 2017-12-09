package com.studyspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.studyspring.service.UserInfoService;
import com.studyspring.util.MailUtil;
import com.studyspring.vo.UserInfoVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	MailUtil mailUtil;
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public ModelAndView main(ModelAndView mv) {
		mv.setViewName("main");
		
		//Study 1//
		mv.addObject("modelvalue", "Hello Spring");
		
		//Study 2//
		mv.addObject("value1", "5");
		mv.addObject("value2", "6");
		
		//Study 3//
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("name", "seochangwook");
		
		mv.addObject("searchname", userInfoService.searchNameService(info));
		
		
		//study 5//
		boolean isCheck = true;
		if(isCheck == true){
		
			Map<String, Object> retVal = new HashMap<String, Object>();
		
			retVal.put("type", 2);
		
			mv.addObject("retType", retVal);
		}
		mv.addObject("value", isCheck);
		
		//study 6//배고파
		List listuser = userInfoService.getUserInfoListService();
		System.out.println("user count : "+listuser.size());
		
		mv.addObject("listuser", listuser);
		return mv;
	}
		//study 8//
		@RequestMapping(value = "/samplepage.do", method = RequestMethod.POST)
		public ModelAndView main(ModelAndView mv, HttpServletRequest request) {
			mv.setViewName("samplepage");
			
			mv.addObject("name", request.getParameter("inputname"));
			mv.addObject("age", request.getParameter("inputage"));
		
		return mv;
	}
	
}
