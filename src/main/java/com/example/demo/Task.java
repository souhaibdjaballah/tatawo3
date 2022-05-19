package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(generator = "increment")
    private Long id;

//    @Email
//    @NotBlank
    private String email;
//    @NotNull
    private String name;
    private String author;
    private String description;

}
