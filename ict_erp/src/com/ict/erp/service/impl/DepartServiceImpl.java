package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
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
			pi.initPage(ddao.totalCount("depart_info"), 10, 15);
			return ddao.selectDepartInfoList(di);
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}
	}

	@Override
	public DepartInfo getDepartInfo(int diNum) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		try {
			return ddao.selectDepartInfo(diNum);
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}

	}

	@Override
	public Map<String, Object> insertDepartInfo(DepartInfo di) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		Map<String, Object> rMap = new HashMap<String, Object>();
		try {
			int cnt = ddao.insertDepartInfo(di);
			rMap.put("cnt", cnt);
			rMap.put("msg", "fail..");
			if (cnt == 1) {
				rMap.put("msg", "success!!");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}
		return rMap;
	}

	@Override
	public Map<String, Object> updateDepartInfo(DepartInfo di) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int cnt = ddao.updateDepartInfo(di);
			map.put("cnt", cnt);
			map.put("msg", "실패");
			if (cnt == 1) {
				map.put("msg", "성공");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}

		return map;
	}

	@Override
	public Map<String, Object> deleteDepartInfo(DepartInfo di) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int cnt = ddao.deleteDepartInfo(di);
			map.put("cnt", cnt);
			map.put("msg", "실패");
			if (cnt == 1) {
				map.put("msg", "성공");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}
		return map;
	}
}