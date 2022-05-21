package com.example.demo.appuser;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole = AppUserRole.USER;
    private Boolean enabled = false;
    private Boolean locked = false;

    public AppUser(String firstName, String lastName, String username, String email, String password, AppUserRole appUserRole, Boolean enabled, Boolean locked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.enabled = enabled;
        this.locked = locked;
    }
}
