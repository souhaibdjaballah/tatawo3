package com.example.demo.appuser;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserServiceImpl appUserService;

    @GetMapping("/users")
    public List<AppUser> fetchAllUsers(){
        return appUserService.fetchAllUsers();
    }

    @GetMapping("/user")
    public AppUser fetchUserByEmail(@PathVariable(name = "email") String email){
        return appUserService.findUserByEmail(email);
    }

    @PostMapping("/addUser")
    public AppUser addUser(@RequestBody AppUser appUser){
        return appUserService.saveUser(appUser);
    }


}
