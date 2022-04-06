package ru.job4j.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar date = new GregorianCalendar(1985, Calendar.JANUARY, 16);
        User user1 = new User("Anton", 2, date);
        User user2 = new User("Anton", 2, date);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());

        System.out.println("map equals() only: " + map);
        System.out.println("user1.hashCode(): " + user1.hashCode());
        System.out.println("user2.hashCode(): " + user2.hashCode());
        System.out.println("map.hashCode(): " + map.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }
}
