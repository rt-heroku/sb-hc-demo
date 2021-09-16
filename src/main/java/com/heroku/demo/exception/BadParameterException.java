package com.heroku.demo.exception;

import java.util.ArrayList;
import java.util.List;

public class BadParameterException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3596604560711578787L;
	private List<String> errorMessages = new ArrayList<>();
            
    public BadParameterException() {
    }

    public BadParameterException(String msg) {
        super(msg);
    }
    
    /**
     * @return the errorMessages
     */
    public List<String> getErrorMessages() {
        return errorMessages;
    }

    /**
     * @param errorMessages the errorMessages to set
     */
    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public void addErrorMessage(String message) {
        this.errorMessages.add(message);
    }
}
