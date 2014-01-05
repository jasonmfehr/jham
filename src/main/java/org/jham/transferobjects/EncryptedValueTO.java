package org.jham.transferobjects;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name="users", namespace="http://www.github.com/jasonmfehr/jham/encryption")
public class EncryptedValueTO {
	//private String str;
	//private Integer test1;
	private List<Integer> value;
	
	@XmlElement(name="value")
 	@JsonProperty("value")
	public List<Integer> getValue() {
		return this.value;
	}
	public void setValue(List<Integer> value) {
		this.value = value;
	}

	/*
	@XmlElement(name="str")
 	@JsonProperty("str")
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	@XmlElement(name="test1")
	@JsonProperty("test1")
	public Integer getTest1() {
		return this.test1;
	}
	public void setTest1(Integer test1) {
		this.test1 = test1;
	}
	*/
	
	/*
	private List<Integer> _value;

 	@XmlElement(name="value")
 	@JsonProperty("value")
	public List<Integer> getValue() {
		return _value;
	}
	public void setValue(List<Integer> value) {
		this._value = value;
	}
	*/
	
}
