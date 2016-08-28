package com.kedu.member.controller;

import com.kedu.common.action.Action;
import com.kedu.common.action.MemberDeleteAction;
//import com.kedu.common.action.BoardCheckPassAction;
//import com.kedu.common.action.BoardCheckPassFormAction;
//import com.kedu.common.action.BoardDeleteAction;
import com.kedu.common.action.MemberListAction;
//import com.kedu.common.action.BoardUpdateAction;
//import com.kedu.common.action.BoardUpdateFormAction;
//import com.kedu.common.action.BoardViewAction;
import com.kedu.common.action.MemberInsertAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory(){
		super();
	}
	
	public static ActionFactory getInstance(){
		return instance;
	}
	
	public Action getAction(String command){
		Action action = null;
		System.out.println("ActionFactory : " + command);
		if(command.equals("member_list")){
			action = new MemberListAction();
		} else if(command.equals("member_insert")){
			action = new MemberInsertAction();
		} else if(command.equals("member_delete")){
			action = new MemberDeleteAction();
		}
		return action;
	}
}
