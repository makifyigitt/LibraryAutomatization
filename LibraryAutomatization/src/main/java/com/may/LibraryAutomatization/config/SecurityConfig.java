//package com.may.LibraryAutomatization.config;
//
//import com.may.LibraryAutomatization.auth.AuthUserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final AuthUserService authUserService;
//
//    public SecurityConfig(AuthUserService authUserService) {
//        this.authUserService = authUserService;
//    }
//
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//
//        http.httpBasic()
//                .and()
//                .authorizeRequests()
//                    .antMatchers(HttpMethod.GET,"/api/**").hasAnyRole("USER")
//                    .antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("ADMIN")
//                    .antMatchers(HttpMethod.PUT,"/api/**").hasAnyRole("USER")
//                    .antMatchers(HttpMethod.POST,"/api/**").hasAnyRole("USER")
//                .and()
//                .csrf().disable() //güvenlik açıklarını önlemek için.
//                .formLogin(); //stock bir form üzerinden giriş almak için.
//
//
//
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(authUserService);
//        provider.setPasswordEncoder(passwordEncoder());
//        return provider;
//    }
//}
