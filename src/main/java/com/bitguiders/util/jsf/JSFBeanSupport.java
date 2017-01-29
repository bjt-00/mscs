package com.bitguiders.util.jsf;


import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import mum.cs545.model.User;


/**
 * @author abdulkareem
 *
 */
public abstract class JSFBeanSupport<E> extends JSFMessageSupport {

	public E e;
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
		setViewAction();
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

	public String performAction(JSFBeanInterface bean,WebConstants.DOMAIN domain,WebConstants.ACTION action){
		setCurrentAction(domain,action);
		switch(action){
		case DELETE:
			this.e=(E) bean.getModel();
			setWarning("Do you really want to delete selected record..?");
		break;
		case DELETE_CONFIRMED:
			bean.delete();
		break;
		case CREATE:
			this.e = (E) bean.getModel();
		break;
		case EDIT:
			this.e = (E) bean.getModel();
		break;
		case SAVE:
			bean.add();
		break;
		case UPDATE:
			bean.update();
		break;
		
		}
		return getView();
	}
	private void setCurrentAction(WebConstants.DOMAIN domain,WebConstants.ACTION currentAction){
		reset();
		this.currentAction = currentAction.getAction();
		this.domain = domain;
		switch(currentAction)
		{
		case CREATE:
			this.pageTitle = currentAction.getPageTitle();
			setView(domain.getFormViewName());
			setCreateAction();
			break;
		case VIEW:
			this.pageTitle ="View";
			setView(domain.getListViewName());
			setViewAction();
			break;
		case EDIT:
			this.pageTitle ="Edit";
			setView(domain.getFormViewName());
			setEditAction();
			break;
		case UPDATE:
			this.pageTitle ="Update";
			setView(domain.getListViewName());
			setUpdateAction();
			break;
		case CANCEL:
			this.pageTitle ="Cancel";
			setView(domain.getListViewName());
			setViewAction();
			break;
		case DELETE_CONFIRMED:
			this.pageTitle ="Delete Confirmed";
			setView(domain.getListViewName());
			setDeleteConfirmedAction();
			break;
		case SAVE:
			this.pageTitle ="Save";
			setView(domain.getListViewName());
			setSaveAction();
			break;
		case DELETE:
			this.pageTitle ="Delete";
			setView(domain.getFormViewName());
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

	/*
	public String getAction() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		String action = request.getParameter("action");
		action = (action != null ? action.trim() : "");
		return action;
	}
	*/
	private String view;
	private WebConstants.DOMAIN  domain;
	public void setView(String viewName) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		request.getSession().setAttribute("viewName", domain.getDomain()+"/"+viewName);
		
		this.view = viewName;
	}
	public String getView(){
		return this.view;
	}
	public WebConstants.DOMAIN getDomain(){
		return this.domain;
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
		setViewAction();
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
		setViewAction();
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
	

}
