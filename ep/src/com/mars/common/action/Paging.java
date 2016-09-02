package com.mars.common.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.mars.common.db.DBManager;

public class Paging {
	public static HashMap<String, Integer> getParam(String query, int pn, int rpp, int ppb){
		int totRec = 0;
		int totPage = 0;
		int totBlock = 0;
		int pageNo = pn;
		int blockNo = 1;
		int recPerPage = rpp;
		int pagePerBlock = ppb;
		int sttRecNo = 0;
		int endRecNo = 0;
		int firstPageNoInBlock = 0;
		int lastPageNoInBlock = 0;
		int prevPageNo = 0;
		int nextPageNo = 0;
		
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
		
//		4. 출력할 페이지의 첫번째 레코드 번호와 마지막 레코드 번호를 구한다
		sttRecNo = (pageNo-1)*recPerPage + 1;
		endRecNo = sttRecNo + recPerPage - 1;

//		5. 출력할 페이지가 있는 blockNo를 구한다
		if(pageNo % pagePerBlock == 0){
			blockNo = pageNo/pagePerBlock;
		} else {
			blockNo = pageNo/pagePerBlock + 1;
		}
		
//		6. 출력할 페이지가 있는 block의 first/lastPageNo를 구한다
		firstPageNoInBlock = (blockNo-1)*pagePerBlock + 1;
		if(blockNo == totBlock){
			lastPageNoInBlock = totPage;
		}
		lastPageNoInBlock = blockNo*pagePerBlock;
		
//		7. 출력할 페이지 block의 prev/next버튼을 눌렀을 때 해당하는 pgeNo를 구한다
		if(blockNo > 1){
			prevPageNo = firstPageNoInBlock - 1; 
		}
		if(blockNo < totBlock){
			nextPageNo = lastPageNoInBlock + 1;
		}
//		8. 계산된 변수들을 맵에 저장하여 리턴
		HashMap<String, Integer> map = new HashMap<>();
		
		map.put("sttRecNo", sttRecNo);
		map.put("endRecNo", endRecNo);
		map.put("firstPageNoInBlock", firstPageNoInBlock);
		map.put("lastPageNoInBlock", lastPageNoInBlock);
		map.put("prevPageNo", prevPageNo);
		map.put("nextPageNo", nextPageNo);
		map.put("totPage", totPage);
		map.put("totBlock", totBlock);
		map.put("blockNo", blockNo);
		map.put("pageNo", pageNo);
		
		return map;
	}
}






























