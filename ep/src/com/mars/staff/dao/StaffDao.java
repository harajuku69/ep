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
import com.mars.staff.dto.CrrDto;
import com.mars.staff.dto.CrtDto;
import com.mars.staff.dto.DptDto;
import com.mars.staff.dto.EduDto;
import com.mars.staff.dto.StaffDto;
import com.mars.staff.dto.TitDto;
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
	
	public List<StaffDto> selectAllStaffByDpt(String dpt){
		String sql = "SELECT s.empnm,d.dpt,t.tit,s.phone,s.empid,s.empno "
					 + "FROM staff s "
					 + "JOIN dpt d "
					   + "ON s.dptcd=d.dptcd "
					 + "JOIN tit t "
					   + "ON s.titcd=t.titcd "
					+ "WHERE d.dpt = ? "
					+ "ORDER BY s.empnm";
		List<StaffDto> staffList = new ArrayList<StaffDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dpt);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				StaffDto sDto = new StaffDto();
				
				sDto.setEmpnm(rs.getString("Empnm"));
				sDto.setDptcd(rs.getString("dpt"));
				sDto.setTitcd(rs.getString("tit"));
				sDto.setPhone(rs.getString("phone"));
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
//			System.out.println(rs.getInt("lastno"));
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
	public List<StaffDto> selectMemberByEmpnm(String empnm) {
		String sql = " SELECT s.empnm,d.dpt,t.tit,NVL(s.phone,' ') as phone,s.empid,s.empno "
					  + "FROM staff s "
					  + "JOIN dpt d "
					    + "ON s.dptcd=d.dptcd "
					  + "JOIN tit t "
					  	+ "ON s.titcd=t.titcd "
					 + "WHERE empnm like '%' || ? || '%' "
					 + "ORDER BY s.empno ";
		List<StaffDto> memberList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empnm);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				StaffDto sDto = new StaffDto();
				
				sDto.setEmpno(rs.getString("empno"));
				sDto.setEmpid(rs.getString("empid"));
				sDto.setEmpnm(rs.getString("empnm"));
				if(rs.getString("phone").length() == 1){
					sDto.setPhone(" ");
				} else{
					sDto.setPhone(rs.getString("phone").substring(0, 3)	+ "-" 
								+ rs.getString("phone").substring(3, 7)	+ "-"
								+ rs.getString("phone").substring(7));
				}
				sDto.setDptcd(rs.getString("dpt"));
				sDto.setTitcd(rs.getString("tit"));
				
				memberList.add(sDto);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
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

	public int checkStaffPwd(String empid, String pwd) {
		String sql = "select pwd from staff where empid=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = 0;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("pwd").equals(pwd)){
					result = 1;
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	public int addEdu(EduDto eDto) {
		String sql = "insert into edu(eduno, empid, loc, school, major, enterdt, graddt) "
							+ "values(eduno_seq.nextval,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, eDto.getEmpid());
			pstmt.setString(2, eDto.getLoc());
			pstmt.setString(3, eDto.getSchool());
			pstmt.setString(4, eDto.getMajor());
			pstmt.setTimestamp(5, eDto.getEnterdt());
			pstmt.setTimestamp(6, eDto.getGraddt());
			
			result = pstmt.executeUpdate();
//			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public List<EduDto> selectAllEdu(String empid) {
		String sql = "select * from edu where empid = ? order by eduno desc";
		List<EduDto> eduList = new ArrayList<>();
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empid);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				EduDto eDto = new EduDto();
				
				eDto.setEduno(rs.getInt("eduno"));
				eDto.setLoc(rs.getString("loc"));
				eDto.setSchool(rs.getString("school"));
				eDto.setMajor(rs.getString("major"));
				eDto.setEnterdt(rs.getTimestamp("enterdt"));
				eDto.setGraddt(rs.getTimestamp("graddt"));
				
				eduList.add(eDto);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return eduList;
	}
	public int deleteEdu(int eduno){
		String sql = "delete edu where eduno=?";
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setInt(1, eduno);
				
			result = pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} 
		return result;
	}

	public int addCrr(CrrDto crDto) {
		String sql = "insert into crr(crrno, empid, comnm, dpt, tit, empdt, outdt) "
							+ "values(crrno_seq.nextval,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, crDto.getEmpid());
			pstmt.setString(2, crDto.getComnm());
			pstmt.setString(3, crDto.getDpt());
			pstmt.setString(4, crDto.getTit());
			pstmt.setTimestamp(5, crDto.getEmpdt());
			pstmt.setTimestamp(6, crDto.getOutdt());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public int deleteCrr(int crrno) {
		String sql = "delete crr where crrno = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, crrno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public List<CrrDto> selectAllCrr(String empid) {
		String sql = "select * from crr where empid = ? order by crrno desc";
		List<CrrDto> crrList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				CrrDto crDto= new CrrDto();

				crDto.setEmpid(empid);
				crDto.setCrrno(rs.getInt("crrno"));
				crDto.setComnm(rs.getString("comnm"));
				crDto.setDpt(rs.getString("dpt"));
				crDto.setTit(rs.getString("tit"));
				crDto.setEmpdt(rs.getTimestamp("empdt"));
				crDto.setOutdt(rs.getTimestamp("outdt"));
				
				crrList.add(crDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return crrList;
	}

	public int addCrt(CrtDto ctDto) {
		String sql = "insert into crt(crtno, empid, crtnm, rank, publ, regdt, expdt) "
							+ "values(crtno_seq.nextval,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctDto.getEmpid());
			pstmt.setString(2, ctDto.getCrtnm());
			pstmt.setString(3, ctDto.getRank());
			pstmt.setString(4, ctDto.getPubl());
			pstmt.setTimestamp(5, ctDto.getRegdt());
			pstmt.setTimestamp(6, ctDto.getExpdt());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public int deleteCrt(int crtno) {
		String sql = "delete crt where crtno = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, crtno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public List<CrtDto> selectAllCrt(String empid) {
		String sql = "select * from crt where empid = ? order by crtno desc";
		List<CrtDto> crtList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				CrtDto ctDto= new CrtDto();

				ctDto.setEmpid(empid);
				ctDto.setCrtno(rs.getInt("crtno"));
				ctDto.setCrtnm(rs.getString("crtnm"));
				ctDto.setRank(rs.getString("rank"));
				ctDto.setPubl(rs.getString("publ"));
				ctDto.setRegdt(rs.getTimestamp("regdt"));
				ctDto.setExpdt(rs.getTimestamp("expdt"));
				
				crtList.add(ctDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return crtList;
	}

	public List<DptDto> selectAllDpt() {
		String sql = "select * from dpt";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<DptDto> dptList = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				DptDto dDto = new DptDto();
				
				dDto.setDpt(rs.getString("dpt"));
				dDto.setDptcd(rs.getString("dptcd"));
				
				dptList.add(dDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dptList;
	}
	
	public List<TitDto> selectAllTit() {
		String sql = "select * from tit";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<TitDto> titList = new ArrayList<>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				TitDto tDto = new TitDto();
				
				tDto.setTit(rs.getString("tit"));
				tDto.setTitcd(rs.getString("titcd"));
				
				titList.add(tDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return titList;
	}

	public int chkJm(String jumin) {
		int result = 0;
		String sql = "select jumin from staff where jumin = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, jumin);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = 1;
			} 
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
}//class end































