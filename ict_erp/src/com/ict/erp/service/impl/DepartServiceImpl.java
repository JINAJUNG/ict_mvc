package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.dao.DepartDAO;
import com.ict.erp.dao.impl.DepartDAOImpl;
import com.ict.erp.service.DepartService;
import com.ict.erp.vo.DepartInfo;

public class DepartServiceImpl implements DepartService {
	private DepartDAO ddao = new DepartDAOImpl();
	
	@Override
	public List<DepartInfo> getDepartInfoList(DepartInfo di) throws SQLException {
		return ddao.selectDepartInfoList(di);
	}

	@Override
	public DepartInfo getDepartInfo(int diNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> insertDepartInfo(DepartInfo di) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateDepartInfo(DepartInfo di) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteDepartInfo(DepartInfo di) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
