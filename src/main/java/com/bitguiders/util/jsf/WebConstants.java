package com.bitguiders.util.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="action")
public class WebConstants {

	//DOMAINS
	public static final String DOMAIN_USER     ="user";
	
	//views 
	public static final String VIEW_USER_FORM ="userForm"; 
	public static final String VIEW_USER_LIST ="usersList"; 
	

	//ACTIONS
	public static final String ACTION_ADD		= "add";
	public static final String ACTION_CREATE	= "create";
	public static final String ACTION_VIEW		= "view";
	public static final String ACTION_EDIT		= "edit";
	public static final String ACTION_DELETE	= "delete";
	public static final String ACTION_SAVE		= "save";
	public static final String ACTION_LAUNCH	= "launch";
	public static final String ACTION_SELECTION	= "selection";
	public static final String ACTION_PARAMETER	= "parameter";
	public static final String ACTION_ASSIGN	= "assign";
	public static final String ACTION_ASSIGN_CONFIRMED	= "assignConfirmed";
	public static final String ACTION_CRUD		= "crud";
	public static final String ACTION_CHANGE_PROFILE_PIC = "changeProfilePic";
	public static final String ACTION_SECURITY = "security";
	public static final String ACTION_LIST		= "list";
	public static final String ACTION_UPLOAD_LOGO = "uploadLogo";

	public static final String ACTION_ADD_USER_TO_GROUP = "addUserToGroup";
	public static final String ACTION_ADD_USER_TO_GROUP_CONFIRMED = "addUserToGroupConfirmed";
	public static final String ACTION_REMOVE_USER_FROM_GROUP = "removeUserFromGroup";
	public static final String ACTION_REMOVE_USER_FROM_GROUP_CONFIRMED = "removeUserFromGroupConfirmed";
	//action for BI
	public static final String ACTION_CREATEDSF	="createDSF";
	
	public static final String ACTION_DELETE_CONFIRMED = "deleteConfirmed";
	public static final String ACTION_UPDATE = "update";
	public static final String ACTION_CANCEL = "cancel";
	public static final String ACTION_NEXT = "next";
	public static final String ACTION_BACK = "back";
	public static final String ACTION_CHANGE_PASSWORD="changePassword";
	public static final String ACTION_FORGOT_PASSWORD="forgotPassword";
	
	public static final String ACTION_TRANSMIT_NOW		="transmitnow";
	public static final String ACTION_ALERTS_REMINDERS_STATUS = "alertsAndRemindersStatus";
	public static final String ACTION_REIMBURSE = "reImburse";
	public static final String ACTION_MESSAGE_TEMPLATE ="messageTemplate";
	public static final String ACTION_SEND ="send";
	public static final String ACTION_SETTINGS = "alertsettings";
	public static final String TAB_DATASOURCES	= "datasources";
	public static final String MENU_DATASET				="dataSet";
	public static final String MENU_CONNECTION			="connection";

	public String getCreate(){
		return ACTION_CREATE;
	}
	public String getDelete(){
		return ACTION_DELETE;
	}
	public String getDeleteConfirmed(){
		return ACTION_DELETE_CONFIRMED;
	}
	public String getEdit(){
		return ACTION_EDIT;
	}
	public String getSave(){
		return ACTION_SAVE;
	}
	public String getCancel(){
		return ACTION_CANCEL;
	}
	public String getUpdate(){
		return ACTION_UPDATE;
	}
	
}
