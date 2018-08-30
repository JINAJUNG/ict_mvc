package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MemberDAO;
import com.ict.erp.dao.impl.MemberDAOImpl;
import com.ict.erp.service.MemberService;
import com.ict.erp.vo.MemberInfo;

public class MemberServiceImpl implements MemberService {
	private MemberDAO mdao = new MemberDAOImpl();

	@Override
	public List<MemberInfo> getMemberList(MemberInfo mi) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.selectMemberList(mi);
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}

	}

	public static void main(String[] args) {
		MemberService s = new MemberServiceImpl();
		try {
			if (s.getMemberList(null).size() == 0) {
				System.out.println("성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberInfo getMi(int miNum) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.selectMi(miNum);
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}

	}

	@Override
	public Map<String, Object> insertMi(MemberInfo mi) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		Map<String, Object> rMap = new HashMap<String, Object>();
		try {
			int cnt = mdao.insertMi(mi);
			rMap.put("cnt", cnt);
			rMap.put("msg", "실패");
			if (cnt ==1) {
				rMap.put("msg", "성공");
			}
			return rMap;
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}

	}

	@Override
	public Map<String, Object> updateMi(MemberInfo mi) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		Map<String, Object> rMap = new HashMap<String, Object>();
		try {
			int cnt = mdao.updateMi(mi);
			rMap.put("cnt", cnt);
			rMap.put("msg", "실패");
			if (cnt ==1) {
				rMap.put("msg", "성공");
			}
			return rMap;
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}

	}

	@Override
	public Map<String, Object> deleteMi(MemberInfo mi) throws SQLException {
		Map<String,Object> rMap = new HashMap<String,Object>();
		mdao.setConnection(DBCon.getCon());
		try {
			int cnt = mdao.deleteMi(mi);
			rMap.put("cnt", cnt);
			rMap.put("msg", "실패");
			if(cnt==1) {
				rMap.put("msg", "성공");
			}
		}catch (SQLException e) {
			DBCon.rollback();
			rMap.put("cnt", 0);
			throw e;
		}finally {
			DBCon.close();
		}
		
		return rMap;
	}

}
