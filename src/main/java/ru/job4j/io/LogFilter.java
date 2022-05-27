package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> result = List.of();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            result = in.lines().filter(x -> "404".equals(x.split(" ")[8]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        for (String a : log) {
            System.out.println(a);
        }
    }
}
