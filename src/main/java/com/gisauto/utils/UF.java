package com.gisauto.utils;

import com.gisauto.users.User;

import java.util.ArrayList;

public class UF {

    private static ArrayList<Object> usersInstances = new ArrayList<>();

    /**
     * User factory method creates instance of users class.
     *
     * @param userClass - class extends User
     * @return - created user, which extends User
     */
    public static <T extends User> T getUser(Class<T> userClass) {
        for (Object a : usersInstances) {
            if (a != null) {
                if (a.getClass() == userClass) {
                    return (T) a;
                }
            } else usersInstances.remove(a);
        }

        T user = null;
        try {
            user = userClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        usersInstances.add(user);
        return user;
    }

    public static void reset(){
        usersInstances = new ArrayList<>();
    }
}
