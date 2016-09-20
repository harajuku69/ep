package com.mars.noti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mars.common.db.DBManager;
import com.mars.noti.dto.CmtDto;
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
				nDto.setCmtcnt(rs.getInt("cmtcnt"));
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

	public NotiDto selectOneByNotino(int notino){
		String sql = "select * from noti where notino=?";
		
		NotiDto nDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setInt(1, notino);
			
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
	
	public void writeNoti(NotiDto nDto){
		String sql = "insert into noti(notino, admnm, tit, ctt) values(notino_seq.nextval,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nDto.getAdmnm());
			pstmt.setString(2, nDto.getTit());
			pstmt.setString(3, nDto.getCtt());
			
			pstmt.executeUpdate();
//			System.out.println(result);
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	public CmtDto writeCmt(CmtDto cDto){
		/*String sql = "insert into cmt(cmtno, notino, regid, ctt, pwd) "
							+ "values(cmtno_seq.nextval,?,?,?,?)";*/
		String sql = "INSERT INTO cmt(cmtno, notino, regid, ctt, pwd, regnm) "
							+ "VALUES(cmtno_seq.nextval,?,?,?,?, "
															 + "(SELECT "
															 + "   CASE "
															 	+ "WHEN admstat = 1 THEN admnm "
															 	+ "WHEN admstat = 0 THEN empnm "
															 	 + "END "
															 	+ "FROM STAFF "
															   + "WHERE empid = ? "
															 + ")"
								  + ")";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		int notino = cDto.getNotino();
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cDto.getNotino());
			pstmt.setString(2, cDto.getRegid());
			pstmt.setString(3, cDto.getCtt());
			pstmt.setInt(4, cDto.getPwd());
			pstmt.setString(5, cDto.getRegid());
			
			pstmt.executeUpdate();
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
		
		updateCmtcnt(cDto.getNotino());
		
		sql = "SELECT cmtno, regnm, ctt, regdt, pwd"
			 + " FROM cmt "
			 + "WHERE cmtno = ( "
			 				  + "SELECT MAX(cmtno) "
			 				    + "FROM cmt"
			 			   + ")";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				cDto.setCmtno(Integer.parseInt(rs.getString("cmtno")));
				cDto.setRegnm(rs.getString("regnm"));
				cDto.setCtt(rs.getString("ctt"));
				cDto.setRegdt(rs.getTimestamp("regdt"));
				cDto.setPwd(rs.getInt("pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
		
		return cDto;
	}
	public void updateCmtcnt(int notino){
		String sql = "SELECT COUNT(*) cmtcnt FROM cmt WHERE notino=?";
		
		int cmtcnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notino);				
			rs = pstmt.executeQuery();
			rs.next();
			cmtcnt = rs.getInt("cmtcnt");
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
		
		sql = "update noti set cmtcnt=? where notino=?";
		
		conn = null;
		pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setInt(1, cmtcnt);
			pstmt.setInt(2, notino);
				
			pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
	}
	public List<CmtDto> selectAllCmt(int notino, int sttRecNo, int endRecNo, int cmtcnt){
		/*String	sql = "SELECT R, c.cmtno, c.notino, s.admnm, c.regnm, c.ctt, c.regdt, c.pwd "
					  + "FROM ( "
					  		  + "SELECT ROWNUM R, a.* "
					  		  	+ "FROM ( "
									    + "SELECT cmtno, notino, regnm, ctt, regdt, pwd "
									      + "FROM cmt "
									     + "WHERE notino=? "
									     + "ORDER BY cmtno desc"
								      + ") a"
						    + ") c "
					   + "JOIN staff s "
					     + "ON c.regid = s.empid "
					  + "WHERE R BETWEEN ? AND ? "
					  + "ORDER BY cmtno desc ";*/
		String	sql = "SELECT R, cmtno, notino, regid, regnm, ctt, regdt, pwd "
					  + "FROM ( "
					  		  + "SELECT ROWNUM R, a.* "
					  		  	+ "FROM ( "
									    + "SELECT cmtno, notino, regid, regnm, ctt, regdt, pwd "
									      + "FROM cmt "
									     + "WHERE notino=? "
									     + "ORDER BY cmtno desc"
								      + ") a"
						    + ") "
					  + "WHERE R BETWEEN ? AND ? "
					  + "ORDER BY cmtno desc ";
		List<CmtDto> cmtList = new ArrayList<CmtDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notino);
			pstmt.setInt(2, sttRecNo);
			pstmt.setInt(3, endRecNo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				CmtDto cDto = new CmtDto();
				
				cDto.setCmtno(Integer.parseInt(rs.getString("cmtno")));
				cDto.setNotino(Integer.parseInt(rs.getString("notino")));
				cDto.setRegid(rs.getString("regid"));
				cDto.setRegnm(rs.getString("regnm"));
				cDto.setCtt(rs.getString("ctt"));
				cDto.setRegdt(rs.getTimestamp("regdt"));
				cDto.setPwd(Integer.parseInt(rs.getString("pwd")));
				cDto.setRpno(cmtcnt - Integer.parseInt(rs.getString("R")) + 1);
				
				cmtList.add(cDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
//		System.out.println(cmtList);
		return cmtList;
	}
	
	public void updateRdCnt(int notino){
		String sql = "update noti set rdcnt=rdcnt+1 where notino=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setInt(1, notino);
				
			pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateNoti(NotiDto nDto){
		String sql = "update noti set admnm=?, tit=?, ctt=? where notino=?";
		
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
	
	public int deleteNoti(int notino){
		String sql = "delete noti where notino=?";
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, notino);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} 
//		if(result == 1){
//			changeDelchk("noti", "notino", notino);
//		}
		return result;
	}

	public int deleteCmt(int cmtno) {
		String sql = "delete cmt where cmtno=?";

		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cmtno);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} 
//		if(result == 1){
//			changeDelchk("cmt", "cmtno", cmtno);
//		}
//		System.out.println(result);
		return result;
	}
	public void changeDelchk(String tab, String col, int no) {
		String sql = "update ? where ?=?";
		String table = tab;
		String column = col;
		int num = no;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, table);
			pstmt.setString(2, column);
			pstmt.setInt(3, num);
			
			pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} 
	}

	public List<NotiDto> selectNotiByStr(String field, String item) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from noti where ");
		sql.append(field);
		sql.append(" like '%'|| ? ||'%' order by notino desc");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<NotiDto> notiList = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, item);
			rs = pstmt.executeQuery();
			while(rs.next()){
				NotiDto nDto = new NotiDto();
				
				nDto.setNotino(rs.getInt("notino"));
				nDto.setTit(rs.getString("tit"));
				nDto.setCmtcnt(rs.getInt("cmtcnt"));
				nDto.setRdcnt(rs.getInt("rdcnt"));
				nDto.setRegdt(rs.getTimestamp("regdt"));
				nDto.setAdmnm(rs.getString("admnm"));
				nDto.setCtt(rs.getString("ctt"));
				
				notiList.add(nDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return notiList;
	}

	public List<NotiDto> selectNotiByDt(String from, String to) {
		String sql = "select * from noti where regdt between ? and ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<NotiDto> notiList = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, from);
			pstmt.setString(2, to);
			rs = pstmt.executeQuery();
			while(rs.next()){
				NotiDto nDto = new NotiDto();
				
				nDto.setNotino(rs.getInt("notino"));
				nDto.setTit(rs.getString("tit"));
				nDto.setCmtcnt(rs.getInt("cmtcnt"));
				nDto.setRdcnt(rs.getInt("rdcnt"));
				nDto.setRegdt(rs.getTimestamp("regdt"));
				nDto.setAdmnm(rs.getString("admnm"));
				nDto.setCtt(rs.getString("ctt"));
				
				notiList.add(nDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return notiList;
	}

}//class end































