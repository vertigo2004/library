package com.itcluster.advanced.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
public class Publicity {
    @Id
    @GeneratedValue
    private Long Id;
    private String name;
}
