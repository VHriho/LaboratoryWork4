package org.example.repository;

import org.example.repository.entity.ResultEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;

@Repository
public class RepoImplm implements RepoInterf {
    private final IdRepoInterf  idRepoInterf;
    private final ObjectMapper objectMapper;

    @Autowired
    public RepoImplm(IdRepoInterf idRepoInterf, ObjectMapper objectMapper){
         this.idRepoInterf = idRepoInterf;
         this.objectMapper = objectMapper;
    }

    private static final String DIRECTORY_PATH = "/OOP/LabWorksOOP/results";

    public Double saveResult(ResultEntity entity){
        Integer id = idRepoInterf.getLastId();
        entity.setId(id);

        try{
            String json = objectMapper.writeValueAsString(entity);
            saveJson(json, id);
        } catch (IOException e){
            e.printStackTrace();
        }
        idRepoInterf.saveLastId(id+1);
        return Double.valueOf(entity.getId());
    }
    private void saveJson(String json, Integer id) throws IOException {
        String filePath = getFilePath(id);
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(json);
        fileWriter.close();
    }

    private String getFilePath(Integer id) {
        return DIRECTORY_PATH + File.separator + id + ".json";
    }

    @Override
    public ResultEntity getResultById(Integer id) {
        try {
            File file = getFileById(id);
            if (!file.exists()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Result not found");
            }

            String json = readJson(file);
            ResultEntity result = convertJson(json);

            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File getFileById(Integer id) {
        String filePath = getFilePath(id);
        return new File(filePath);
    }

    private String readJson(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    private ResultEntity convertJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ResultEntity.class);
    }
}
