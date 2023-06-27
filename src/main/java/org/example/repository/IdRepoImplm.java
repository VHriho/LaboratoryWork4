package org.example.repository;

import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

@Repository
public class IdRepoImplm implements IdRepoInterf{
    private static final String FILE_PATH = "/OOP/LabWorksOOP/results/id.txt";

    @Override
    public int getLastId(){
        try {
            if (!Files.exists(Paths.get(FILE_PATH))) {
                Files.createFile(Paths.get(FILE_PATH));
                saveLastId(0);
            }

            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            return Integer.parseInt(content.trim());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void saveLastId(int id){
        try (Writer writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(String.valueOf(id));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
