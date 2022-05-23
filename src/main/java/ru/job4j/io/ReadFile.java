package ru.job4j.io;


import java.io.FileInputStream;
import java.io.InputStream;

/**
 * класс java.io.FileInputStream позволяет прочитать данные из файла
 * В этом уркое мы узнаем, как прочитать файл
 * Создайте файл в корне проекта. Дайте ему имя input.txt.
 *
 * Сделаем программу, которая будет читать этот файл:
 * Данные считываются по байтам. Здесь используется конструкция try-with-resources,
 * чтобы закрыть поток ввода.
 */
public class ReadFile {
    public static void main(String[] afrgs) {
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }

            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                System.out.println(line);
            }

            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}