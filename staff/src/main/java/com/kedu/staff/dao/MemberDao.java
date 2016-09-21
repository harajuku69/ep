package com.kedu.staff.dao;

//import java.util.ArrayList;

import com.kedu.staff.dto.MemberDto;

public interface MemberDao {
	public String 				getTime();
	public void				 	insertMember(MemberDto dto);
//	public ArrayList<MemberDto> selectAll();
//	public MemberDto			selectByUserId(String userid);
//	public void					updateMember(MemberDto dto);
//	public void					deleteMember(String userid);
}
