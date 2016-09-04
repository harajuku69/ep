package com.mars.noti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mars.common.db.DBManager;
import com.mars.noti.dto.NotiDto;

public class NotiDao {

	private NotiDao() {
	}
	
	private static NotiDao instance = new NotiDao();
	
	public static NotiDao getInstance(){
		if(instance == null){
			instance = new NotiDao();
		}
		return instance;
	}
	
	public List<NotiDto> selectAllNoti(String sttRecNo, String endRecNo){
//		String sql = "SELECT * "
//					 + "FROM ("
//					 		+ "SELECT * "
//					 		  + "FROM noti ORDER BY notino "
//					 		+ ") a "
//					 + ") s "
//					 		+ "noti order by notino desc";
		String sql = "SELECT * "
				 	 + "FROM ("
				 	 		+ "SELECT ROWNUM R, a.* "
				 	 		 + " FROM ( "
				 	 		 		  + "SELECT * "
				 	 		 		    + "FROM noti ORDER BY notino desc "
				 	 		 	    + ") a "
				 	 	   + ") n "
				 	+ "WHERE R BETWEEN ? AND ? "
				 	+ "ORDER BY n.notino desc";
		
		List<NotiDto> notiList = new ArrayList<NotiDto>();
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
				NotiDto nDto = new NotiDto();
				
				nDto.setNotino(rs.getInt("notino"));
				nDto.setAdmnm(rs.getString("admnm"));
				nDto.setTit(rs.getString("tit"));
				nDto.setCtt(rs.getString("ctt"));
				nDto.setRegdt(rs.getTimestamp("regdt"));
				nDto.setRdcnt(rs.getInt("rdcnt"));
				nDto.setDelchk(rs.getInt("delchk"));
				
				notiList.add(nDto);
//				System.out.println(notiList);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return notiList;
	}

	public NotiDto selectOneByNotino(String notino){
		String sql = "select * from noti where notino=?";
		
		NotiDto nDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, notino);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				nDto = new NotiDto();
				
				nDto.setNotino(rs.getInt("notino"));
				nDto.setAdmnm(rs.getString("admnm"));
				nDto.setTit(rs.getString("tit"));
				nDto.setCtt(rs.getString("ctt"));
				nDto.setRegdt(rs.getTimestamp("regdt"));
				nDto.setRdcnt(rs.getInt("rdcnt"));
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return nDto;
	}
	
	public void insertNoti(NotiDto nDto){
		String sql = "insert into noti(notino, admnm, title, contents) values(noti_no_seq.nextval,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nDto.getAdmnm());
			pstmt.setString(2, nDto.getCtt());
			pstmt.setString(3, nDto.getTit());
			
			pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateReadCount(String notino){
		String sql = "update noti set readcnt=readcnt+1 where notino=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
				
			pstmt.setString(1, notino);
				
			pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateNoti(NotiDto nDto){
		String sql = "update noti set admnm=?, title=?, contents=? where notino=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, nDto.getAdmnm());
			pstmt.setString(2, nDto.getTit());
			pstmt.setString(3, nDto.getCtt());
			pstmt.setInt(4, nDto.getNotino());	
			
			pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	public int deleteNoti(String notino){
		String sql = "delete noti where notino=?";
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, notino);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} 
		return result;
	}
}//class end































