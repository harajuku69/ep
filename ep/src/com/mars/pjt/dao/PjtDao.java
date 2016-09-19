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
		String sql = "SELECT p.pjtno, p.pjtnm, p.pjtdtl, p.startdt, p.enddt, p.regdt, p.plid, s.empnm "
				 	 + "FROM ("
				 	 		+ "SELECT ROWNUM R, a.* "
				 	 		 + " FROM ( "
				 	 		 		  + "SELECT * "
				 	 		 		    + "FROM pjt ORDER BY pjtno desc "
				 	 		 	    + ") a "
				 	 	   + ") p "
				 	+ " JOIN staff s "
				 	  + " ON p.plid =s.empid "
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
				pDto.setPlnm(rs.getString("empnm"));
				pDto.setPlid(rs.getString("plid"));
				
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

	public void writePjt(PjtDto pDto) {
		String sql = "insert into pjt(pjtno, pjtnm, pjtdtl, startdt, enddt, plid) "
							+ "values(pjtno_seq.nextval,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pDto.getPjtnm());
			pstmt.setString(2, pDto.getPjtdtl());
			pstmt.setTimestamp(3, pDto.getStartdt());
			pstmt.setTimestamp(4, pDto.getEnddt());
			pstmt.setString(5, pDto.getPlid());
			
			pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
	}
	
}


























