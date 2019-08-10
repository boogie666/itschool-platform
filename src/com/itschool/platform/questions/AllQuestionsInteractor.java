package com.itschool.platform.questions;

import com.itschool.platform.core.Interactor;
import com.itschool.platform.core.Request;
import com.itschool.platform.core.Response;

import java.util.ArrayList;
import java.util.List;

public class AllQuestionsInteractor implements Interactor {
    public Response execute(Request r) {
        // get the list of questions
        List<Question> qs = new ArrayList<Question>();
        Question q = new Question();
        q.setId(1);
        q.setTitle("hello");
        qs.add(q);
        return new AllQuestionsResponse(qs);
    }
}
