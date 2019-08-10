package com.itschool.platform.router;

import com.itschool.platform.core.Interactor;
import com.itschool.platform.core.Request;
import com.itschool.platform.core.Response;

public class RouterInteractor implements Interactor {
    private final Interactor allQuestions;
    private final Interactor files;

    public RouterInteractor(Interactor allQuestions, Interactor files) {
        this.allQuestions = allQuestions;
        this.files = files;
    }

    @Override
    public Response execute(Request r) {
        if(r.getPath().equals("/api/questions")){
            return allQuestions.execute(r);
        }
        return files.execute(r);
    }
}
