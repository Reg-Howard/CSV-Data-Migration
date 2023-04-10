package com.sparta.group2.model.factory;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader {

    public static String[] readFileLines(String fileName) {
        List<String> result = new ArrayList<>();
        String line;
        try (java.io.FileReader fr = new java.io.FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.subList(1, 10001).toArray(new String[0]);
    }
}
