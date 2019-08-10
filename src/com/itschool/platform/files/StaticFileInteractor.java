package com.itschool.platform.files;

import java.io.File;

import com.itschool.platform.core.Interactor;
import com.itschool.platform.core.Request;
import com.itschool.platform.core.Response;

public class StaticFileInteractor implements Interactor {
    private final String basePath;

    public StaticFileInteractor(String basePath) {
        this.basePath = basePath;
    }

    public Response execute(Request r) {

        String path = r.getPath();
        if (path.equals("/")) path += "index.html";

        final File f = new File(basePath + path);
        if (f.exists()) return new FileResponse(f);

        return null;
    }

}
