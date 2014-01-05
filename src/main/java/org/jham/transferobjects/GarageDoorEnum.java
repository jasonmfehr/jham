package org.jham.transferobjects;

public enum GarageDoorEnum {
	UP("up"), DOWN("down");
	
	private final String status;
	
	private GarageDoorEnum(String status) {
		this.status = status;
	}
	
	public String toString() {
		return this.status;
	}
}
