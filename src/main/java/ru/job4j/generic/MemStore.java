package ru.job4j.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * Сделаем каркас универсального хранилища:
 * @param <T>
 */
public final class MemStore<T extends Base> implements Store<T> {
    /**
     * Хранить данные будем в map.
     * В этой карте ключом будет являться id нашей модели, а значением - объект,
     * который мы будем хранить в хранилище, в данном случае это обобщенный тип T.
     */
    private final Map<String, T> storage = new HashMap<>();

    /**
     * требуется реализовать методы
     * метод add добавляет в хранилище объект типа T, при этом метод ничего не возвращает;
     */
    @Override
    public void add(T model) {
        if (!storage.containsKey(model.getId())) {
            storage.put(model.getId(), model);
        }
    }

    /**
     * replace() - метод выполняет замену объекта по id, на объект который передается в параметрах метода
     * и возвращает true, если замена выполнена успешно;
     */
    @Override
    public boolean replace(String id, T model) {
        return storage.replace(model.getId(), findById(id), model);
    }

    /**
     * delete() - метод удаляет пару ключ-значение по id, который передается в метод и возвращает true,
     * если удаление выполнено успешно;
     */
    @Override
    public boolean delete(String id) {
        return storage.remove(id, findById(id));
    }

    /**
     * findById() - метод возвращает объект по ключу, который равен id,
     * передаваемый в качестве параметра метода или возвращает null
     * если по такому ключу в Map еще нет пару ключ-значение.
     */
    @Override
    public T findById(String id) {
        return storage.get(id);
    }
}