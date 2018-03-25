package com.example.pojo;

public abstract class RequestManager {
	private RequestHandler requestHandler;
	
	public void handleRequest(){
		requestHandler = getRequestHandler();
		requestHandler.handlerequest();
		requestHandler.handlerequest();
	}
	
	public abstract RequestHandler getRequestHandler();
}
