package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.MusicInfo;

public interface MusicService {
	public List<MusicInfo> getMusicList(MusicInfo mi) throws SQLException ;
	public MusicInfo getMusic(int mcNum);
	public Map<String, Object> insertMusic(MusicInfo mi);
	public Map<String, Object> updateMusic(MusicInfo mi);
	public Map<String, Object> deleteMusic(int mcNum);
} 
