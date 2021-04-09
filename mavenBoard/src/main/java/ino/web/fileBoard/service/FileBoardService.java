package ino.web.fileBoard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ino.web.fileBoard.dto.FileBoardDto;
import ino.web.fileBoard.dto.FileDataDto;

@Service
public class FileBoardService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List fileBoardList(){
		
		Map<String, String> param = new HashMap<String, String>();

		return sqlSessionTemplate.selectList("fileBoardGetList", param);
	}
	
	public List fileBoardList2(){
		return sqlSessionTemplate.selectList("fileBoardGetList2");
	}
	
	public void fileBoardInsertPro(FileBoardDto dto, FileDataDto fileDto){
		sqlSessionTemplate.insert("fileBoardInsertPro", dto);
		sqlSessionTemplate.insert("fileDataInsertPro", fileDto);
	}
	
	public void fileDataUpdatePro(FileDataDto fileDataDto, FileBoardDto dto){
		sqlSessionTemplate.insert("fileDataUpdatePro", fileDataDto);
		sqlSessionTemplate.update("fileBoardUpdate", dto);
	}
	
	
	public FileBoardDto getDetailByNum(int num){
		return sqlSessionTemplate.selectOne("fileBoardDetailByNum", num);
	}

	public void fileBoardEditPro(FileBoardDto dto, FileDataDto fileDto) {
		sqlSessionTemplate.update("fileBoardEditPro", dto);
		sqlSessionTemplate.update("fileDataEditPro", fileDto);
	}

	public void fileBoardDeletePro(int num) {
		sqlSessionTemplate.delete("fileBoardDeletePro", num);
		sqlSessionTemplate.delete("fileDataDeletePro", num);
	}	
	
	public void fileDataDeletePro(int boardNum){
		sqlSessionTemplate.delete("fileDataDeletePro",boardNum);
	}
}
