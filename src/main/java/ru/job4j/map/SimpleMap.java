
package ru.job4j.map;

import java.util.*;

/**
В этом задании вам необходимо реализовать собственную мапу.
 */
public class SimpleMap<K, V, element> implements Map<K, V> {

    /**
     * Объявим следующие поля:
     */
    private static final float LOAD_FACTOR = 0.75f; /* по достижению какого количества расширяем массив */
    private int capacity = 8; /* емкость массива */
    private int count = 0; /* счетчик добавления элементов */
    private int modCount = 0; /* счетчик изменений */


    /**
     * Объявим массив, в котором будем хранить элементы
     */
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    /*
    Данный метод добавляет элемент в карту
     */
    @Override
    public boolean put(K key, V value) {
        expand(); /* проверяем размер массива, увеличиваем при необходимости */
        MapEntry<K, V> element = new MapEntry<>(key, value); /* создаем элемент */
        boolean rsl = false;
        int index = indexFor(hash(key.hashCode())); /* создаем переменную индекс и вычисляем его */
        table[index] = element; /* вставляем элемент в индекс */
        count++;
        modCount++;
        rsl = true;
        return rsl;
    }

    /**
     * вычисляем hash
     */
    private int hash(int hashCode) {
        return hashCode % table.length;
    }

    /**
     * Вычисляем конечный индекс
     */
    private int indexFor(int hash) {
        return hash & table.length - 1;
    }

    /**
     * Создаем метод расширения массива
     */
    private void expand() {
        if (table.length == 0) {
            table = Arrays.copyOf(table, table.length + capacity); /* если длинна 0, то 8 */
        }
        if (count % capacity == LOAD_FACTOR) {
            table = Arrays.copyOf(table, table.length * 2); /* при заполнении 75% увеличиваем */
        }
    }

    /**
     * Создаем метод получения элемента по индексу
     */
    @Override
    public V get(K key) {
        V rsl; /* значение */
        int index = indexFor(hash(key.hashCode())); /* вычисляем индекс */
        if (table[index] != null) {
            rsl = table[index].value;
        } else {
            rsl = null;
        }
        return rsl;
    }

    /**
     * Создае метод удаления элемента по ключу
     */
    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        for (int i = 0; i < table.length; i++) {
            if (table[i] == table[i].key) {
                table[i] = null;
                count--;
                modCount++;
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    /**
     * создаем итератор
     */
    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int expectedModCount = modCount; /* не должно быть изменений в момент итерирования */
            int point = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[point++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
