package com.fimc.hello.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpErrorResponse implements Serializable {
	private String message;
	private int errorCode;
}
