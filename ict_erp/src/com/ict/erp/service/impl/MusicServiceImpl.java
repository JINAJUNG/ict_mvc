package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MusicDAO;
import com.ict.erp.dao.impl.MusicDAOImpl;
import com.ict.erp.service.MusicService;
import com.ict.erp.vo.MusicInfo;

public class MusicServiceImpl implements MusicService {
	private MusicDAO mdao = new MusicDAOImpl();
	
	@Override
	public List<MusicInfo> getMusicList(MusicInfo mi) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.selectList(mi);	
		}catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public MusicInfo getMusic(int mcNum) throws SQLException  {
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.selectMusic(mcNum);	
		}catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
		
	}

	@Override
	public Map<String, Object> insertMusic(MusicInfo mi) throws SQLException  {
		mdao.setConnection(DBCon.getCon());
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int cnt = mdao.insertMusic(mi);
			map.put("cnt", cnt);
			map.put("msg", "실패");
			if(cnt==1) {
				map.put("msg", "성공");
			}
		}catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
		
		
		return map;
	}

	@Override
	public Map<String, Object> updateMusic(MusicInfo mi) throws SQLException  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteMusic(int mcNum) throws SQLException  {
		mdao.setConnection(DBCon.getCon());
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int cnt = mdao.deleteMusic(mcNum);
			map.put("cnt", cnt);
			map.put("msg", "실패");
			if(cnt==1) {
				map.put("msg", "성공");
			}
		}catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
		
		
		return map;
	}

}
