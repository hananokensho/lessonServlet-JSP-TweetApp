package model;

import java.io.Serializable;

public class User implements Serializable {
		
	private String name;
	private String pass;
	private String id;

	public User() {}
	
	

	public User(String name, String pass, String id) {
		super();
		this.name = name;
		this.pass = pass;
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
