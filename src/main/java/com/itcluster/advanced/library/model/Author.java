package com.itcluster.advanced.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "middle_name")
    private String middlename;
    @Column(name = "last_name")
    private String lastname;
    @Column(columnDefinition = "DATE")
    private Date dob;
}
