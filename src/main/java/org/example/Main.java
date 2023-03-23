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
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //Task - 1
        File personJSON = new File("src/main/resources/person.json");
        List<Person> personList = mapper.readValue(personJSON, new TypeReference<>() {});
        System.out.println(personList);
        //Task - 2
        File bookJSON = new File("src/main/resources/book.json");
        List<Book> bookList = mapper.readValue(bookJSON, new TypeReference<>() {});
        System.out.println(bookList);
        //Task - 3
        File orderJSON = new File("src/main/resources/order.json");
        Order order = mapper.readValue(orderJSON, new TypeReference<>() {});
        System.out.println(order);
        //Task - 4
        File userJSON = new File("src/main/resources/user.json");
        User user = mapper.readValue(userJSON, new TypeReference<>() {});
        System.out.println(user);
        //Task - 5
        File productJSON = new File("src/main/resources/product.json");
        List<Product> productList = mapper.readValue(productJSON, new TypeReference<>() {});
        System.out.println(productList);

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