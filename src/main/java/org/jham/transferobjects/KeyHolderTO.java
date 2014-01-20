package org.jham.transferobjects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="users", namespace="http://www.github.com/jasonmfehr/jham/keyholder")
public class KeyHolderTO {

	@XmlElement(name="key")
	private Integer key;
	
    public KeyHolderTO() {
        
    }
    
    public KeyHolderTO(Integer key) {
        setKey(key);
    }
    

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

}
