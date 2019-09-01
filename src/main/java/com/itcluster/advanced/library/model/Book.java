package com.itcluster.advanced.library.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
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
public class Book {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String title;
    private String annotation;

    @ManyToOne
    @JoinColumn(name="publicity_id", nullable=false)
    private Publicity publicity;

    private String published;

    @ManyToMany
    private Set<Genre> genre;

    private Integer pages;
}
