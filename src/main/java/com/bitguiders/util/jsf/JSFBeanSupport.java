package com.bitguiders.util.jsf;


import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


/**
 * @author abdulkareem
 *
 */
public abstract class JSFBeanSupport {

	private boolean isCreateAction;
	private boolean isDeleteAction;
	private boolean isListAction;
	
	private boolean isCancelAction;
	private boolean isSaveAction;
	private boolean isUpdateAction;
	private boolean isEditAction;
	private boolean isDisabled;
	private String rowid;
	private String currentAction;
	private boolean isSendAction;
	private boolean isDeleteConfirmedAction;
	private boolean isResetAction;
	private boolean isAddRuleAction;
	// create action for BI
	private boolean isCreateDSFAction;
	
	private String pageTitle;
	private Integer id;


	public JSFBeanSupport(){
		isCreateAction=true;
		isCancelAction=true;
		isUpdateAction=true;
		isDeleteAction=true;
		isDeleteConfirmedAction=true;
		isSaveAction = true;
		isSendAction = true;
		this.isEditAction = true;
		isDisabled = false;
		isAddRuleAction = true;
		
	}
	

	public boolean isCreateAction() {
		return isCreateAction;
	}

	public void setCreateAction() {
		this.isCreateAction = true;
		this.isCancelAction = true;
		this.isSaveAction = true;
		this.isDisabled = false;
		this.isResetAction = true;
		
	}

	public boolean isDeleteAction() {
		return isDeleteAction;//getStyle(isDeleteAction);
	}

	public void setDeleteAction() {
		this.isDeleteAction = true;
		this.isDeleteConfirmedAction = true;
		this.isCancelAction = true;
		this.isDisabled = true;
	}

	public boolean isDeleteConfirmedAction() {
		return isDeleteConfirmedAction;//getStyle(isDeleteConfirmedAction);
	}

	public void setDeleteConfirmedAction() {
		this.isDeleteConfirmedAction = true;
		this.isCancelAction = true;
	}

	public String getPageTitle(){
		return this.pageTitle;
	}
	public void setViewAction() {
		this.isCancelAction = true;
		this.isDeleteAction = true;
		this.isDisabled = true;
		this.isSendAction = true;
		this.isEditAction = true;
		this.isAddRuleAction = false;
	}

	public void setEditAction() {
		this.isEditAction = true;
		this.isUpdateAction = true;
		this.isCancelAction = true;
		this.isDisabled = false;
		this.isResetAction = true;
	}
	public boolean isEditAction(){
		return this.isEditAction;
	}
	public boolean isDisabled() {
		return isDisabled;
	}
	public void setDisabled(boolean isDisabled) {
		 this.isDisabled = isDisabled;
	}


	public String getCurrentAction() {
		return (currentAction!=null?currentAction:"");
	}

	
	public void setCurrentAction(String currentAction){
		reset();
		this.currentAction = currentAction;
		switch(this.currentAction)
		{
		case WebConstants.ACTION_CREATE:
			this.pageTitle ="Create";
			setCreateAction();
			break;
		case WebConstants.ACTION_VIEW:
			this.pageTitle ="View";
			setViewAction();
			break;
		case WebConstants.ACTION_EDIT:
			this.pageTitle ="Edit";
			setEditAction();
			break;
		case WebConstants.ACTION_UPDATE:
			this.pageTitle ="Update";
			setUpdateAction();
			break;
		case WebConstants.ACTION_CANCEL:
			this.pageTitle ="Cancel";
			break;
		case WebConstants.ACTION_DELETE_CONFIRMED:
			this.pageTitle ="Delete Confirmed";
			setDeleteConfirmedAction();
			break;
		case WebConstants.ACTION_SAVE:
			this.pageTitle ="Save";
			setSaveAction();
			break;
		case WebConstants.ACTION_DELETE:
			this.pageTitle ="Delete";
			setDeleteAction();
			break;
		}
	}

	public void reset(){
		  isCreateAction = false;
		  isDeleteAction = false;
		  isListAction	 = false;
		  isCreateDSFAction = false;
		  isSaveAction = false;
		  isUpdateAction = false;
		  this.isDeleteConfirmedAction = false;
		  isDisabled = true;
		  isResetAction = false;
		  setRowid("");
		  currentAction="";
		  isSendAction= false;
		  this.isEditAction = false;
		  isAddRuleAction = false;
	}

	
	public String getAction() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		String action = request.getParameter("action");
		action = (action != null ? action.trim() : "");
		return action;
	}
	
	public String getSelectedApplication() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		String app = request.getParameter("app");
		app = (app != null ? app.trim() : "");
		return app;
	}
	
	public String getParameter(String x) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		String action = request.getParameter(x);
		action = (action != null ? action.trim() : "");
		
		
		return action;
	}

	public boolean isListAction() {
		return isListAction;
	}

	public void setListAction(boolean isListAction) {
		this.isListAction = isListAction;
	}

	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}

	public boolean isSendAction() {
		return isSendAction;
	}

	public void setSendAction(boolean isSendAction) {
		this.isSendAction = isSendAction;
	}

	public boolean isCreateDSFAction() {
		return isCreateDSFAction;
	}

	public void setCreateDSFAction(boolean isCreateDSFAction) {
		this.isCreateDSFAction = isCreateDSFAction;
	}

	public boolean isCancelAction() {
		return isCancelAction;
	}

	public void setCancelAction(boolean isCancelAction) {
		this.isCancelAction = isCancelAction;
	}

	public void setUpdateAction() {
		this.isCancelAction = true;
		this.isUpdateAction = true;
	}
	public boolean isUpdateAction() {
		return isUpdateAction;
	}

	public boolean isSaveAction() {
		return isSaveAction;
	}

	public void setSaveAction() {
		this.isSaveAction = true;
		this.isCancelAction = true;
	}
	public boolean isResetAction() {
		return isResetAction;
	}
	public void setResetAction(boolean isReset) {
		this.isResetAction = isReset;
	}
	public int getId() {
		return (id!=null?id.intValue():0);
	}
	public void setId(int id){
		this.id=id;
	}
	
	public void setMessage(String message){
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("message", message);
	}

}
