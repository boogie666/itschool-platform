package com.itschool.platform.files;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.itschool.platform.core.Response;

public class FileResponse implements Response {
	private final File file;

	public FileResponse(File f) {
		this.file = f;
	}

	public void write(OutputStream outputStream) throws IOException {

		Path p = Paths.get(file.getPath());

		byte[] data = Files.readAllBytes(p);
		outputStream.write(data);
	}

}
