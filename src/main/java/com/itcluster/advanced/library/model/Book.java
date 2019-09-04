package com.itcluster.advanced.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Set<Author> author;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String annotation;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name="publicity_id", nullable=false)
    private Publicity publicity;

    private String published;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Set<Genre> genre;

    private Integer pages;
}
