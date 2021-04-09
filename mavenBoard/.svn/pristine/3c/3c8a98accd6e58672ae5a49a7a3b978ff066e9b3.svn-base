package ino.web.freeBoard.service;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ino.web.freeBoard.dto.RegisterDto;

@Service
public class RegisterService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int loginCntChk(String id, String pwd) {
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("id", id);
		param.put("pwd", pwd);
		
		return sqlSessionTemplate.selectOne("loginCntChk", param);
	}
	public RegisterDto loginChk(String id, String pwd) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("id", id);
		param.put("pwd", pwd);
		
		return sqlSessionTemplate.selectOne("loginChk", param);
	}
}
