package ino.web.freeBoard.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ino.web.freeBoard.dto.RegisterDto;
import ino.web.freeBoard.service.RegisterService;

@Controller
public class LoginController {

	@Autowired
	private RegisterService registerService;
	
//	@RequestMapping(value="/loginchk.ino", method=RequestMethod.POST, produces = "application/json")
//	@ResponseBody
//	public Map<String, String> login(HttpSession session, HttpServletRequest request, HttpServletResponse resp, String id, String pwd) 
//			throws SQLException {
//		
//		System.out.println("controller!");
//		Map<String, String> result = new HashMap<String, String>();
//		
//		RegisterDto registerDto = new RegisterDto();
//		System.out.println(id +", " + pwd);
//		
//		int cnt = registerService.loginCntChk(id, pwd);
//		System.out.println(cnt);
//		
//		if(cnt > 0) {
//			registerDto = registerService.loginChk(id, pwd);
//		} else {
//			System.out.println("else");
////			resp.getWriter().write("{\"result\":\"fail\"}");
//			result.put("result", "fail");
//			return result;
//		}
//	
//		if(registerDto != null) {
//			session.setAttribute("user", registerDto);
////			try {
////				resp.getWriter().write("{\"result\":\"success\"}");
////			} catch (IOException e) {
////				e.printStackTrace();
////			}
//			result.put("result", "success");
//			return result;
//		}
//		else {
////			try{
////				resp.getWriter().write("{\"result\":\"fail\"}");
////			} catch (IOException e) {
////                e.printStackTrace();
////          }
//			result.put("result", "fail");
//
//		}
//		
//		return result;
//	}
	
	@RequestMapping(value="/loginchk.ino", method=RequestMethod.POST)
	public ModelAndView loginChk(HttpSession session, HttpServletRequest request, HttpServletResponse resp, String id, String pwd) 
			throws SQLException {
		
		System.out.println("controller!");

		RegisterDto registerDto = new RegisterDto();
		System.out.println(id +", " + pwd);
		
		int cnt = registerService.loginCntChk(id, pwd);
		System.out.println(cnt);
		
		if(cnt > 0) {
			registerDto = registerService.loginChk(id, pwd);
		} else {
			System.out.println("else");
//			resp.getWriter().write("{\"result\":\"fail\"}");
			return new ModelAndView("freeBoardLogin", "flag", 999);
		}
	
		if(registerDto != null) {
			request.getSession().setAttribute("user", registerDto);
//			session.setAttribute("user", registerDto);
//			try {
//				resp.getWriter().write("{\"result\":\"success\"}");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			return new ModelAndView("freeBoardLogin", "flag", 100);
		}
		else {
//			try{
//				resp.getWriter().write("{\"result\":\"fail\"}");
//			} catch (IOException e) {
//                e.printStackTrace();
//          }
			return new ModelAndView("freeBoardLogin", "flag", 999);

		}
	}
}
