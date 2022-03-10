package ru.job4j.generic;

/**
 * Сделаем реализацию для пользователя. Будем использовать композицию объектов.
 *
 * Здесь методы будут делать тоже самое, что и в универсальном хранилище MemStore.
 * Однако заново реализовывать методы нам уже не придется,
 * мы можем просто вызывать реализации этих методов из MemStore,
 * поскольку объект именно этого типа мы используем в качестве хранилища.
 */
public class UserStore implements Store<User> {

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}