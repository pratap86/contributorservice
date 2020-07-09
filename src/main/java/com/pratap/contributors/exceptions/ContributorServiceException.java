package com.pratap.contributors.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * 
 * @author Pratap Narayan
 *
 */

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ContributorServiceException extends RuntimeException {

	private static final long serialVersionUID = 7065730553879134065L;

	public ContributorServiceException(String message) {
		super(message);
	}

	
}
