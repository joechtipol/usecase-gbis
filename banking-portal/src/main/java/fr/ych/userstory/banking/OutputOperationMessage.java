package fr.ych.userstory.banking;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OutputOperationMessage {
	
	protected String message;
	
	protected String status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

}
