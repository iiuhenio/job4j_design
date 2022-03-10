package ru.job4j.generic;

/**
 * Например, модель данных User, которая будет использоваться и наследовать класс Base,
 * будет выглядеть следующим образом:
 */
public class User extends Base {

    private final String username;

    public User(String id, String name) {
        super(id);
        this.username = name;
    }

    public String getUsername() {
        return username;
    }
}
