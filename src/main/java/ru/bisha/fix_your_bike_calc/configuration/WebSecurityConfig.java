package ru.bisha.fix_your_bike_calc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/items", "/index").permitAll()
                .antMatchers("/css/**", "/js/**", "/img/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().headers().defaultsDisabled()
                .and()
                .cors()
                .and()
                .headers()
                .cacheControl()
                .and()
                .contentTypeOptions()
                .and()
                .httpStrictTransportSecurity().disable()
                .and()
                .headers()
                .frameOptions().disable()
                .addHeaderWriter(new StaticHeadersWriter("X-FRAME-OPTIONS",
                        "ALLOW-FROM localhost",
                        "ALLOW-FROM easyridecycle.ru/",
                        "ALLOW-FROM example3.com",
                        "ALLOW-FROM example4.com",
                        "ALLOW-FROM example5.com"));
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
