package com.imooc.object;

import java.util.Map;

/**
 * Created by 59215_000 on 2016/5/5.
 */
public class UserMapForm {
    private Map<String,User> users ;

    @Override
    public String toString() {
        return "UserMapForm{" +
                "users=" + users +
                '}';
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }
}
