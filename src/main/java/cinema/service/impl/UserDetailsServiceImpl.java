package cinema.service.impl;

import static org.springframework.security.core.userdetails.User.withUsername;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.UserService;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByEmail(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            org.springframework.security.core.userdetails.User.UserBuilder userBuilder = withUsername(username);
            userBuilder.password(user.getPassword());
            userBuilder.roles(user.getRoles().stream()
                    .map(Role::getRoleName)
                    .toArray(String[]::new));
            return userBuilder.build();
        }
        throw new UsernameNotFoundException("User " + username + " not found");
    }
}
