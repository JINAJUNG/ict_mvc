package com.ict.erp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ict.erp.common.DBCon;

import oracle.jdbc.internal.OracleTypes;
import oracle.jdbc.oracore.OracleType;

public class CallProcedure {

	public static void main(String[] args) {

		String sql = "{call p_inser_select_emp(?,?,?,?)}";

		Connection con = DBCon.getCon();

		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, "3");
			cs.setString(2, "고급");
			cs.setString(3, "고급관리자");
			cs.registerOutParameter(4, OracleTypes.CURSOR); 
			cs.executeQuery();
			ResultSet rs = (ResultSet) cs.getObject(4);
			while (rs.next()) {
				System.out.println(rs.getInt("linum"));
				System.out.println(rs.getInt("lilevel"));
				System.out.println(rs.getString("liname"));
				System.out.println(rs.getString("lidesc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 인설트1
		// String sql ="{call p_inser_emp(?,?,?,?)}";
		//
		// Connection con = DBCon.getCon();
		//
		// try {
		// CallableStatement cs = con.prepareCall(sql);
		// cs.setString(1, "2");
		// cs.setString(2, "중간");
		// cs.setString(3, "중간관리자");
		// cs.registerOutParameter(4, OracleTypes.NUMBER);
		// System.out.println(cs.executeUpdate());
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
/*
		
 String sql ="{call P_GET_EMP_CUR(?,?)}";
		  
		  Connection con = DBCon.getCon();
		  
		  try { CallableStatement cs = con.prepareCall(sql); cs.setString(1, "KING");
		  cs.registerOutParameter(2, OracleTypes.CURSOR); //OracleTypes.CURSOR : 데이터타입을 커서로 지정, 다른데서도 커서로 데이터 타입을 설정하면 이거 사용 하겟죠? 
		  cs.executeQuery();
		  ResultSet rs= (ResultSet)cs.getObject(2); while(rs.next()) {
		  System.out.println(rs.getInt("empno")); } 
		  }catch (SQLException e) { // TODO
		  Auto-generated catch block e.printStackTrace(); }
		 */
	}
}
