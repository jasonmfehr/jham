package org.jham.transferobjects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="keyholder")
public class KeyHolderTO {

	private Integer key;
	
    public KeyHolderTO() {
        
    }
    
    public KeyHolderTO(Integer key) {
        setKey(key);
    }
    

    @XmlElement(name="key")
    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

}
