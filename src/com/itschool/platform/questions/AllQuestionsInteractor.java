package com.itschool.platform.questions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.itschool.platform.core.Interactor;
import com.itschool.platform.core.Request;
import com.itschool.platform.core.Response;
import com.itschool.platform.util.QuestionDeserializer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class AllQuestionsInteractor implements Interactor {
    private final String questionPath;
    private QuestionDeserializer deserializer;

    public AllQuestionsInteractor(String questionPath) {
        this.questionPath = questionPath;
        this.deserializer = new QuestionDeserializer();
        //"resources/questions"
    }

    public Response execute(Request r) {
        // get the list of questions
        final List<Question> questions = new ArrayList<Question>();

        File questionsFolder = new File(this.questionPath);
        File[] listOfFiles = questionsFolder.listFiles();

        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                Question q = this.deserializer.read(i, listOfFiles[i]);
                questions.add(q);
            }
        }
        return new AllQuestionsResponse(questions);
    }
}
