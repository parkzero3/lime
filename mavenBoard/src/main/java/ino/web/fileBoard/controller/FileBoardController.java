package ino.web.fileBoard.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import ino.web.fileBoard.dto.FileBoardDto;
import ino.web.fileBoard.dto.FileDataDto;
import ino.web.fileBoard.service.FileBoardService;

@Controller
public class FileBoardController {

	@Autowired
	private FileBoardService fileBoardService;

	@RequestMapping("/fileBoardMain.ino")
	public ModelAndView main(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		List list = fileBoardService.fileBoardList();
		// List list = FileBoardService.FileBoardList2();

		mav.setViewName("fileBoardMain");
		mav.addObject("fileBoardList", list);

		return mav;
	}

	@RequestMapping("/fileBoardInsert.ino")
	public String FileBoardInsert() {
		return "fileBoardInsert";
	}


	@RequestMapping("/fileBoardDetail.ino")
	public ModelAndView FileBoardDetail(HttpServletRequest request) {

		int num = Integer.parseInt(request.getParameter("num"));
		FileBoardDto dto = fileBoardService.getDetailByNum(num);
		// System.out.println(dto.toString());

		return new ModelAndView("fileBoardDetail", "fileBoardDto", dto);
	}

	@RequestMapping("/fileBoardEdit.ino")
	public ModelAndView FileBoardEdit(HttpServletRequest request) {

		int num = Integer.parseInt(request.getParameter("num"));
		FileBoardDto dto = fileBoardService.getDetailByNum(num);

		System.out.println(dto.toString());

		return new ModelAndView("fileBoardEdit", "fileBoardDto", dto);
	}
	
	@RequestMapping("/fileBoardUpdatePro.ino")
	   public String FileBoardUpdatePro(HttpServletRequest request, FileBoardDto fileBoardDto, MultipartHttpServletRequest mhsr, Object image) {

		System.out.println(fileBoardDto);
		
	      FileDataDto fileDataDto = new FileDataDto(); // 저장할 파일 객체 생성
	      fileDataDto.setBoardnum(fileBoardDto.getNum()); // 이미 존재하는 게시물의 첨부파일이므로, 게시판번호 필드 값 알맞게 설정.(새로운 게시물 x)

	      String path = request.getServletContext().getRealPath("/upload");
	      System.out.println(path);
	      MultipartFile imgFile = mhsr.getFile("fileName");
	      
	      System.out.println("imgFile==sibal??"+imgFile);
	      	// 파일 읽어들임. 
	      	// 파일은 jsp에서 ${fileBoardDto.chgname} 이므로 이렇게 읽어들인다.

	      System.out.println("imgFile==" + imgFile);

	      String filePath = null;
	      String fName = imgFile.getOriginalFilename(); // 파일 읽어들임.
	      
	      System.out.println("fName=="+fName);
	      fileDataDto.setOriname(fName); // 저장할 파일 객체의 원본 파일명(OriName) 설정


	      if (fName != null && !fName.equals("")) {
	         SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyyMMddhhmmss");
	         String todate = yyyymmdd.format(new Date()); // 현재시간데이터 생성
	         
	         String oriFileName = fName.substring(0, fName.lastIndexOf("."));
	         // 현재 파일명에서 확장자를 뺀 파일명 추출
	        
	         String oriExt = fName.substring(fName.lastIndexOf(".")); // 파일명에서 확장자 추출
	 
	         String nFile = todate + "_" + fName; // “현재시간_원본파일명” 형식의 새로운 파일명 생성 (중복방지)
	         
	         File newFile=new File(path+"/" + nFile); // 오늘 날짜를 이용해 새로운 파일 객체 생성(FileDataDto와 혼돈하면 안된다. ‘File’객체는 실제로 pc에 저장하거나 읽어올 물리적 파일을 의미함.)

	         System.out.println("newFile = " + newFile);

	         fileDataDto.setChgname(nFile); // fileDto ChgName(변환명) 설정
	         
	         if (newFile.exists()) { // 만약 동일한 경로+파일이 존재하는 경우에는 
	            for (int renameNum = 1;; renameNum++) {
	               String renameFile = todate + "_" + oriFileName + "(" + renameNum + ")" + oriExt; // “변환파일명(i)” 꼴의 파일명으로 한다.
	               fileDataDto.setChgname(renameFile); // fileDto ChgName 설정

	               System.out.println("filename==> " + renameFile);
	               newFile = new File(path, renameFile); 

	               if (!newFile.exists()) {
	                  fName = renameFile;
	                  break;
	               } // if
	               
	            } // for
	         } // if
	         try {
	            imgFile.transferTo(newFile); //  실제로 경로(path)에 파일을 물리적으로 저장하는 과정.
	            System.out.println("newFile:" + newFile);

	            filePath = "/mavenBoard/upload/" + (newFile).getName();
	            System.out.println("filePath = " + filePath);
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      } // if

		// 게시물 dto와 파일 dto를 전달하여 db처리
		 fileBoardService.fileDataUpdatePro(fileDataDto, fileBoardDto);     

		return "redirect:fileBoardDetail.ino?num=" + fileBoardDto.getNum();
	   }
	

	@RequestMapping("/fileBoardInsertPro.ino")
	public String FileBoardInsertPro(HttpServletRequest request, MultipartHttpServletRequest mhsr, FileBoardDto dto,
			Object image) {
		ModelAndView mav = new ModelAndView();
		// 파일 dto 생성
		FileDataDto fileDto = new FileDataDto();

		String path = request.getServletContext().getRealPath("/upload");
		System.out.println(path);
		// String path =
		// request.getSession().getServletContext().getRealPath("/upload");

		MultipartFile imgFile = mhsr.getFile("fileName");

		System.out.println("imgFile" + imgFile);

		// String fName=image.getOriginalFilename();

		String filePath = null;
		String fName = imgFile.getOriginalFilename();
		System.out.println("fName:" + fName);

		if (fName != null && !fName.equals("")) {
			SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyyMMddhhmmss");
			String todate = yyyymmdd.format(new Date()); // 오늘 날짜 데이터 생성
			String oriFileName = fName.substring(0, fName.lastIndexOf("."));
			fileDto.setOriname(oriFileName); // fileDto OrgName 설정

			String oriExt = fName.substring(fName.lastIndexOf("."));

			
			String nFile = todate + "_" + fName;
			
			File newFile=new File(path+"/" + nFile); // 오늘 날짜를 이용해 새로운 파일명 생성 
			
			System.out.println("newFile = " + newFile);
			System.out.println("filePath = " + filePath);

			fileDto.setChgname(nFile); // fileDto ChgName 설정
			
			if (newFile.exists()) {
				for (int renameNum = 1;; renameNum++) {
					String renameFile = todate + "_" + oriFileName + "(" + renameNum + ")" + oriExt;
					fileDto.setChgname(renameFile); // fileDto ChgName 설정

					System.out.println("filename==> " + renameFile);
					newFile = new File(path, renameFile);

					if (!newFile.exists()) {
						fName = renameFile;
						break;
					} // if
					
				} // for
			} // if
			try {
				imgFile.transferTo(newFile);
				System.out.println("newFile:" + newFile);

				filePath = "/mavenBoard/upload/" + (newFile).getName();
				System.out.println("filePath = " + filePath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // if

		fileBoardService.fileBoardInsertPro(dto, fileDto);

		// redirect = 수정
		return "redirect:fileBoardDetail.ino?num=" + dto.getNum();
	}
	
	@RequestMapping("/fileBoardDelete.ino")
	public String FileBoardeletePro(HttpServletRequest request, FileBoardDto dto) {
		String path = request.getSession().getServletContext().getRealPath("/upload");
		
		System.out.println(dto);
		String filePath = null;
		String fName = dto.getChgname();
		
		System.out.println("fName = "+fName);
		
		if(!fName.equals(null) && fName != null){
			fName = fName.trim();
			File file = new File(path,fName);
			System.out.println("file--"+file);
			
			if(file.exists()){
				file.delete();
				fileBoardService.fileDataDeletePro(dto.getNum()); // 서비스에 새로운 메소드 추가
				
			}x
		}

		
		fileBoardService.fileBoardDeletePro(dto.getNum());

		// redirect = 삭제
		return "redirect:fileBoardMain.ino";
	}
	
	
	
	@RequestMapping("/fileDataDeletePro.ino")
	public String FileDataDeletePro(HttpServletRequest request, int boardNum, String fileName){
		
		
		String path = request.getSession().getServletContext().getRealPath("/upload");
		
		String filePath = null;
		String fName = fileName;
		
		System.out.println("fName = "+fName);
		
		if(!fName.equals(null) && fName != null){
			fName = fName.trim();
			File file = new File(path,fName);
			System.out.println("file--"+file);
			
			if(file.exists()){
				file.delete();
				fileBoardService.fileDataDeletePro(boardNum); // 서비스에 새로운 메소드 추가
				
			}
		}
		return "redirect:fileBoardEdit.ino?num=" + boardNum;
	}
	
}


