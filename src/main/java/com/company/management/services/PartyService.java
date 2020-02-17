package com.company.management.services;

import com.company.management.entities.Party;

import java.util.List;

public interface PartyService {

    Party findPartyByName(String name);

    List<Party> findAll();
}
