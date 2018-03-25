package com.example.pojo;

public class RequestManagerOld {
	private RequestHandler reqHandler;
	
	public void handleRequest(){
		reqHandler.handlerequest();
	}

	public RequestHandler getReqHandler() {
		return reqHandler;
	}

	public void setReqHandler(RequestHandler reqHandler) {
		this.reqHandler = reqHandler;
	}

}
