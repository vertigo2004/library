package com.itcluster.advanced.library.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Must not be blank")
    @Email(message = "Must be a valid email address")
    private String email;
    @NotBlank(message = "Must not be blank")
    private String password;
    @NotBlank(message = "Must not be blank")
    private String firstname;
    @NotBlank(message = "Must not be blank")
    private String lastname;
    private Date dob;
    private String photo;

    @ManyToMany
    @JoinTable(name = "user_role",  inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
