package com.transaction.service;


import com.transaction.entity.PersonEntity;
import com.transaction.mapper.PersonMapper;
import com.transaction.model.Person;
import com.transaction.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonMapper personMapper;
    private final PersonRepository personRepository;


    @Transactional
    public PersonEntity savePerson(Person person) {
        log.info("save person");
        PersonEntity personEntity = personMapper.convertToEntity(person);
//        PersonEntity personEntity = PersonEntity
//                .builder()
//                .username(person.getUsername())
//                .firstname(person.getFirstname())
//                .lastname(person.getLastname())
//                .email(person.getEmail())
//                .jobPosition(person.getJobPosition())
//                .dob(person.getDob())
//                .build();
        log.info("person entity after mapping " + personEntity);
        personEntity = personRepository.saveAndFlush(personEntity);
        log.info("person entity after saving " + personEntity);
        return personEntity;
    }

}
