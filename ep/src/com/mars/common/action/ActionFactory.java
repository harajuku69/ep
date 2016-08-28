package com.mars.common.action;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory(){
		super();
	}
	
	public static ActionFactory getInstance(){
		return instance;
	}
	
	public Action getAction(String cmd){
		Action action = null;
		System.out.println("ActionFactory : " + cmd);
		
		if(cmd.equals("index_page")){
			action = new IndexPageAction();
		} else if(cmd.equals("login_page")){
			action = new LoginPageAction();
		} else if(cmd.equals("login")){
			action = new LoginAction();
		}  else if(cmd.equals("join")){
			action = new JoinAction();
		} else if(cmd.equals("join_page")){
			action = new JoinPageAction();
		} else if(cmd.equals("chk_id")){
			action = new ChkIdAction();
		} else if(cmd.equals("staff_detail")){
			action = new StaffDetailAction();
		} else if(cmd.equals("logout")){
			action = new LogoutAction();
		}
		//staff_action
		  else if(cmd.equals("noti_list")){
			action = new NotiListAction();
		}
		//notice_action
		  else if(cmd.equals("pjt_list")){
			action = new PjtListAction();
		}
		//pjt_action
		return action;
	}
}
