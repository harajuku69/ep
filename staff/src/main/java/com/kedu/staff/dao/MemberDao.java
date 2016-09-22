package com.kedu.staff.dao;

//import java.util.ArrayList;

import com.kedu.staff.dto.MemberDto;

public interface MemberDao {
	public String 			getTime();
	public void			 	insertMember(MemberDto dto);
	public MemberDto		readMember(String userid) throws Exception;
	public MemberDto		readWithPW(String userid, String userpw) throws Exception;
}
