package com.J6D66;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http  	.csrf(csrf -> csrf.disable())
				.cors(cors -> cors.disable())
				.authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().permitAll())
				.formLogin(formLogin -> formLogin
                        .loginPage("/auth/login/form")
                        .loginProcessingUrl("/auth/login")
                        .defaultSuccessUrl("/auth/login/success",false)
                        .failureUrl("/auth/login/error")
                ).logout(logout -> logout
                		.logoutUrl("/auth/logoff")
                		.logoutSuccessUrl("/auth/logoff/success"))
				.exceptionHandling(denied->denied.accessDeniedPage("/auth/access/denied")
				);
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails = User.builder()
				.username("user")
				.password(passwordEncoder().encode("123"))
				.roles("USER","GUEST")
				.build();
		UserDetails userDetails2 = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("123"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(userDetails,userDetails2);
	}
	@Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(authenticationProvider);
    }
}
