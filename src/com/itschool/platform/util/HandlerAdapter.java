package com.itschool.platform.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.itschool.platform.core.Interactor;
import com.itschool.platform.core.Response;

public class HandlerAdapter extends AbstractHandler {
	private  final Interactor interactor;
	
	 public HandlerAdapter(Interactor i) {
		this.interactor = i;
	}

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Response r = this.interactor.execute(new com.itschool.platform.core.Request(request.getPathInfo()));
		if(r != null) {
			r.write(response.getOutputStream());
			baseRequest.setHandled(true);
		}
	}
	

}
