package com.check.configs;

import com.check.command.Command;
import com.check.command.UpdateUserInfoCommand;
import com.check.repositories.JPARepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

import static com.check.repositories.JPARepository.UserRepository.Specs.byUsername;

@Configuration
@RequiredArgsConstructor
@EnableJpaRepositories(basePackages = "com.check.repositories.JPARepository")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ApplicationConfig {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DataSource dataSource;
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findOne(byUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    @Bean
    public UpdateUserInfoCommand updateUserInfoCommand(){
        return new UpdateUserInfoCommand(userRepository);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
