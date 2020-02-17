package com.company.management.services.impl;

import com.company.management.entities.User;
import com.company.management.repositories.UserRepository;
import com.company.management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        User loggedInUser = getLoggedInUser();
        if("admin".equals(loggedInUser.getRole())){
            user.setParty(loggedInUser.getParty());
            userRepository.save(user);
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllForUserParty() {
        User user = getLoggedInUser();
        return userRepository.findByPartyName(user.getParty().getName());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findById(email);
    }

    @Override
    public void deleteByEmail(String email) {
        User loggedInUser = getLoggedInUser();
        if("admin".equals(loggedInUser.getRole())){
            userRepository.deleteById(email);
        }
    }

    private User getLoggedInUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> userOpt = findByEmail(principal.toString());
        if(userOpt.isPresent()) {
            return userOpt.get();
        }
        throw new IllegalArgumentException("Something is wrong with the user");
    }
}
