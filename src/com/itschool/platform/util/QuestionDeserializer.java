package com.itschool.platform.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.itschool.platform.questions.Question;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class QuestionDeserializer {
    public Question read(int id, File f){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Map data = mapper.readValue(f, Map.class);
            Question q = new Question();
            q.setId(id);
            q.setTitle(data.get("title").toString());
           return q;
        } catch (IOException e) {
            return  null;
        }
    }
}
