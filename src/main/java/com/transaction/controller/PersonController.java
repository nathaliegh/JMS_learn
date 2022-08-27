package com.transaction.controller;

import com.transaction.entity.PersonEntity;
import com.transaction.model.Person;
import com.transaction.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Topic;

@Slf4j
@RestController
@AllArgsConstructor
public class PersonController {

    private final JmsTemplate jmsTemplate;

    private final PersonService personService;

    /**
     * Create new person
     *
     * @param person
     * @return ResponseEntity
     */
    @PostMapping("/person")
    public ResponseEntity<Person> newPerson(@RequestBody Person person) {
        try {
            log.info("Creating new Person " + person);
            Topic personTopic = jmsTemplate.getConnectionFactory().createConnection()
                    .createSession().createTopic("PersonTopic");
            jmsTemplate.convertAndSend(personTopic, person);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
