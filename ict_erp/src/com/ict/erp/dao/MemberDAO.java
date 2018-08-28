package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.MemberInfo;

public interface MemberDAO extends CommonDAO{
	public List<MemberInfo> selectMemberList(MemberInfo mi) throws SQLException;
	public MemberInfo selectMi(int miNum) throws SQLException;
	public int insertMi(MemberInfo mi) throws SQLException;
	public int updateMi(MemberInfo mi) throws SQLException;
	public int deleteMi(MemberInfo mi) throws SQLException;
		
	
}
