package com.kedu.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kedu.common.db.DBManager;
import com.kedu.member.dto.MemberDto;

public class MemberDao {
	private static MemberDao instance = new MemberDao();

	private MemberDao() {
	}
	
	public static MemberDao getInstance(){
		if(instance == null){
			instance = new MemberDao();
		}
		return instance;
	}
	
	public List<MemberDto> selectAllMembers(){
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from memberex"; /*order by no desc*/
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				MemberDto mDto = new MemberDto();
				
				mDto.setNo(rs.getInt("no"));
				mDto.setMemnm(rs.getString("memnm"));
				mDto.setMememail(rs.getString("mememail"));
				mDto.setMempwd(rs.getString("mempwd"));
				
				list.add(mDto);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public MemberDto selectOneMemberByNo(int no){
		
		MemberDto mDto = new MemberDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from memberex ");
		sql.append("where no=?");
		
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				mDto = new MemberDto();
				
				mDto.setNo(rs.getInt("no"));
				mDto.setMemnm(rs.getString("memnm"));
				mDto.setMememail(rs.getString("mememail"));
				mDto.setMempwd(rs.getString("mempwd"));
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		return mDto;
	}
	
	public int updateMember(MemberDto mDto){
		StringBuilder sql = new StringBuilder();
		sql.append("update memberex");
		sql.append(" set memnm=" + mDto.getMemnm());
		sql.append(" , mememail=" + mDto.getMememail()); 
		sql.append(" , mempwd=" + mDto.getMempwd());
		sql.append(" where no=?");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = -1;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
				
			pstmt.setInt(1, mDto.getNo());	
			
			result = pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public int insertMember(MemberDto mDto){
		StringBuilder sql = new StringBuilder();
		sql.append("insert into memberex");
		sql.append(" values( memberex_no_seq.nextval ");
		sql.append(" , ?");
		sql.append(" , ?");
		sql.append(" , ?");
		sql.append(")");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = -1;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, mDto.getMemnm());
			pstmt.setString(2, mDto.getMememail());
			pstmt.setString(3, mDto.getMempwd());
			
			result = pstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public int deleteMember(int no){
		StringBuilder sql = new StringBuilder();
		sql.append("delete memberex");
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
	
	public boolean checkPassWord(String pwd, int no){
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select pwd from memberex");
		sql.append(" where 1 = 1");
		sql.append(" and no = ?");
		sql.append(" and mpwd = ?");

		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, no);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result=true;
			} else{
				result = false;
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	@SuppressWarnings("resource")
	public MemberDto lastInsert(){
		MemberDto mDto = new MemberDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int lastSeq = 0;
		
		StringBuilder lastsql = new StringBuilder();
		lastsql.append("select memberex_no_seq.currval as lastseq from dual ");
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from memberex where no = ? ");
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(lastsql.toString());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				lastSeq = rs.getInt("lastseq");
			}
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, lastSeq);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				mDto.setNo(rs.getInt("no"));
				mDto.setMemnm(rs.getString("memnm"));
				mDto.setMememail(rs.getString("mememail"));
				mDto.setMempwd(rs.getString("mempwd"));
			}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally{
				DBManager.close(conn, pstmt, rs);
		}
		return mDto;
	}
}//class end































