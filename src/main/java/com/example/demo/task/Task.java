package com.example.demo.task;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
