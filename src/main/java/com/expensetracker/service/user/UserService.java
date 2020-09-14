package com.expensetracker.service.user;

import com.expensetracker.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> findById(Long userId);

    User update(User user);

    void deleteById(Long userId);

    Collection<User> findAll();

}
