package ru.kravchenko.se;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int x = 1;
        String resul;
        resul = x == 2 ?  "1" :  "not 1";
        System.out.println(resul);
    }


    public static List<User> testSetUsers (List<User> usersList) {
        HashSet<User> setUsers = new HashSet<>(usersList);

        List<User> res = new ArrayList<>(setUsers);
        return res;
    }

    static void test() {
        List<User> users = new ArrayList<>();
        User userState = new User("ROMANO");
        users.add(userState);
        users.add(new User("1"));
        users.add(new User("2"));
        users.add(new User());
        users.add(userState);
        users.add(userState);
        users.add(new User("1"));
        users.add(new User());

        List<User> users1 = testSetUsers(users);
        for (User user: users1) System.out.println(user.getName());
    }

}
