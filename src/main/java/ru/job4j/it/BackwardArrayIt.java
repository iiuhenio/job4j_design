package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализуйте итератор для массива. Итератор должен отдавать элементы в обратном порядке.
 */
public class BackwardArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public BackwardArrayIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[data.length - 1 - point++];
    }
}