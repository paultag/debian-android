package org.anized.deapi;

public class DeAPIException extends Exception {
	private static final long serialVersionUID = 1L;
	
	Exception e;
	String msg;
	
	public DeAPIException(String msg) {
		this.msg = msg;
		this.e = null;
	}
	
	public DeAPIException(Exception e) {
		this.e = e;
		this.msg = "Exception was thrown " + e.toString();
	}
	
	public String toString() {
		return this.msg;
	}
}
