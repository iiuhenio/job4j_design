package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private int size = 10;
    private SimpleArrayList<T> set = new SimpleArrayList<>(size);

    @Override
    public boolean add(T value) {
        if (contains(value)) {
            return false;
        }
        set.add(value);
        return true;
    }

    @Override
    public boolean contains(T value) {
        return set.equals(value);
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}