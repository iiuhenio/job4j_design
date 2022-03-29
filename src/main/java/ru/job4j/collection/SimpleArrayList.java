package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    /**
     * массив, в котором работаем
     */
    private T[] container;

    /**
     * размер массива
     */
    private int size;

    /**
     * счетчик изменений. При добавлении эл-та увеличиваем, при удалении - уменьшаем
     */
    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    /**
     * добавить элемент
     * @param value - значение добавляемого элемента
     */
    @Override
    public void add(T value) {
        Objects.checkIndex(0, container.length);
        while (iterator().hasNext()) {
            iterator().next() = value;
        }
    }

    /**
     * заменить элемент по индексу и вернуть тот, который там располагался ранее
     * @param index - индекс заменяемого элемента
     * @param newValue - значение добавляемого элемента
     * @return - возращаем элемент, который был ранее
     */
    @Override
    public T set(int index, T newValue) {
        return null;
    }

    /**
     * удалить элемент по индексу и сдвинуть все значения вправо
     * @param index - индекс удаляемого элемента
     * @return - значение удаляемого элемента
     */
    @Override
    public T remove(int index) {
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        modCount--;
        container[container.length - 1] = null;
        return container[index];
    }

    /**
     * вернуть значение элемента по индексу
     * @param index - индекс нужного элемента
     * @return - значение нужного элемента
     */
    @Override
    public T get(int index) {
        return container[index];
    }

    /**
     * Получить количество находящихся в массиве элементов
     * @return - количество элементов в массиве
     */
    @Override
    public int size() {
        return container.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return container[container.length - 1] != null;
            }

            @Override
            public T next() {
                if (!iterator().hasNext()) {
                    throw new NoSuchElementException();
                }
                int expectedModCount = 0;
                if ((expectedModCount != modCount)) {
                    throw new ConcurrentModificationException();
                }
                return null;
            }
        };
    }
}