package com.mars.pjt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mars.common.db.DBManager;
import com.mars.pjt.dto.PjtDto;
import com.mars.pjt.dto.PmDto;
import com.mars.pjt.dto.PskDto;

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
		String sql = "SELECT p.pjtno, p.pjtnm, p.pjtdtl, p.startdt, p.enddt, p.regdt, p.plno, s.empnm "
				 	 + "FROM ("
				 	 		+ "SELECT ROWNUM R, a.* "
				 	 		 + " FROM ( "
				 	 		 		  + "SELECT * "
				 	 		 		    + "FROM pjt ORDER BY pjtno desc "
				 	 		 	    + ") a "
				 	 	   + ") p "
				 	+ " JOIN staff s "
				 	  + " ON p.plno =s.empno "
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
				pDto.setPlno(rs.getString("plno"));
				
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

	public void regPjt(PjtDto pDto) {
		String sql = "insert into pjt(pjtno, pjtnm, pjtdtl, startdt, enddt, plno) "
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
			pstmt.setString(5, pDto.getPlno());
			
			pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
	}

	public void regPjtSkl(PskDto pskDto) {
		String sql = "insert into psk(pskno, pjtno, sklist) "
				+ "values(pskno_seq.nextval,pjtno_seq.currval,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, pskDto.getSkList().toString());
		
		pstmt.executeUpdate();
		} catch(SQLException e){
		e.printStackTrace();
		} finally{
		DBManager.close(conn, pstmt);
		}
	}

	public void regPjtMember(PmDto pmDto) {
		String sql = "insert into pm(pjtno, empno, rolecd) "
					+ "values(pjtno_seq.currval,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pmDto.getEmpno());
			pstmt.setString(2, pmDto.getRole());
			
			pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
	}

	public PjtDto selectOneByPjtno(int pjtno) {
		String sql = "select p.pjtno,p.pjtnm,p.pjtdtl,p.startdt,p.enddt,p.regdt,s.empnm "
					 + "from pjt p "
					 + "join staff s "
					   + "on p.plno=s.empno "
					+ "where pjtno=?";
		
		PjtDto pDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setInt(1, pjtno);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				pDto = new PjtDto();
				
				pDto.setPjtno(rs.getInt("pjtno"));
				pDto.setPjtnm(rs.getString("pjtnm"));
				pDto.setPjtdtl(rs.getString("pjtdtl"));
				pDto.setStartdt(rs.getTimestamp("startdt"));
				pDto.setEnddt(rs.getTimestamp("enddt"));
				pDto.setRegdt(rs.getTimestamp("regdt"));
				pDto.setPlnm(rs.getString("empnm"));
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return pDto;
	}

	public List<PmDto> selectAllPjtMember(int pjtno) {
		String sql = "select p.pjtno, p.empno, s.empnm, d.dpt, t.tit, r.role "
					 + "from pm p "
					 + "join staff s "
					 + "  on p.empno = s.empno "
					 + "join dpt d "
					 + "  on s.dptcd = d.dptcd "
					 + "join tit t "
					 + "  on s.titcd = t.titcd "
					 + "join role r "
					 + "  on p.rolecd = r.rolecd "
					+ "where p.pjtno = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<PmDto> pmList = new ArrayList<>();
		try{
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setInt(1, pjtno);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				PmDto pDto = new PmDto();
				
				pDto.setPjtno(rs.getInt("pjtno"));
				pDto.setEmpno(rs.getString("empno"));
				pDto.setMemnm(rs.getString("empnm"));
				pDto.setDpt(rs.getString("dpt"));
				pDto.setTit(rs.getString("tit"));
				pDto.setRole(rs.getString("role"));
				
				pmList.add(pDto);
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return pmList;
	}

	public String selectPjtSkByPjtno(int pjtno) {
		String sql = "select sklist from psk where pjtno = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sklist = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pjtno);
			rs = pstmt.executeQuery();
			if(rs.next()){
				sklist = rs.getString("sklist");
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return sklist;
	}

	public PskDto selectSkNm(String skcd) {
		String sql = "select sk from skl where skcd = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		List<PskDto> skList = new ArrayList<>();
		PskDto psDto = new PskDto();
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, skcd);
			rs = pstmt.executeQuery();
			if(rs.next()){
				psDto.setSk(rs.getString("sk"));
				
//				skList.add(psDto);
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return psDto;
	}
}


























