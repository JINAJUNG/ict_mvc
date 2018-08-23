package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.TestInfo;

public interface TestInfoService {
	public List<TestInfo> getTest(TestInfo ti) throws SQLException;
	public TestInfo getTest(int tiNum) throws SQLException;
}
