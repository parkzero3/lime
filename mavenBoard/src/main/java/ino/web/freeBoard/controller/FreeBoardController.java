package ino.web.freeBoard.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ino.web.freeBoard.dto.FreeBoardDto;
import ino.web.freeBoard.dto.RegisterDto;
import ino.web.freeBoard.service.FreeBoardService;
import ino.web.freeBoard.service.RegisterService;

@Controller
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/main.ino")
	public ModelAndView main(HttpServletRequest request, @RequestParam(required=false) String searchKey,
			@RequestParam(required=false)String searchWord, @RequestParam(value="now", required=false) String now, HttpSession session,
			@RequestParam(required=false)String dataCnt){
		
		RegisterDto user = (RegisterDto) request.getSession().getAttribute("user");
//		RegisterDto user = (RegisterDto) session.getAttribute("user");
		
		ModelAndView mav = new ModelAndView();
		
		// --------- paging start --------- 
			int nowPage = 1;
			int startNum = 1;
			int endNum = 5;
			if(now != null && now.length() > 0) { 
				 nowPage = Integer.parseInt(now); 
			}
			 
			// page 당 row 개수 int startNum = cntByPage*(nowPage-1)+1;
			int cntByPage = 5;
			if(nowPage > 1) {
				startNum = cntByPage * (nowPage - 1) + 1;
				endNum = startNum + 4;
			}
			
			int cntRecords = freeBoardService.cntAllRecords(searchKey, searchWord);
			
			System.out.println(cntRecords);
			int lastPage = 1; 
			if(cntRecords > 0) {
				if(cntRecords % cntByPage == 0) {
					 lastPage = cntRecords / cntByPage;
				} else { 
					lastPage = cntRecords / cntByPage + 1; 
				} 
			}
		// --------- paging end. --------- 
			
//		System.out.println("searchKey: " + searchKey);
//		System.out.println("searchWord: " + searchWord);
		
		List list = freeBoardService.freeBoardList(searchKey, searchWord, startNum, endNum);
//		List list = freeBoardService.freeBoardList2();
		
		mav.setViewName("boardMain");
		mav.addObject("freeBoardList",list);
		mav.addObject("now", nowPage);
		mav.addObject("lastPage", lastPage);
		mav.addObject("cnt", cntRecords);
		mav.addObject("dataCnt", dataCnt);
		mav.addObject("cntByPage", cntByPage);
		
		
	return mav;
	}
	
	@RequestMapping(value="/freeBoardListAjax.ino",method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ModelMap freeBoardListAjax(HttpServletRequest request, @RequestParam(required=false) String searchKey,
			@RequestParam(required=false)String searchWord, @RequestParam(value="now", required=false) String now, HttpSession session,
			@RequestParam(required=false)String dataCnt, ModelMap model)throws Exception{
				
		// --------- paging start --------- 
		int nowPage = 1;
		int startNum = 1;
		int endNum = 5;
		if(now != null && now.length() > 0) { 
			 nowPage = Integer.parseInt(now); 
		}
		 
		// page 당 row 개수 int startNum = cntByPage*(nowPage-1)+1;
		int cntByPage = 5;
		if(nowPage > 1) {
			startNum = cntByPage * (nowPage - 1) + 1;
			endNum = startNum + 4;
		}
		
		int cntRecords = freeBoardService.cntAllRecordsAjax(searchKey, searchWord);
		System.out.println(cntRecords);
		int lastPage = 1; 
		if(cntRecords > 0) {
			if(cntRecords % cntByPage == 0) {
				 lastPage = cntRecords / cntByPage;
			} else { 
				lastPage = cntRecords / cntByPage + 1; 
			} 
		}
	// --------- paging end. --------- 
		List list = freeBoardService.freeBoardListAjax(searchKey, searchWord, startNum, endNum);
		
		model.put("freeBoardList",list);
		model.put("now", nowPage);
		model.put("lastPage", lastPage);
		model.put("cnt", cntRecords);
		model.put("dataCnt", dataCnt);
		model.put("cntByPage", cntByPage);
		model.put("now",now);
		
		return model;
	}
	
	@RequestMapping("/freeBoardInsert.ino")
	public String freeBoardInsert(HttpSession session){
		RegisterDto user = (RegisterDto) session.getAttribute("user");
		
		return "freeBoardInsert";
	}
	

	@RequestMapping("/freeBoardInsertPro.ino")
	public String freeBoardInsertPro(HttpServletRequest request, FreeBoardDto dto){
		ModelAndView mav = new ModelAndView();
		
		freeBoardService.freeBoardInsertPro(dto);
		
		// redirect = 수정
		return "redirect:freeBoardDetail.ino?num="+dto.getNum();
	}
	
	@RequestMapping("/freeBoardDetail.ino")
	public ModelAndView freeBoardDetail(HttpServletRequest request, HttpSession session){
		
		RegisterDto user = (RegisterDto) session.getAttribute("user");
		
		int num = Integer.parseInt(request.getParameter("num"));
		FreeBoardDto dto = freeBoardService.getDetailByNum(num);

//		System.out.println(dto.toString());

		return new ModelAndView("freeBoardDetail", "freeBoardDto", dto);
	}
	
	@RequestMapping("/freeBoardEdit.ino")
	public ModelAndView freeBoardEdit(HttpServletRequest request, HttpSession session){
		
		RegisterDto user = (RegisterDto) request.getSession().getAttribute("user");
//		RegisterDto user = (RegisterDto) session.getAttribute("user");
		
		int num = Integer.parseInt(request.getParameter("num"));
		FreeBoardDto dto = freeBoardService.getDetailByNum(num);

		System.out.println(dto.toString());
		
		return new ModelAndView("freeBoardEdit", "freeBoardDto", dto);
	}
	

	@RequestMapping("/freeBoardEditPro.ino")
	public String freeBoarEditPro(HttpServletRequest request, FreeBoardDto dto){
		ModelAndView mav = new ModelAndView();
		
		freeBoardService.freeBoardEditPro(dto);
		
		// redirect = 수정
		return "redirect:freeBoardDetail.ino?num="+dto.getNum();
	}
	
	@RequestMapping("/freeBoardDelete.ino")
	public String freeBoarDeletePro(HttpServletRequest request, int num){
		ModelAndView mav = new ModelAndView();
		System.out.println(num);
		freeBoardService.freeBoardDeletePro(num);
		
		// redirect = 삭제
		return "redirect:main.ino";
	}
	
	@RequestMapping("/freeBoardLogin.ino")
	public ModelAndView freeboardLogin(HttpServletRequest request, HttpSession session){
		
		RegisterDto user = (RegisterDto) request.getSession().getAttribute("user");
//		RegisterDto user = (RegisterDto) session.getAttribute("user");
		
		return new ModelAndView("freeBoardLogin", "flag", 0);
	}
	
}
