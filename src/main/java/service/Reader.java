package service;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

    @SneakyThrows(IOException.class)
    public static ArrayList<String> readLines(String filePath) {

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<String> fileRowsArray = new ArrayList<>();
        String line = reader.readLine();

        while ((line = reader.readLine()) != null) {
            fileRowsArray.add(line);
        }

        return fileRowsArray;
    }
}
