package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Реализуйте методы next и hasNext.
 * нужно вывести элементы двумерного массива
 */
public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    /**
     * в цикле while следующая проверка:
     * - ряд существует (пока наш ряд меньше общего колич.рядов), и
     * - столбец существует (если колич. столбцов == столбцу к которому мы подошли в данный момент,
     *   то значит в этом ряду столбцов больше нет и column опять становится 0 (column = 0)
     *   а мы переходим к следующему ряду (row++), и начинаем выводить столбцы теперь этого ряда, начиная с column = 0.
     * @return определяет, существуют ли еще ряды, результ которых мы не вывели.
     */
    @Override
    public boolean hasNext() {
        while (row < data.length && data[row].length == column) {
            column = 0;
            row++;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}