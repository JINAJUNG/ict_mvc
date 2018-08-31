package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.MusicInfo;

public interface MusicDAO extends CommonDAO {
	public List<MusicInfo> selectList(MusicInfo mi) throws SQLException ;
	public MusicInfo selectMusic(int mcNum) throws SQLException ;
	public int insertMusic(MusicInfo mi) throws SQLException ;
	public int updateMusic(MusicInfo mi) throws SQLException ;
	public int deleteMusic(int mcNum) throws SQLException ;
}
