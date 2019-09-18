package com.itcluster.advanced.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String middlename;
    private String lastname;
    @Column(columnDefinition = "DATE")
    private Date dob;
}
