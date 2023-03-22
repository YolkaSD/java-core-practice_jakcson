package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Task - 1
        File personJSON = new File("src/main/resources/person.json");
        List<Person> personList = readJsonFile(personJSON, Person.class);
        //Task - 2
        File bookJSON = new File("src/main/resources/book.json");
        List<Book> bookList = new ArrayList<>();
        readJsonFile2(bookJSON, Book.class, bookList);



    }

    public static <T> List<T> readJsonFile(File json, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(json)) {
            ObjectMapper mapper = new ObjectMapper();
            JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
            list = mapper.readValue(inputStream, type);

        } catch (IOException e) {
            System.err.println("Error! Failed to read file: " + json.getAbsolutePath() + ". " + e.getMessage());
        }
        return list;
    }

    public static <T> void readJsonFile2(File json, Class<T> clazz, List<T> list) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
            List<T> newList = mapper.readValue(json, type);
            list.addAll(newList);
        } catch (IOException e) {
            System.err.println("Error! Failed to read file: " + json.getAbsolutePath() + ". " + e.getMessage());
        }
    }
}