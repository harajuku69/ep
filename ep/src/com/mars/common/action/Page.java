package com.mars.common.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mars.common.db.DBManager;

public class Page {
	public static int[] paging(String query, int pn, int rpp, int ppb){
		int[] recNo = {0,0};
		
		int totRec = 0;
		int totPage = 0;
		int totBlock = 0;
		int pageNo = pn;
		int blockNo = 1;
		int recPerPage = rpp;
		int pagePerBlock = ppb;
//		int prevPageNo = 0;
//		int nextPageNo = 0;
		String sql = query;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
//		1.total Record를 구한다
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totRec = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
//		2. total Page를 구한다
		if(totRec > 0){
			if(totRec % recPerPage == 0){
				totPage = totRec/recPerPage;
			} else {
				totPage = totRec/recPerPage + 1;
			}
		}
		
//		3. total Block을 구한다
		if(totPage > 0){
			if(totPage % pagePerBlock == 0){
				totBlock = totPage/pagePerBlock;
			} else {
				totBlock = totPage/pagePerBlock + 1;
			}
		}
		
//		4. 출력할 첫번째 레코드 번호와 마지막 레코드 번호를 구한다
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		for(int i=0;i<recNo.length;i++){
//			System.out.println(recNo[i]);
//		}
		return recNo;
	}
}






























