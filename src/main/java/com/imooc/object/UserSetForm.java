package com.imooc.object;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by 59215_000 on 2016/5/5.
 */
public class UserSetForm {
    private Set<User> users;

    private UserSetForm(){
        users = new LinkedHashSet<User>();
        users.add(new User());
        users.add(new User());
    }

    @Override
    public String toString() {
        return "UserSetForm{" +
                "users=" + users +
                '}';
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
