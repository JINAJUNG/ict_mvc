package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.DepartInfo;

public interface DepartDAO {
	public List<DepartInfo> selectDepartInfoList(DepartInfo di) throws SQLException;
	public DepartInfo selectDepartInfo(int diNum) throws SQLException;
	public Map<String,Object> insertDepartInfo(DepartInfo di) throws SQLException;
	public Map<String,Object> updateDepartInfo(DepartInfo di) throws SQLException;
	public Map<String,Object> deleteDepartInfo(DepartInfo di) throws SQLException;
}
