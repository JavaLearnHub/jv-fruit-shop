package service;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Reader {

    @SneakyThrows(IOException.class)
    public static ArrayList<String> readLines(String filePath) {

        File file = new File(filePath);

        ArrayList<String> fileRows = new ArrayList<>(Files.lines(file.toPath()).toList());
        fileRows.remove(0);

        return fileRows;
    }
}
