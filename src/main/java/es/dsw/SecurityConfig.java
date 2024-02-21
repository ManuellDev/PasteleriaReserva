package es.dsw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import es.dsw.service.UserDetailsServiceImpl;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	 @Autowired
	 private UserDetailsServiceImpl userDetailsService;
	 @Autowired
	 private PasswordEncoder passwordEncoder;
  

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())//Si se descomenta esta línea, no se requiere token csrf cada vez que debas realizar envío de datos al servidor. Se recomienda no realizar csrf.disable()

                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/img/**").permitAll()
                        .requestMatchers("/styles/**").permitAll()
                        .requestMatchers("/js/**").permitAll()
                        .requestMatchers("/bootstrap/**").permitAll()
                        .requestMatchers("/registro/**").permitAll()
                        .requestMatchers("/BackOffice**").hasRole("admin")
                        .requestMatchers("/BackOffice**").hasRole("pastelero")
                        .anyRequest().authenticated()

                )
                .httpBasic(withDefaults())
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/logginprocess")
                        .permitAll()


                )

                .logout((logout) -> logout.logoutSuccessUrl("/login").permitAll());

        return http.build();
    }


 
   
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
    
  

}


	                   

