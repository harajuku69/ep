package com.mars.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mars.common.db.DBManager;
import com.mars.staff.dto.StaffDto;

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
	
	public int loginCheck(String empid, String pwd){
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
		
		String sql = "select * from staff where empid=?";
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
				sDto.setEmail(rs.getString("email"));
				sDto.setPhone(rs.getString("phone"));
				sDto.setJumin(rs.getString("jumin"));
				sDto.setPic(rs.getString("pic"));
				sDto.setZipcd(rs.getString("zipcd"));
				sDto.setAddr(rs.getString("addr"));
				sDto.setAddrdtl(rs.getString("addrdtl"));
				sDto.setDpt(rs.getString("dpt"));
				sDto.setTit(rs.getString("tit"));
				sDto.setSal(Integer.parseInt(rs.getString("sal")));
				sDto.setStartdt(rs.getTimestamp("startdt"));
				sDto.setEnddt(rs.getTimestamp("enddt"));
				sDto.setRegdt(rs.getTimestamp("regdt"));
				sDto.setLastdt(rs.getString("lastdt"));
				sDto.setLogdt(rs.getString("logdt"));
				sDto.setAdmchk(rs.getString("admchk"));
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return sDto;
	}
	
	public List<StaffDto> selectAllStaffByDpt(){
		List<StaffDto> list = new ArrayList<StaffDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select empnm, empid, dpt, tit, phone from Staff where dpt=?"; 
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
		
		String sql = "select lastno from epno";
		
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
		
		sql = "update epno set lastno=?";
		
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
		System.out.println(empno.toString());
		return empno.toString();
	}

	public int updateStaff(StaffDto sDto){
		StringBuilder sql = new StringBuilder();
		sql.append("update staff");
		sql.append(" set empnm=" + sDto.getEmpnm());
		sql.append(" , email=" + sDto.getEmail()); 
		sql.append(" , pwd=" + sDto.getPwd());
		sql.append(" where empid=?");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = -1;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
				
			pstmt.setString(1, sDto.getEmpid());	
			
			result = pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
		
	public int deleteStaff(int no){
		StringBuilder sql = new StringBuilder();
		sql.append("delete Staffex");
		sql.append(" where no=?");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = -1;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
				
			pstmt.setInt(1, no);
				
			result = pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} 
		return result;
	}
}//class end































