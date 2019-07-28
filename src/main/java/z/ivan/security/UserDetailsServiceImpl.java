package z.ivan.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import z.ivan.dao.RoleDao;
import z.ivan.dao.UserDao;
import z.ivan.model.User;

import java.util.Objects;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;
//    private RoleDao roleDao;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public UserDetailsServiceImpl(UserDao userDao/*, RoleDao roleDao*/) {
        this.userDao = userDao;
//        this.roleDao = roleDao;
    }

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        User user = userDao.getByLogin(loginName);

        System.out.println("----- in loadUserByUsername()");
        System.out.println(user);
        UserBuilder builder;

        if (user != null) {
            builder = withUsername(user.getLogin());
            builder.password(passwordEncoder().encode(String.valueOf(user.getPassword())));

            String role;
            if (user.getRoleId() == 1) {
                role = "Admin";
            } else if (user.getRoleId() == 2) {
                role = "Tutor";
            } else {
                role = "User";
            }
            builder.roles(role);

        } else {
            throw new UsernameNotFoundException("User not found: " + loginName);
        }

        final UserDetails userDetails = builder.build();

        System.out.println("userDetails:");
        System.out.println(userDetails);
        System.out.println("userDetails.getPassword(): " + userDetails.getPassword());
        System.out.println("----- out loadUserByUsername()");

        return userDetails;
    }
}
