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
        System.out.println("hashCode map: " + map);
        System.out.println("hashCode map: " + map.hashCode());
        System.out.println("hashCode user1: " + user1.hashCode());
        System.out.println("hashCode user2: " + user2.hashCode());
    }

    @SuppressWarnings("checkstyle:EqualsHashCode")
    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
