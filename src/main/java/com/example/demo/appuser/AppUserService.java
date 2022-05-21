package com.example.demo.appuser;

import java.util.List;

public interface AppUserService {

    List<AppUser> fetchAllUsers();

    AppUser findUserByEmail(String email);

    AppUser saveUser(AppUser appUser);

}
