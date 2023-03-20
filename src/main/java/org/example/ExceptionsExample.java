package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class ExceptionsExample {
    /**
     * Метод для чтения первой строки из файла
     *
     * @param filePath путь к файлу
     */
    public static void printFirstString(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String firstString = reader.readLine();
            System.out.println(Objects.requireNonNullElse(firstString, "Ошибка! Файл пустой."));
            if (firstString.isEmpty()) {
                throw new IllegalArgumentException("Ошибка! Первая строка пустая");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка! Файл '" + filePath + "' не найден.");
        } catch (IOException e) {
            System.err.println("Ошибка! Не удалось прочитать данные из файла '" + filePath + "'.");
        }
    }

    /**
     * Метод деления двух чисел
     */
    public static void divide(int dividend, int divisor) {
        try {
            int quotient = dividend / divisor;
            System.out.println(quotient);
        } catch (ArithmeticException e) {
            System.err.println("Ошибка! Произошло деление на 0.");
        }
    }


}
