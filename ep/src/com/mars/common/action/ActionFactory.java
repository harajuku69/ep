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
		} else if(cmd.equals("staff_home_page")){
			action = new StaffHomePageAction();
		} else if(cmd.equals("admin_home_page")){
			action = new AdminHomePageAction();
		} else if(cmd.equals("join_page")){
			action = new JoinPageAction();
		} else if(cmd.equals("chk_id")){
			action = new ChkIdAction();
		} else if(cmd.equals("staff_detail_page")){
			action = new StaffDetailPageAction();
		} else if(cmd.equals("admin_detail_page")){
			action = new AdminDetailPageAction();
		} else if(cmd.equals("staff_update_page")){
			action = new StaffUpdatePageAction();
		} else if(cmd.equals("admin_update_page")){
			action = new AdminUpdatePageAction();
		} else if(cmd.equals("staff_update")){
			action = new StaffUpdateAction();
		} else if(cmd.equals("admin_update")){
			action = new AdminUpdateAction();
		} else if(cmd.equals("zipcd_search")){
			action = new ZipcdSearchAction();
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
