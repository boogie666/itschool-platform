package com.itschool.platform.util;

import java.io.IOException;
import java.io.OutputStream;



import com.itschool.platform.core.Interactor;
import com.itschool.platform.core.Request;
import com.itschool.platform.core.Response;

public class FakeInteractor implements Interactor {

	public Response execute(Request r) {
		return new FakeResponse("Hello World");
	}

	private static class FakeResponse implements Response{
		private final String data;
		
		FakeResponse(String d){
			data = d;
		}
		
		public void write(OutputStream outputStream) throws IOException {
			outputStream.write(data.getBytes());
		}
		
	}
}
