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

			while (rs.next()) {
				mi = new MusicInfo(rs.getInt("mcNum"), rs.getString("mcName"), rs.getString("mcSinger"),
						rs.getString("mcVendor"), rs.getInt("mcLike"), rs.getInt("mcDislike"), rs.getString("mcCredat"),
						rs.getString("mcDesc"));
				musicList.add(mi);
			}
			return musicList;
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public MusicInfo selectMusic(int mcNum) throws SQLException {
		String sql = "select * from music_chart where mcNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mcNum);
			rs = ps.executeQuery();
			MusicInfo mi = null;
			if (rs.next()) {
				mi = new MusicInfo(rs.getInt("mcNum"), rs.getString("mcName"), rs.getString("mcSinger"),
						rs.getString("mcVendor"), rs.getInt("mclike"), rs.getInt("mcDisLike"), rs.getInt("mccredat")+"",
						rs.getString("mcdesc"));
			}
			return mi;
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}

	}

	@Override
	public int insertMusic(MusicInfo mi) throws SQLException {
		String sql = "insert into music_chart(mcnum,mcname,mcsinger,mcvendor,mccredat,mcdesc) "
				+ "values(seq_mcnum.nextval,?,?,?,to_char(sysdate,'YYYYMMDD'),?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mi.getMcName());
			ps.setString(2, mi.getMcSinger());
			ps.setString(3, mi.getMcVendor());
			ps.setString(4, mi.getMcDesc());
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public int updateMusic(MusicInfo mi) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMusic(int mcNum) throws SQLException {
		String sql = "delete from music_chart where mcNum=? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mcNum);
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

}
