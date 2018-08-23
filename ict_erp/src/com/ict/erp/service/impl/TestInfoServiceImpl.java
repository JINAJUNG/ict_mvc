package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.dao.TestInfoDAO;
import com.ict.erp.dao.impl.TestInfoDAOImpl;
import com.ict.erp.service.TestInfoService;
import com.ict.erp.vo.TestInfo;

public class TestInfoServiceImpl implements TestInfoService{

	TestInfoDAO tdao = new TestInfoDAOImpl();
	@Override
	public List<TestInfo> getTest(TestInfo ti) throws SQLException {
		return tdao.selectTestInfo(ti);
	}
	@Override
	public TestInfo getTest(int tiNum) throws SQLException {
		return tdao.selectTestInfo(tiNum);
	}

}
