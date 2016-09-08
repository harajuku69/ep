package com.mars.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.mars.common.action.Paging;
import com.mars.common.db.DBManager;
import com.mars.staff.dto.StaffDto;
import com.mars.staff.dto.ZipDto;

public class StaffDao {
	
	private StaffDao() {
	}

	private static StaffDao instance = new StaffDao();
	
	public static StaffDao getInstance(){
		if(instance == null){
			instance = new StaffDao();
		}
		return instance;
	}
	
	public int loginChk(String empid, String pwd){
		int result = -1;
		String sql = "select pwd from staff where empid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("pwd") != null && rs.getString("pwd").equals(pwd)){
					result = 1;
				} else{
					result = 0;
				}
			} else{
				result = -1;
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public void updateLogdt(String empid, String lastdt){
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
		String logdt = date.format(new Date());
		String sql = "update staff set lastdt=?, logdt=? where empid=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1,lastdt);	
			pstmt.setString(2,logdt);
			pstmt.setString(3,empid);
			
			pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	public int chkId(String empid){
		int result = 0;
		String sql = "select empid from staff where empid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, empid);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = 1;
			} else{
				result = 0;//id와 같은 id가 리턴되지 않았을 때
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public StaffDto selectOneByEmpid(String empid){
		StaffDto sDto = new StaffDto();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT s.empnm, s.empid, s.empno, s.jumin, s.pic, "
						  + "s.zipcd, s.addr, s.addrdtl, s.sal, s.startdt, "
						  + "s.enddt, s.regdt, s.admchk, d.dpt, t.tit, s.phone, "
						  + "s.pwd, s.admnm, s.lastdt, s.logdt "
					 + "FROM STAFF s "
					 + "JOIN dpt d "
					   + "ON s.dptcd=d.dptcd "
					 + "JOIN tit t "
					   + "ON s.titcd=t.titcd "
					+ "WHERE s.empid=?";
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empid);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				sDto.setEmpid(rs.getString("empid"));
				sDto.setPwd(rs.getString("pwd"));
				sDto.setEmpno(rs.getString("empno"));
				sDto.setEmpnm(rs.getString("empnm"));
				sDto.setPhone(rs.getString("phone"));
				sDto.setJumin(rs.getString("jumin"));
				sDto.setPic(rs.getString("pic"));
				sDto.setZipcd(rs.getString("zipcd"));
				sDto.setAddr(rs.getString("addr"));
				sDto.setAddrdtl(rs.getString("addrdtl"));
				sDto.setDptcd(rs.getString("dpt"));
				sDto.setTitcd(rs.getString("tit"));
				sDto.setSal(Integer.parseInt(rs.getString("sal")));
				sDto.setStartdt(rs.getTimestamp("startdt"));
				sDto.setEnddt(rs.getTimestamp("enddt"));
				sDto.setRegdt(rs.getTimestamp("regdt"));
				sDto.setLastdt(rs.getString("lastdt"));
				sDto.setLogdt(rs.getString("logdt"));
				sDto.setAdmchk(rs.getInt("admchk"));
				sDto.setAdmnm(rs.getString("admnm"));
//				System.out.println("Dao안에서 찍음 : "+sDto.getJumin());
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return sDto;
	}
	
	public List<StaffDto> selectAllStaffByDpt(){
		String sql = "select empnm, empid, dptcd, titcd, email, phone from Staff where dptcd=?"; 

		List<StaffDto> list = new ArrayList<StaffDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				StaffDto sDto = new StaffDto();
				
				/*sDto.setNo(rs.getInt("no"));
				sDto.setEmpnm(rs.getString("Empnm"));
				sDto.setEmpemail(rs.getString("Empemail"));
				sDto.setEmppwd(rs.getString("Emppwd"));*/
				
				list.add(sDto);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int insertStaff(StaffDto sDto){
		String empno = createEmpno();
		String sql = "insert into staff(empnm, jumin, empid, pwd, empno) values(?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sDto.getEmpnm());
			pstmt.setString(2, sDto.getJumin());
			pstmt.setString(3, sDto.getEmpid());
			pstmt.setString(4, sDto.getPwd());
			pstmt.setString(5, empno);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public String createEmpno() {
		StringBuilder empno = new StringBuilder();
		
		SimpleDateFormat date = new SimpleDateFormat("yyyyMM");
		String curMM = date.format(new Date());
		
		String sql = "select lastno from empno_mg";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int lastno = 0;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getInt("lastno"));
			if(rs.getInt("lastno") != 9999){
				lastno=rs.getInt("lastno") + 1;
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
		
		sql = "update empno_mg set lastno=?";
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lastno);
			pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
		
		if(lastno > 999){
			empno.append(curMM + Integer.toString(lastno));
		} else if( 99 < lastno && lastno <= 999){
			empno.append(curMM + "0" + Integer.toString(lastno));
		} else if( 9 < lastno && lastno <= 99){
			empno.append(curMM + "00" + Integer.toString(lastno));
		} else if( lastno <= 9){
			empno.append(curMM + "000" + Integer.toString(lastno));
		}
//		System.out.println(empno.toString());
		return empno.toString();
	}

	public void updateStaffIndInfo(StaffDto sDto){
//		StringBuilder sql = new StringBuilder();
//		sql.append("update staff");
//		sql.append(" set phone=" + sDto.getPhone());
//		sql.append(" , pic=" + sDto.getPic());
////		sql.append(" , addr=" + sDto.getAddr()); 
////		sql.append(" , addrdtl=" + sDto.getAddrdtl());
//		sql.append(" where empid=" + sDto.getEmpid());
////		sql.append(" , pwd=" + sDto.getPwd());
////		sql.append(" , zipcd=" + sDto.getZipcd());
		
		String sql = "update staff set phone=?, pic=?, zipcd=?, addr=?, addrdtl=? where empid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
//		int result = -1;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, sDto.getPhone());
			pstmt.setString(2, sDto.getPic());
			pstmt.setString(3, sDto.getZipcd());
			pstmt.setString(4, sDto.getAddr());
			pstmt.setString(5, sDto.getAddrdtl());
			pstmt.setString(6, sDto.getEmpid());	
			pstmt.executeUpdate();
//			result = pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
//		return result;
	}
	
	public void updateStaffEmpInfo(StaffDto sDto){
//		StringBuilder sql = new StringBuilder();
//		sql.append("update staff");
//		sql.append(" set dptcd=" + sDto.getDptcd());
//		sql.append(" , titcd=" + sDto.getTitcd());
//		sql.append(" , sal=" + sDto.getSal());
//		sql.append(" , startdt=" + sDto.getStartdt()); 
//		sql.append(" , enddt=" + sDto.getEnddt());
//		sql.append(" where empid=" +sDto.getEmpid());
		String sql = "update staff set dptcd=?,titcd=?,sal=?,startdt=?,enddt=?,admchk=? where empid=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
//		int result = -1;
		
		try{
			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement(sql.toString());
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sDto.getDptcd());
			pstmt.setString(2, sDto.getTitcd());
			pstmt.setInt(3, sDto.getSal());
			pstmt.setTimestamp(4, sDto.getStartdt());
			pstmt.setTimestamp(5, sDto.getEnddt());
			pstmt.setInt(6, sDto.getAdmchk());
			pstmt.setString(7, sDto.getEmpid());
			pstmt.executeUpdate();
//			result = pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
//		return result;
	}
		
	public int deleteStaff(String empno){
		String sql = "delete staff where empno=?";
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, empno);
				
			result = pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} 
		return result;
	}

	public List<ZipDto> selectZipcdListByKwd(String kwd) {
//		String sql = "select * from zip where dong like '%'|| ? ||'%'";
		String sql = "select no, zipcd, sido, gugun, dong, NVL(bunji,' ') as bunji from zip where dong like '%'|| ? ||'%'";
		List<ZipDto> zipcdList = new ArrayList<ZipDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kwd);
//			System.out.println("Dao 에서 kwd : " + kwd);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ZipDto zDto = new ZipDto();
				
				zDto.setNo(rs.getString("no"));
				zDto.setZipcd(rs.getString("zipcd"));
				zDto.setSido(rs.getString("sido"));
				zDto.setGugun(rs.getString("gugun"));
				zDto.setDong(rs.getString("dong"));
				zDto.setBunji(rs.getString("bunji"));
//				System.out.println("selectZipcdListByKwd()가 DB에서 가져온 값 : " + zDto);
				zipcdList.add(zDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return zipcdList;
	}

	public List<StaffDto> selectStaffList(String sttRecNo, String endRecNo) {
		String sql = "SELECT s.empnm,d.dpt,t.tit,s.phone,s.empid,s.empno "
					 + "FROM ("
					 		+ "SELECT ROWNUM R, a.* "
						     + " FROM ( "
						     		 + "SELECT empnm,dptcd,titcd,phone,empid,empno "
									   + "FROM staff ORDER BY empnm "
									+ ") a "
						   + ") s "
					 + "JOIN dpt d "
					   + "ON s.dptcd=d.dptcd "
					 + "JOIN tit t "
					   + "ON s.titcd=t.titcd "
					+ "WHERE R BETWEEN ? AND ? "
					+ "ORDER BY s.empnm";
		List<StaffDto> staffList = new ArrayList<StaffDto>();

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
				StaffDto sDto = new StaffDto();
				
				sDto.setEmpnm(rs.getString("empnm"));
				sDto.setDptcd(rs.getString("dpt"));
				sDto.setTitcd(rs.getString("tit"));
				sDto.setPhone(rs.getString("Phone"));
				sDto.setEmpid(rs.getString("empid"));
				sDto.setEmpno(rs.getString("empno"));
				
				staffList.add(sDto);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return staffList;
	}

	public List<StaffDto> selectMemberByEmpnm(String empnm, String sttRecNo, String endRecNo) {
		String sql = " SELECT s.empnm,d.dpt,t.tit,s.phone,s.empid,s.empno "
					  + "FROM ( "
					  		  + "SELECT ROWNUM R, a.* "
					  		    + "FROM ( "
					  		    		+ "SELECT empnm,dptcd,titcd,phone,empid,empno "
					  		    		  + "FROM staff "
					  		    		 + "WHERE empnm like '%' || ? || '%' "
					  		    		 + "ORDER BY empnm "
					  		    	  + ") a "
					  		+ ") s "
					  + "JOIN dpt d "
					    + "ON s.dptcd=d.dptcd "
					  + "JOIN tit t "
					  	+ "ON s.titcd=t.titcd "
					 + "WHERE R BETWEEN ? AND ? "
					 + "ORDER BY s.empno ";
		List<StaffDto> memberList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empnm);
			pstmt.setString(2, sttRecNo);
			pstmt.setString(3, endRecNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				StaffDto sDto = new StaffDto();
				
				sDto.setEmpid(rs.getString("empid"));
				sDto.setEmpno(rs.getString("empno"));
				sDto.setEmpnm(rs.getString("empnm"));
				sDto.setPhone(rs.getString("phone"));
				sDto.setDptcd(rs.getString("dpt"));
				sDto.setTitcd(rs.getString("tit"));
				
//				System.out.println(sDto);
				memberList.add(sDto);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
//		System.out.println(memberList);
		return memberList;
	}

	public void changeAdmstat(String empid, int admstat) {
		String sql = "update staff set admstat=? where empid=?";
		int toStat = admstat;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setInt(1,toStat);	
			pstmt.setString(2, empid);
			
			pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
	}
}//class end































