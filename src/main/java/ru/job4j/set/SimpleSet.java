package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private int size = 3;
    private SimpleArrayList<T> set = new SimpleArrayList<>(size);

    @Override
    public boolean add(T value) {
        boolean rsl;
        if (set.size() == 0) {
            set.add(value);
            rsl = true;
        } else {
            if (!contains(value)) {
                set.add(value);
                rsl = true;
            } else {
                rsl = false;
            }
        }
        return rsl;
    }

    @Override
    public boolean contains(T value) {
        boolean rsl = true;
        for (T index : set) {
            if (Objects.equals(index, value)) {
                break;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}