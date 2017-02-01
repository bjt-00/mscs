package mum.cs545.service;

import java.util.List;

public abstract interface GenericService<Model> {

	 void add(Model model);
	 void update(Model model);
	 void delete(Model model);
	 public List<Model> getList();

}
