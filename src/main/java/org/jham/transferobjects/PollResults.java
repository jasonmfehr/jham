package org.jham.transferobjects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="users", namespace="http://www.github.com/jasonmfehr/jham/pollresults")
public class PollResults {

	private GarageDoorEnum _status;
	
	@XmlElement(name="doorStatus")
	public GarageDoorEnum getDoorStatus() {
		return _status;
	}
	public void setDoorStatus(GarageDoorEnum status) {
		_status = status;
	}
	
}
