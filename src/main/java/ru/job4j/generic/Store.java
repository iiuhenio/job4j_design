package ru.job4j.generic;

/**
 * В этом задании необходимо реализовать контейнеры для хранения объектов.
 * Структура контейнеров будет одинаковая. Все ограничения хранимых типов мы должны задать с помощью Generics.
 * Контейнеры должны быть описаны интерфейсом.
 */
public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}