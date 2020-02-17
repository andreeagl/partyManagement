package com.company.management.repositories;

import com.company.management.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartyRepository extends JpaRepository<Party, String> {
}
