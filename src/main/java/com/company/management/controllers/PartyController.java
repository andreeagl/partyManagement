/**
 *
 **/
package com.company.management.controllers;

import com.company.management.entities.Party;
import com.company.management.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/parties")
public class PartyController {

    @Autowired
    PartyService partyService;

    @GetMapping
    public List<Party> findAllParties() {
        return partyService.findAll();
    }

}
