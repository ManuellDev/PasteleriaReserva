package es.dsw;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import static org.springframework.security.config.Customizer.withDefaults;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	private static InMemoryUserDetailsManager InMemory=new InMemoryUserDetailsManager();
 
    

	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http
			.csrf(csrf -> csrf.disable())//Si se descomenta esta línea, no se requiere token csrf cada vez que debas realizar envío de datos al servidor. Se recomienda no realizar csrf.disable() 

	   		.authorizeHttpRequests((authorize) -> authorize
				   					.requestMatchers("/img/**").permitAll()
				   					.requestMatchers("/styles/**").permitAll()
				   					.requestMatchers("/js/**").permitAll()
				   					.requestMatchers("/bootstrap/**").permitAll()
				   					.requestMatchers("/templates/**").permitAll()
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
	@SuppressWarnings("deprecation")
	@Bean
	 InMemoryUserDetailsManager UserDetailsService() {
	                    // Crear el UserDetails con roles y agregarlo a InMemoryUserDetailsManager
	                    UserDetails user = User.withDefaultPasswordEncoder()
	                            .username("prueba")
	                            .password("1234")
	                            .build();
	                InMemory.createUser(user);
	           
		return InMemory;
	}
}