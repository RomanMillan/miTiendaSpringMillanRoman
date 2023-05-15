package com.jacaranda.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.jacaranda.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private UserService myUserDetailService;

// Indicamos que la configuración se hará a travéx del servicio.
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailService);
	}

// Método que usaremos más abajo
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserService();
	}

// Método que nos suministrará la codificación
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

// Método que autentifica
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> {
			requests.requestMatchers("/usuario/add").permitAll()
			.requestMatchers("/").permitAll()
			.requestMatchers("/userAddSubmit").permitAll()

//			Acceso solo a los administradores
//			category access (add, update, delete)
			.requestMatchers("/categoria/add").hasAnyAuthority("ADMIN")
			.requestMatchers("/categoryAddSubmit").hasAnyAuthority("ADMIN")
			.requestMatchers("/categoria/delete/**").hasAnyAuthority("ADMIN")
			.requestMatchers("/categoryDeleteSubmit").hasAnyAuthority("ADMIN")
			.requestMatchers("/categoria/update/**").hasAnyAuthority("ADMIN")
			.requestMatchers("/categoryUpdateSubmit").hasAnyAuthority("ADMIN")
//			element access (add, update, delete)
			.requestMatchers("/articulo/add").hasAnyAuthority("ADMIN")
			.requestMatchers("/elementAddSubmit").hasAnyAuthority("ADMIN")
			.requestMatchers("/articulo/delete/**").hasAnyAuthority("ADMIN")
			.requestMatchers("/elementDeleteSubmit").hasAnyAuthority("ADMIN")
			.requestMatchers("/articulo/update/**").hasAnyAuthority("ADMIN")
			.requestMatchers("/elementUpdateSubmit").hasAnyAuthority("ADMIN")
//			user access (get, update, delete)
			.requestMatchers("/usuario/list").hasAnyAuthority("ADMIN")
			.requestMatchers("/usuario/admin/**").hasAnyAuthority("ADMIN")
			.requestMatchers("/userAdminSubmit").hasAnyAuthority("ADMIN")
			.requestMatchers("/usuario/delete/**").hasAnyAuthority("ADMIN")
			.requestMatchers("/userDeleteSubmit").hasAnyAuthority("ADMIN")
			
//			Acceso solo rol USER
			.requestMatchers("/usuario/update/**").hasAnyAuthority("USER")
			.requestMatchers("/userUpdateSubmit").hasAnyAuthority("USER")
			
//			Acceso a todos los registrados
			.requestMatchers("/articulo/list").authenticated()
			.requestMatchers("/categoria/list").authenticated()

//          Acceso a cualquier request
			.anyRequest().permitAll();
			
			
		})
		.formLogin((form) -> form
				.loginPage("/login")
				.permitAll().defaultSuccessUrl("/categoria/list"))
				.logout((logout) -> logout.permitAll());
				return http.build();
		}
}
