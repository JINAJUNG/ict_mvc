package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.DepartDAO;
import com.ict.erp.dao.impl.DepartDAOImpl;
import com.ict.erp.service.DepartService;
import com.ict.erp.vo.DepartInfo;
import com.ict.erp.vo.PageInfo;

public class DepartServiceImpl implements DepartService {
	private DepartDAO ddao = new DepartDAOImpl();
	
	@Override
	public List<DepartInfo> getDepartInfoList(DepartInfo di) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		try {
			PageInfo pi = di.getPi();
			pi.initPage(ddao.totalCount("depart_info"),10,15);
			return ddao.selectDepartInfoList(di);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
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
