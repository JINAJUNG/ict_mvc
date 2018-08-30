package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.dao.MusicDAO;
import com.ict.erp.vo.MusicInfo;

public class MusicDAOImpl extends CommonDAOImpl implements MusicDAO {

	@Override
	public List<MusicInfo> selectList(MusicInfo mi) throws SQLException {
		String sql = "select * from music_chart";
		List<MusicInfo> musicList = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				mi = new MusicInfo(rs.getInt("mcNum"), rs.getString("mcName"), rs.getString("mcSinger"), rs.getString("mcVendor"), rs.getInt("mcLike"), rs.getInt("mcDislike"), rs.getString("mcCredat"), rs.getString("mcDesc"));
				musicList.add(mi);
			}
			return musicList;
		}catch (SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public MusicInfo selectMusic(int mcNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMusic(MusicInfo mi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMusic(MusicInfo mi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMusic(MusicInfo mi) {
		// TODO Auto-generated method stub
		return 0;
	}

}
