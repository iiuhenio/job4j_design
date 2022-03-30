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
     * метод расширения массива
     */
    public void increase() {
        if (container.length == 0) {
            container = Arrays.copyOf(container, container.length + 10);
        } else {
            container = Arrays.copyOf(container, container.length * 2);
        }
    }

    /**
     * добавить элемент
     * @param value - значение добавляемого элемента
     */
    @Override
    public void add(T value) {
        container[size] = value;
        size++;
        modCount++;
    }

    /**
     * заменить элемент по индексу и вернуть тот, который там располагался ранее
     * @param index - индекс заменяемого элемента
     * @param newValue - значение добавляемого элемента
     * @return - возращаем элемент, который был ранее
     */
    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T oldValue = container[index];
        container[index] = newValue;
        return oldValue;
    }

    /**
     * удалить элемент по индексу и сдвинуть все значения вправо
     * @param index - индекс удаляемого элемента
     * @return - значение удаляемого элемента
     */
    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T oldValue = container[index];
        System.arraycopy(
                container, index + 1, container, index, container.length - index - 1);
        container[container.length - 1] = null;
        size--;
        modCount++;
        return oldValue;
    }

    /**
     * вернуть значение элемента по индексу
     * @param index - индекс нужного элемента
     * @return - значение нужного элемента
     */
    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    /**
     * Получить количество находящихся в массиве элементов
     * @return - количество элементов в массиве
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int count = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if ((expectedModCount != modCount)) {
                    throw new ConcurrentModificationException();
                }
                return count < size;
            }

            @Override
            public T next() {
                return container[count++];
            }
        };
    }
}