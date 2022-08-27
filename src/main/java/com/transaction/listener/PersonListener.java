package com.transaction.listener;

import com.transaction.entity.PersonEntity;
import com.transaction.model.Person;
import com.transaction.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class PersonListener {

    private final PersonService personService;

    @JmsListener(destination = "${person.jms.topic}", containerFactory = "personJmsContFactory")
    public void getPersonListener1(Person person) {
        log.info("Person listener1: " + person);
        personService.savePerson(person);
    }

    @JmsListener(destination = "${person.jms.topic}", containerFactory = "personJmsContFactory")
    public void getPersonListener2(Person person) {
        log.info("Person Listener2: " + person);
        personService.savePerson(person);
    }
}