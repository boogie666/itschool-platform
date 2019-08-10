package com.itschool.platform;

import org.eclipse.jetty.server.Server;

import com.itschool.platform.files.StaticFileInteractor;

import com.itschool.platform.util.HandlerAdapter;

public class Main {

	public static void main(String[] args) throws Exception {
		Server s = new Server(8080);

		s.setHandler(new HandlerAdapter(new StaticFileInteractor()));
		s.start();
		s.join();

	}

}
