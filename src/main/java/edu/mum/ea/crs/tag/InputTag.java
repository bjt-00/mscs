package edu.mum.ea.crs.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class InputTag extends SimpleTagSupport {
	private String value;
	private String id;
	private String name;
	private String type;
	private String clsName;
	private boolean disabled;
	
	@Override
	public void doTag() throws JspException, IOException {	
		super.doTag();
		JspWriter out = getJspContext().getOut();
		StringBuilder sb = new StringBuilder();
		sb.append("<input type=\"").append(type).append("\"");
		if (name != null) sb.append(" name=\"").append(name).append("\"");
		if (id != null) sb.append(" id=\"").append(id).append("\"");
		if (clsName != null) sb.append(" class=\"").append(clsName).append("\"");
		if (disabled) sb.append(" disabled=\"disabled\"");
		if (value != null) sb.append(" value=\"").append(value).append("\"");
		sb.append(" />");
		System.out.println(sb.toString());
	    out.println(sb.toString());
	}		
	
	public void setValue(String value) {
		this.value = value;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}



	public void setType(String type) {
		this.type = type;
	}
	public void setClsName(String clsName) {
		this.clsName = clsName;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
}
