package ru.job4j.ahaha;

import java.util.Scanner;

public class SeaFight {

    public int[][] array = new int[10][10];

    /**
     * Задаем игровое поле 10 * 10 и выводим его на экран
     */
    public int[][] set() {
        System.out.println("Игровое поле:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 0;
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
        }

        /*
        //Ввод с клавиатуры:

        Scanner console = new Scanner(System.in);
        System.out.println("Задайте координаты однотрубного корабля");
        System.out.println("Введите цифну от 0 до 9 по горизонтали");
        int a = console.nextInt();
        System.out.println("Введите цифну от 0 до 9 по вертикали");
        int b = console.nextInt();
        System.out.println("Корабль с координатами " + a + "-" + b + " создан!");
        System.out.println("Задайте второго однотрубного корабля");
        System.out.println("Введите цифну от 0 до 9 по горизонтали");
        int c = console.nextInt();
        System.out.println("Введите цифну от 0 до 9 по вертикали");
        int d = console.nextInt();
        System.out.println("Корабль с координатами " + c + "-" + d + " создан!");
        System.out.println("Игра начинается!");

         array[a][b] = 1;
         array[c][d] = 1;
         */

        return new int[10][10];
    }

    /**
     * Расставляем корабли и выводим их расположение на экран
     */
    public int[][] location() {

        array[4][5] = 1;
        array[4][1] = 1;
        array[0][3] = 1;
        array[3][9] = 1;

        array[0][0] = 2;
        array[0][1] = 2;

        array[6][6] = 2;
        array[7][6] = 2;

        array[9][8] = 2;
        array[9][9] = 2;

        array[1][6] = 3;
        array[1][7] = 3;
        array[1][8] = 3;

        array[7][0] = 3;
        array[8][0] = 3;
        array[9][0] = 3;

        array[2][3] = 4;
        array[3][3] = 4;
        array[4][3] = 4;
        array[5][3] = 4;

        System.out.println("Расстановка кораблей:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
        }
        return new int[10][10];
    }

    /**
     * Считаем количество одно-трублных кораблей и выводим его на экран
     */
    public int count1() {
        int count1 = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    count1++;
                }
            }
        }
        System.out.println("Количество 1-трубных кораблей: " + count1);
        return count1;
    }

    /**
     * Считаем количество двух-трублных кораблей и выводим его на экран
     */
    public int count2() {
        int count2 = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 2) {
                    count2++;
                }
            }
        }
        System.out.println("Количество 2-трубных кораблей: " + count2 / 2);
        return count2 / 2;
    }

    /**
     * Считаем количество трех-трублных кораблей и выводим его на экран
     */
    public int count3() {
        int count3 = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 3) {
                    count3++;
                }
            }
        }
        System.out.println("Количество 3-трубных кораблей: " + count3 / 3);
        return count3 / 3;
    }

    /**
     * Считаем количество четырех-трублных кораблей и выводим его на экран
     */
    public int count4() {
        int count4 = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 4) {
                    count4++;
                }
            }
        }
        System.out.println("Количество 4-трубных кораблей: " + count4 / 4);
        return count4 / 4;
    }

    /**
     * Выводим все методы на экран
     */
    public static void main(String[] args) {
        SeaFight seaFight = new SeaFight();
        seaFight.set();
        seaFight.location();
        seaFight.count1();
        seaFight.count2();
        seaFight.count3();
        seaFight.count4();
    }
}
