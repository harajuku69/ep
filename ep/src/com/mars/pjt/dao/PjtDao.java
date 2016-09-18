package com.mars.pjt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mars.common.db.DBManager;
import com.mars.pjt.dto.PjtDto;

public class PjtDao {
	
	private PjtDao() {
	}
	
	private static PjtDao instance = new PjtDao();
	
	public static PjtDao getInstance(){
		if(instance == null){
			instance = new PjtDao();
		}
		return instance;
	}
	
	public List<PjtDto> selectAllPjt(String sttRecNo, String endRecNo){
		String sql = "SELECT * "
				 	 + "FROM ("
				 	 		+ "SELECT ROWNUM R, a.* "
				 	 		 + " FROM ( "
				 	 		 		  + "SELECT * "
				 	 		 		    + "FROM pjt ORDER BY pjtno desc "
				 	 		 	    + ") a "
				 	 	   + ") p "
				 	+ "WHERE R BETWEEN ? AND ? "
				 	+ "ORDER BY p.pjtno desc";
		
		List<PjtDto> pjtList = new ArrayList<PjtDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sttRecNo);
			pstmt.setString(2, endRecNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				PjtDto pDto = new PjtDto();
				
				pDto.setPjtno(rs.getInt("pjtno"));
				pDto.setPjtnm(rs.getString("pjtnm"));
				pDto.setPjtdtl(rs.getString("pjtdtl"));
				pDto.setStartdt(rs.getTimestamp("startdt"));
				pDto.setEnddt(rs.getTimestamp("enddt"));
				pDto.setRegdt(rs.getTimestamp("regdt"));
				pDto.setRegnm(rs.getString("regnm"));
				
				pjtList.add(pDto);
//				System.out.println(pjtList);
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return pjtList;
	}
	
	public int deletePjt(String pjtno){
		String sql = "delete pjt where pjtno=?";
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pjtno);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} 
//		System.out.println(result);
		return result;
	}
	
}


























