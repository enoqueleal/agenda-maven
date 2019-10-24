package com.agenda.endpoint.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public class HelloWorldEndpoint {

	 @WebMethod
	public String helloWorld() {
		return "Hello world!";
	}

}
