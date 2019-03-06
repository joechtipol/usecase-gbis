package fr.ych.userstory.banking.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OutputOperationMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3678565288183354134L;

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
