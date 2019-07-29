package z.ivan.security;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import z.ivan.dao.UserDao;
import z.ivan.model.User;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        User user = userDao.getByLogin(loginName);

        UserBuilder builder;
        if (user != null) {
            builder = withUsername(user.getLogin());
            builder.password(String.valueOf(user.getPassword()));

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

        return builder.build();
    }
}
