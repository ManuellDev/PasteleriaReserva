package es.dsw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import es.dsw.models.Roles;
import es.dsw.models.User;
import es.dsw.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar el usuario por su nombre de usuario
        User user = userRepository.findByUsername(username);
        // Si no existe, lanzar una excepción
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
     // Cargar los roles del usuario
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (Roles role : user.getRoles()) {
            // Concatenar "ROLE_" al rol antes de agregarlo como autoridad
            String roleName = "ROLE_" + role.getRoleCode();
            authorities.add(new SimpleGrantedAuthority(roleName));
        }
        System.out.println(authorities);
        
        // Devolver el objeto UserDetails con los roles cargados
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), 
                user.getPassword(), 
                authorities);
    }
    
}
