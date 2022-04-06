package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(3);

    @Override
    public boolean add(T value) {
        boolean rsl = contains(value);
        if (!rsl) {
            set.add(value);
            rsl = true;
        } else {
            rsl = false;
        }
    return rsl;
    }


    @Override
    public boolean contains(T value) {
        boolean rsl = false;
        for (T index : set) {
            if (Objects.equals(index, value)) {
                rsl = true;
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