package com.transaction.model;

import lombok.*;

import java.util.Date;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Person {
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String jobPosition;
    private String email;
    private Date dob;
}
