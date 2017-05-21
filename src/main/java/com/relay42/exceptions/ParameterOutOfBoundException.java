package com.relay42.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Eldjon Kepucka.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Number of records does not fall within the allowed boundaries")
public class ParameterOutOfBoundException extends RuntimeException {

	public ParameterOutOfBoundException(String msg){
		super(msg);
	}
}
