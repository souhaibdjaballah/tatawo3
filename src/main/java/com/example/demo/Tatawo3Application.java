package com.example.demo;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import static com.example.demo.appuser.AppUserRole.ADMIN;
import static com.example.demo.appuser.AppUserRole.USER;

@SpringBootApplication
public class Tatawo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Tatawo3Application.class, args);
	}

	@Bean
	CommandLineRunner run(AppUserServiceImpl appUserService){
		return args -> {

			// Add users

			appUserService.saveUser(new AppUser("Khabib", "Normagomedov", "the_eagle",
					"khabib@test.com", "pass", ADMIN, true, false));

			appUserService.saveUser(new AppUser("Mohamed", "Ali", "the_greatest",
					"the.greatest@test.com", "pass", USER, true, false));

			appUserService.saveUser(new AppUser("Mike", "Tyson", "tyson",
					"tyson@test.com", "pass", USER, false, false));

			appUserService.saveUser(new AppUser("Nassim", "Hamid", "nassim",
					"nassim@test.com", "pass", ADMIN, true, true));

		};
	}


	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true); // we USUALLY want this
		config.addAllowedOrigin("http://localhost:4200"); // for local front-end communication (Angular)
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
