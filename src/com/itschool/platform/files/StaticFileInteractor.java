package com.itschool.platform.files;

import java.io.File;

import com.itschool.platform.core.Interactor;
import com.itschool.platform.core.Request;
import com.itschool.platform.core.Response;

public class StaticFileInteractor implements Interactor {

	public Response execute(Request r) {

		if (r.getPath().equals("/")) {
			File f = new File("resources/public/index.html");

			return new FileResponse(f);
		}

		File f = new File("resources/public" + r.getPath());
		if (f.exists()) {
			return new FileResponse(f);
		}

		return null;
	}

}
