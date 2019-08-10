package com.itschool.platform.questions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.itschool.platform.core.Interactor;
import com.itschool.platform.core.Request;
import com.itschool.platform.core.Response;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllQuestionsInteractor implements Interactor {
    public Response execute(Request r) {
        // get the list of questions
        List<Question> qs = new ArrayList<Question>();

        File questionsFolder = new File("resources/questions");


        File[] listOfFiles = questionsFolder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            try {
                Map<String, Object> data = mapper.readValue(listOfFiles[i], Map.class);
                Question q = new Question();
                q.setId(i);
                q.setTitle(data.get("title").toString());
                qs.add(q);
            } catch (IOException e) {
                e.printStackTrace();
            }



        }

        Question q = new Question();

        return new AllQuestionsResponse(qs);
    }
}
