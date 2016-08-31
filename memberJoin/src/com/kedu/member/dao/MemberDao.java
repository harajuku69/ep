package com.kedu.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.kedu.member.dto.MemberDto;

public class MemberDao {
	public MemberDao() {
		
	}
	
	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance(){
		return instance;
	}
	
	public Connection getConnection() throws Exception{
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/memberJoin");
		conn = ds.getConnection();
		return conn;
	}
	
	public int userCheck(String userid, String pwd){
		int result = -1;
		String sql = "select pwd from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
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
			try{
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public MemberDto getMember(String userid){
		MemberDto memberDto = null;
		String sql = "select * from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				memberDto = new MemberDto();
				memberDto.setName(rs.getString("name"));
				memberDto.setUserid(rs.getString("userid"));
				memberDto.setPwd(rs.getString("pwd"));
				memberDto.setEmail(rs.getString("email"));
				memberDto.setPhone(rs.getString("phone"));
				memberDto.setAdmin(rs.getInt("admin"));
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return memberDto;
	}	
	
	public int confirmID(String userid){
		int result = -1;
		String sql = "select userid from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = 1;
			} else{
				result = -1;//id와 같은 id가 리턴되지 않았을 때
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int insertMember(MemberDto memberDto){
		int result = -1;
		String sql = "insert into member values(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberDto.getName());
			pstmt.setString(2, memberDto.getUserid());
			pstmt.setString(3, memberDto.getPwd());
			pstmt.setString(4, memberDto.getEmail());
			pstmt.setString(5, memberDto.getPhone());
			pstmt.setInt(6, memberDto.getAdmin());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try{
				if(pstmt != null){
					pstmt.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateMember(MemberDto memberDto){
		int result = -1;
		String sql = "update member set pwd=?, email=?," 
					+ "phone=?, admin=? where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberDto.getPwd());
			pstmt.setString(2, memberDto.getEmail());
			pstmt.setString(3, memberDto.getPhone());
			pstmt.setInt(4, memberDto.getAdmin());
			pstmt.setString(5, memberDto.getUserid());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try{
				if(pstmt != null){
					pstmt.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
}





















