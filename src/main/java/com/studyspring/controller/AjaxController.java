package com.studyspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.studyspring.service.UserInfoService;
import com.studyspring.util.MailUtil;
import com.studyspring.vo.UserInfoVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AjaxController {
	@Autowired
	UserInfoService userInfoService;
	
	@RequestMapping(value = "/searchuserdb", method= RequestMethod.POST, produces= {"application/json"})
	public @ResponseBody Map<String, Object> searchUserDB(@RequestBody Map<String, Object> params){
		Map<String, Object> retVal = new HashMap<String, Object>();
		
		System.out.println("ajax call: "+params.get("searchName")+","+params.get("searchAge")+","+params.get("searchNo"));
		
		retVal.put("val", userInfoService.searchUserInfoDBService(params));
		
		return retVal;
	}
	@RequestMapping(value = "/updateuserdb", method= RequestMethod.POST, produces= {"application/json"})
	public @ResponseBody Map<String, Object> updateUserDB(@RequestBody Map<String, Object> params){
		Map<String, Object> retVal = new HashMap<String, Object>();
		
		System.out.println("ajax call: "+params.get("updateName")+","+params.get("updateAge"));
		
		retVal.put("resultCode", userInfoService.updateUserInfoDBService(params));
		
		return retVal;
	}
	@RequestMapping(value = "/deleteuserdb", method= RequestMethod.POST, produces= {"application/json"})
	public @ResponseBody Map<String, Object> deleteUserDB(@RequestBody Map<String, Object> params){
		Map<String, Object> retVal = new HashMap<String, Object>();
		
		System.out.println("ajax call: "+params.get("deleteName"));
		
		retVal.put("resultCode", userInfoService.deleteUserInfoDBService(params));
		
		return retVal;
	}
}
