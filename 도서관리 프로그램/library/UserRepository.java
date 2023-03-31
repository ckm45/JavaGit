package com.ckm.library;

import java.util.List;
import com.ckm.library.Member;

public interface UserRepository {
    // CRUD
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    List<User> findAll();

    User findById(int id);

    User findByName(String name);

    // ...
}