package com.company.management.repositories;

import com.company.management.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByPartyName(String partyName);
}
