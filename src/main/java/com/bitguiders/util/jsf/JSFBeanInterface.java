package com.bitguiders.util.jsf;

import java.util.List;

public abstract interface JSFBeanInterface<E> {

	public String actionListener(WebConstants.ACTION action,E e);
	public List<E> getList();
	public E getModel();
	public void setModel(E e);
	 void add();
	 void update();
	 void delete();
}
