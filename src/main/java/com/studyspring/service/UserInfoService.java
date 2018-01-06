package com.studyspring.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studyspring.vo.UserInfoDeleteRequestVO;
//import com.studyspring.vo.UserInfoDeleteRequestVO;
import com.studyspring.vo.UserInfoEnrollRequestVO;
import com.studyspring.vo.UserInfoVO;

public interface UserInfoService {
	public String searchNameService(Map<String, Object> info);
	public int enrollUserInfoService(UserInfoEnrollRequestVO userInfoEnrollRequestVO);
	public List<UserInfoVO> getUserInfoListService();
	public List <Map<String, Object>> searchUserInfoDBService(Map<String, Object> params);
	public int deleteUserInfoService(UserInfoDeleteRequestVO userInfoDeleteRequestVO);
	public int updateUserInfoDBService(Map<String, Object>prams);
	public int deleteUserInfoDBService(Map<String, Object>prams);
}