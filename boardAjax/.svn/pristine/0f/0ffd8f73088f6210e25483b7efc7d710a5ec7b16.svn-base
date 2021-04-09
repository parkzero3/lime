package com.lime.login.service;


import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lime.user.vo.UserVO;

@Service
public class LoginService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int loginCntChk(String user_id, String pwd) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("user_id", user_id);
		param.put("pwd", pwd);
		
		return sqlSessionTemplate.selectOne("loginCntChk", param);
	}

	public UserVO loginChk(String user_id, String pwd) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("user_id", user_id);
		param.put("pwd", pwd);
		
		return sqlSessionTemplate.selectOne("loginChk", param);
	}

}
