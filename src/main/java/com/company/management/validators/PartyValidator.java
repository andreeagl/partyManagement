package com.company.management.validators;

import com.company.management.entities.Party;
import com.company.management.repositories.PartyRepository;
import com.company.management.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PartyValidator implements Validator {

    @Autowired
    PartyService partyService;

    @Override public boolean supports(Class<?> aClass) {
        return Party.class.equals(aClass);
    }

    @Override public void validate(Object o, Errors errors) {
        Party party = (Party) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if(partyService.findPartyByName(party.getName()) != null) {
            errors.rejectValue("name", "duplicate.partyform.name");
        }
    }
}
