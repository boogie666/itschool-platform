package com.itschool.platform.questions;

import com.itschool.platform.core.Interactor;
import com.itschool.platform.core.Request;
import com.itschool.platform.core.Response;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class AllQuestionsResponse implements Response {
    private final List<Question> data;
    public AllQuestionsResponse(List<Question> qs) {
        this.data = qs;
    }

    public void write(OutputStream outputStream) throws IOException {
        String s = "[";
        for(Question q : data){
            s += q.toString() + " ";
        }
        s += "]";
        outputStream.write(s.getBytes());
    }
}
