package com.akash.discoveryserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${eureka.username}")
    private String username;

    @Value("${eureka.password}")
    private String password;

//    @Override
//    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder.inMemoryAuthentication()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .withUser(username).password(password)
//                .authorities("USER");
//    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
//        authenticationManagerBuilder.inMemoryAuthentication()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .withUser(username).password(password)
//                .authorities("USER");

        UserDetails user = User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .authorities("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }


//    @Override
//    public void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest()
//                        .authenticated())
//                .httpBasic(Customizer.withDefaults());
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

}
