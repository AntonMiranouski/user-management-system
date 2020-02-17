package anton.miranouski.user_management.service;

import anton.miranouski.user_management.model.AuthenticationUserDetails;
import anton.miranouski.user_management.model.UserAccount;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAccountService userService;

    public UserDetailsServiceImpl(UserAccountService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserAccount user = userService.findByUsername(username);
        final Set<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toSet());
        return new AuthenticationUserDetails(
                user.getUsername(), user.getPassword(), user.isActive(), authorities
        );
    }
}
