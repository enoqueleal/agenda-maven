package com.agenda.endpoint.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "com.agenda.endpoint.soap.HelloWorldEndpoint")
public class HelloWorldEndpointImpl implements HelloWorldEndpoint  {

	@Override
	public String helloWorld() {
		return "Hello world!";
	}

}
