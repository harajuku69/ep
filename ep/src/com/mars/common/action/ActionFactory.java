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
//		staff_action		
		if(cmd.equals("index")){
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
		} else if(cmd.equals("edu_add")){
			action = new EduAddAction();
		} else if(cmd.equals("edu_delete")){
			action = new EduDeleteAction();
		} else if(cmd.equals("crr_add")){
			action = new CrrAddAction();
		} else if(cmd.equals("crr_delete")){
			action = new CrrDeleteAction();
		} else if(cmd.equals("crt_add")){
			action = new CrtAddAction();
		} else if(cmd.equals("crt_delete")){
			action = new CrtDeleteAction();
		} else if(cmd.equals("staff_home_page")){
			action = new StaffHomePageAction();
		} else if(cmd.equals("admin_home_page")){
			action = new AdminHomePageAction();
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
		} else if(cmd.equals("staff_list")){
			action = new StaffListAction();
		} else if(cmd.equals("staff_delete")){
			action = new StaffDeleteAction();
		} else if(cmd.equals("staff_select_member")){
			action = new StaffSelectMemberAction();
		} else if(cmd.equals("admin_select_member")){
			action = new AdminSelectMemberAction();
		} else if(cmd.equals("staff_select_dpt_member")){
			action = new StaffSelectDptMemberAction();
		} else if(cmd.equals("admin_select_dpt_member")){
			action = new AdminSelectDptMemberAction();
		} else if(cmd.equals("check_staff_pwd")){
			action = new CheckStaffPwdAction();
		} else if(cmd.equals("check_pwd_pop")){
			action = new CheckPwdPopAction();
		} else if(cmd.equals("logout")){
			action = new LogoutAction();
		}
//		notice_action
		  else if(cmd.equals("admin_noti_list")){
			action = new AdminNotiListAction();
		} else if(cmd.equals("staff_noti_list")){
			action = new StaffNotiListAction();
		} else if(cmd.equals("admin_noti_detail_page")){
			action = new AdminNotiDetailPageAction();
		} else if(cmd.equals("staff_noti_detail_page")){
			action = new StaffNotiDetailPageAction();
		} else if(cmd.equals("admin_noti_search")){
			action = new AdminNotiSearchAction();	
		} else if(cmd.equals("staff_noti_search")){
			action = new StaffNotiSearchAction();
		} else if(cmd.equals("noti_write_page")){
				action = new NotiWritePageAction();
		} else if(cmd.equals("noti_write")){
			action = new NotiWriteAction();
		} else if(cmd.equals("noti_update_page")){
			action = new NotiUpdatePageAction();
		} else if(cmd.equals("noti_update")){
			action = new NotiUpdateAction();
		} else if(cmd.equals("noti_delete")){
			action = new NotiDeleteAction();
		} else if(cmd.equals("cmt_write")){
			action = new CmtWriteAction();
		} else if(cmd.equals("cmt_delete")){
			action = new CmtDeleteAction();
		}
		//project_action
		  else if(cmd.equals("admin_pjt_list")){
			action = new AdminPjtListAction();
		} else if(cmd.equals("staff_pjt_list")){
			action = new StaffPjtListAction();
		} else if(cmd.equals("admin_pjt_detail")){
//			action = new AdminPjtDetailAction();
		} else if(cmd.equals("pjt_delete")){
			action = new PjtDeleteAction();
		}
		return action;
	}
}
