package org.example;

import java.io.*;

public class DataReaderExample {
    public static void main(String[] args) {
        String textPath = "src/main/resources/text.txt";
        File file = new File(textPath);

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Some mistake");
        }

        String filePath = "src/main/resources/file.txt";
        File testFile = new File(filePath);
        DataReaderExample.createFile(testFile);

        DataReaderExample.deleteFile(testFile);

        DataReaderExample.readFileCharByChar(file);
    }

    public static void createFile(File filePath) {
        if (filePath.exists() && filePath.isFile()) {
            System.out.println("File exists");
        } else {
            try {
                System.out.println("File '" + filePath.getName() + "' created: " + filePath.createNewFile());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void deleteFile(File filePath) {
        if (filePath.exists() && filePath.isFile()) {
            System.out.println("File '" + filePath.getName() + "' deleted: " + filePath.delete());
        } else {
            System.out.println("File '" + filePath.getName() + "' File does not exist.");
        }
    }

    public static void readFileCharByChar(File filePath) {
        try (FileReader fileReader = new FileReader(filePath)){
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.println((char) character);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath.getName());
        }
    }
}
