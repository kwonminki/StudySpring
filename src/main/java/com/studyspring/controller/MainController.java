package com.studyspring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springstudy.service.UserInfoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	@Autowired  //자동연결
	UserInfoService userInfoService;  //new를 안해서 Impl로 작동.
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public ModelAndView main(ModelAndView mv) {
		mv.setViewName("main");
		
		mv.addObject("modelvalue", "Hello Spring");
		
		mv.addObject("value1", "5");
		mv.addObject("value2", "6");
		
		Map<String,Object> info = new HashMap<String, Object>();
		info.put("name", "kwonminki");
		
		mv.addObject("searchname", userInfoService.searchNameService(info));
		
		UserInfoEnrollRequestVO userInfoEnrollRequestVO = new UserInfoEnrollRequestVO();
		Map<String, Object> result = new HashMap<String, Object>();
		
		userInfoEnrollRequestVO.setUserName("kwonminki");
		userInfoEnrollRequestVO.setUserAge(22);
		userInfoEnrollRequestVO.setUserImage("sampleimage1.png");
		
		if(userInfoService.enrollUserInfoService(userInfoEnrollRequestVO)==1){
			result.put("flag", "success")
		}
		
		return mv;
	}
	
}
