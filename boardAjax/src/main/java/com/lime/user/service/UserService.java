package com.lime.user.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lime.user.vo.UserVO;

@Service
public class UserService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int userInsertCheck(String userId)throws Exception {
			
		return sqlSessionTemplate.selectOne("userInsertCheck",userId);
	}
	
	public int userInsert(UserVO userVO){
		
		return sqlSessionTemplate.insert("userInsert",userVO);
	}

}
