package com.mars.common.action;

import com.mars.noti.action.AdminNotiDetailPageAction;
import com.mars.noti.action.AdminNotiListAction;
import com.mars.noti.action.AdminNotiSearchAction;
import com.mars.noti.action.CmtDeleteAction;
import com.mars.noti.action.CmtWriteAction;
import com.mars.noti.action.NotiDeleteAction;
import com.mars.noti.action.NotiUpdateAction;
import com.mars.noti.action.NotiUpdatePageAction;
import com.mars.noti.action.NotiWriteAction;
import com.mars.noti.action.NotiWritePageAction;
import com.mars.noti.action.StaffNotiDetailPageAction;
import com.mars.noti.action.StaffNotiListAction;
import com.mars.noti.action.StaffNotiSearchAction;
import com.mars.pjt.action.AdminPjtDetailPageAction;
import com.mars.pjt.action.AdminPjtListAction;
import com.mars.pjt.action.DeleteMemberAction;
import com.mars.pjt.action.InsertMemberAction;
import com.mars.pjt.action.PjtDeleteAction;
import com.mars.pjt.action.PjtUpdatePageAction;
import com.mars.pjt.action.PjtWriteAction;
import com.mars.pjt.action.PjtWritePageAction;
import com.mars.pjt.action.PlDetailAction;
import com.mars.pjt.action.SelectMemberAction;
import com.mars.pjt.action.StaffPjtListAction;
import com.mars.staff.action.AdminDetailPageAction;
import com.mars.staff.action.AdminHomePageAction;
import com.mars.staff.action.AdminSelectDptMemberAction;
import com.mars.staff.action.AdminSelectMemberAction;
import com.mars.staff.action.AdminUpdateAction;
import com.mars.staff.action.AdminUpdatePageAction;
import com.mars.staff.action.CheckIdAction;
import com.mars.staff.action.CheckJuminAction;
import com.mars.staff.action.CheckStaffPwdAction;
import com.mars.staff.action.CrrAddAction;
import com.mars.staff.action.CrrDeleteAction;
import com.mars.staff.action.CrtAddAction;
import com.mars.staff.action.CrtDeleteAction;
import com.mars.staff.action.EduAddAction;
import com.mars.staff.action.EduDeleteAction;
import com.mars.staff.action.JoinAction;
import com.mars.staff.action.LoginAction;
import com.mars.staff.action.LogoutAction;
import com.mars.staff.action.StaffDeleteAction;
import com.mars.staff.action.StaffDetailPageAction;
import com.mars.staff.action.StaffHomePageAction;
import com.mars.staff.action.StaffListAction;
import com.mars.staff.action.StaffSelectDptMemberAction;
import com.mars.staff.action.StaffSelectMemberAction;
import com.mars.staff.action.StaffUpdateAction;
import com.mars.staff.action.StaffUpdatePageAction;
import com.mars.staff.action.ZipcdSearchAction;

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
		
//		common_action
		if(cmd.equals("index")){
			action = new IndexAction();
		} else if(cmd.equals("login_page")){
			action = new LoginPageAction();
		} else if(cmd.equals("join_page")){
			action = new JoinPageAction();
			
//		staff_action		
		} else if(cmd.equals("login")){
			action = new LoginAction();
		}  else if(cmd.equals("join")){
			action = new JoinAction();
		} else if(cmd.equals("check_id")){
			action = new CheckIdAction();
		} else if(cmd.equals("check_jumin")){
			action = new CheckJuminAction();
		} else if(cmd.equals("check_staff_pwd")){
			action = new CheckStaffPwdAction();
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
		
//		project_action
		  else if(cmd.equals("admin_pjt_list")){
			action = new AdminPjtListAction();
		} else if(cmd.equals("staff_pjt_list")){
			action = new StaffPjtListAction();
		} else if(cmd.equals("admin_pjt_detail_page")){
			action = new AdminPjtDetailPageAction();
		} else if(cmd.equals("pjt_update_page")){
			action = new PjtUpdatePageAction();
		} else if(cmd.equals("pjt_write_page")){
			action = new PjtWritePageAction();
		} else if(cmd.equals("pjt_write")){
			action = new PjtWriteAction();
		} else if(cmd.equals("pjt_delete")){
			action = new PjtDeleteAction();
		} else if(cmd.equals("pl_detail")){
			action = new PlDetailAction();
		} else if(cmd.equals("select_member")){
			action = new SelectMemberAction();
		} else if(cmd.equals("insert_member")){
			action = new InsertMemberAction();
		} else if(cmd.equals("delete_member")){
			action = new DeleteMemberAction();
		}
		return action;
	}
}
