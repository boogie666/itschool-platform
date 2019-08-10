package com.itschool.platform;

import org.eclipse.jetty.server.Server;

public class Main {

	public static void main(String[] args) throws Exception {
		Server s = new Server(8080);
		s.start();
		s.join();
		
	}

}
