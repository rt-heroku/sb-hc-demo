package com.heroku.demo.exception;

import java.util.ArrayList;
import java.util.List;

public class BadResourceException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3596604560711578787L;
	private List<String> errorMessages = new ArrayList<>();
            
    public BadResourceException() {
    }

    public BadResourceException(String msg) {
        super(msg);
		Throwable t = this.getCause();
		while (t != null) {
			this.addErrorMessage(t.getLocalizedMessage());
			t = t.getCause();
		}
    }

    public BadResourceException(String msg, Throwable e) {
        super(msg);
		Throwable t = e.getCause();
		while (t != null) {
			this.addErrorMessage(t.getLocalizedMessage());
			t = t.getCause();
		}
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
