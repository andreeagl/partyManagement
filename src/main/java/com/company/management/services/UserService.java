package com.company.management.services;

import com.company.management.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(User user);

    Optional<User> findByEmail(String email);

    void deleteByEmail(String email);

    List<User> findAll();

    List<User> findAllForUserParty();
}
