package com.bitguiders.util.jsf;

import java.util.List;

public interface JSFBeanInterface<E> {

	public String actionListener(String action,E e);
	public List<E> getList();
}
