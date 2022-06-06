package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        /**
         * getTotalSpace() показывает размер файла в байтах
         */
        System.out.println(String.format("size : %s", file.getTotalSpace()) + " байт");
        for (File subfile : file.listFiles()) {
            System.out.println(String.format("директория %s, размер %s", subfile.getAbsoluteFile(), subfile.length() + " байт"));
        }
    }
}