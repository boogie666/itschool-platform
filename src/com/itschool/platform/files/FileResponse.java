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
        final Path p = Paths.get(file.getPath());

        final byte[] content = Files.readAllBytes(p);
        outputStream.write(content);
    }

}
