package com.journaldev.jsf.helloworld;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "helloWorld")
@SessionScoped
public class HelloWorld implements Serializable {

	private static final long serialVersionUID = -6913972022251814607L;

	private String string = "Hello World!!";

	public String getString() {
		System.out.println(string);
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

}
