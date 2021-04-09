package com.lime.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lime.user.service.UserService;
import com.lime.user.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	/*
	 * 
	 */
	@RequestMapping(value="/user/userInsert.do")
	public String userInsert() {
		
		return "/user/userInsert";
	}
	/*
	 * 
	 */
	@RequestMapping(value="/user/userInsertCheck.do",method=RequestMethod.GET)
 	@ResponseBody
	public int userInsertCheck(HttpServletRequest req, @RequestParam("user_id")String user_id)throws Exception{
		
		int cnt =0;
		cnt = userService.userInsertCheck(user_id);
		System.out.println("cnt : "+cnt);
		
		return cnt;
	}
	
	@RequestMapping(value="/user/userInsertPro.do",method=RequestMethod.POST)
	public String userInsert(HttpServletRequest req, UserVO userVO)throws Exception{
		
		
		int result = userService.userInsert(userVO);
		
		System.out.println("result"+result);
	
		return "redirect:/login/login.do"; 
	}
	
}
