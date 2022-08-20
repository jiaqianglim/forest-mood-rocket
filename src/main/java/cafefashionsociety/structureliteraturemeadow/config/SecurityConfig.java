package cafefashionsociety.structureliteraturemeadow.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import cafefashionsociety.structureliteraturemeadow.model.User;
import cafefashionsociety.structureliteraturemeadow.repository.IUserRepository;

@Configuration
public class SecurityConfig {

    @Autowired
    IUserRepository iUserRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            User user = iUserRepository.findByUsername(username);
            if (user != null)
                return user;
            throw new UsernameNotFoundException("User not found");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // @Bean
    // public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder)
    // {

    // List<UserDetails> usersList = new ArrayList<>();

    // usersList.add(new User("buzz", passwordEncoder.encode("password"),
    // Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
    // usersList.add(new User("woody", passwordEncoder.encode("password"),
    // Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
    // InMemoryUserDetailsManager userDetailsService = new
    // InMemoryUserDetailsManager(usersList);
    // return userDetailsService;
    // }
}