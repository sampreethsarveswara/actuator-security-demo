package com.example.actuatordemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class WebSecurityConfig {

  @Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
    httpSecurity.authorizeExchange()
            .pathMatchers("/actuator","/actuator/*")
            .permitAll()
            .anyExchange()
            .authenticated()
            .and()
            .httpBasic();
    return httpSecurity.build();
  }
}
