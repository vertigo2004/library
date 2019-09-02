package com.itcluster.advanced.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String title;
    private String annotation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="publicity_id", nullable=false)
    private Publicity publicity;

    private String published;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Genre> genre;

    private Integer pages;
}
