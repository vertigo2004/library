package com.itcluster.advanced.library.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String first_name;
    private String last_name;
    private Date dob;
}
