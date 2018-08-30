package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.MusicInfo;

public interface MusicDAO extends CommonDAO {
	public List<MusicInfo> selectList(MusicInfo mi) throws SQLException ;
	public MusicInfo selectMusic(int mcNum);
	public int insertMusic(MusicInfo mi);
	public int updateMusic(MusicInfo mi);
	public int deleteMusic(MusicInfo mi);
}
