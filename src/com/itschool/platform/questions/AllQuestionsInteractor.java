package com.itschool.platform.questions;

import com.itschool.platform.core.Interactor;
import com.itschool.platform.core.Request;
import com.itschool.platform.core.Response;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AllQuestionsInteractor implements Interactor {
    public Response execute(Request r) {
        // get the list of questions
        List<Question> qs = new ArrayList<Question>();

        File questionsFolder = new File("resources/questions");

        if(questionsFolder.exists()){
            System.out.println("ok");
        }else{
            System.out.println("not");
        }

        File[] listOfFiles = questionsFolder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            Question q = new Question();
            q.setId(i);
            q.setTitle("hello" + i);
            qs.add(q);
        }

        Question q = new Question();

        return new AllQuestionsResponse(qs);
    }
}
