package com.itschool.platform.core;

import java.io.IOException;
import java.io.OutputStream;



public interface Response {

	void write(OutputStream outputStream) throws IOException;
	

}
