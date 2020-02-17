/**
 *
 **/
package com.company.management.services.impl;

import com.company.management.entities.Party;
import com.company.management.repositories.PartyRepository;
import com.company.management.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultPartyService implements PartyService {
    @Autowired
    PartyRepository partyRepository;

    public Party findPartyByName(String name) {
        return  partyRepository.findById(name).get();
    }

    public List<Party> findAll(){
      return  partyRepository.findAll();
    }
}
