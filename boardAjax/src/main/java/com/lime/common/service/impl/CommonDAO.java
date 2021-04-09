package com.lime.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lime.account.vo.AccountVO;
import com.lime.account.vo.PageVO;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Repository("commonDAO")
public class CommonDAO extends EgovAbstractMapper{


	public List<EgovMap> selectCombo(Map<String, Object> inOutMap) throws EgovBizException{
		return selectList("Common.selectCombo", inOutMap);
	}

	public void insertAccount(Map<String, Object> inOutMap) throws EgovBizException{
		insert("Common.insertAccount", inOutMap);
	}
	
	public int selectMaxAccountSeq()throws EgovBizException{
		return selectOne("Common.selectMaxAccountSeq");
	}

	public Map<String, Object> selectAccount(int account_seq) {
		return selectOne("Common.selectAccountBySeq", account_seq);
	}

	public List<AccountVO> selectAccountList(AccountVO accountVO) {
		return selectList("Common.selectAccountList",accountVO);
	}

	public int updateAccount(Map<String, Object> inOutMap) {
		return update("Common.updateAccount", inOutMap);
	}
	
	public List<Map<String, Object>> selectAccountListByMap() {
		return selectList("Common.selectAccountListByMap");
	}

	public int selectAccountCountList(PageVO page) {
		return selectOne("Common.selectAccountCountList",page);
	}
}
