package z.ivan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "z.ivan")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;
    private PasswordEncoder encoder;

    @Autowired
    public WebSecurityConfig(UserDetailsService service, PasswordEncoder encoder) {
        this.userDetailsService = service;
        this.encoder = encoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
        /*auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder.encode("admin"))
                .roles("Admin");*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/login", "/logout", "/").permitAll();

        http.authorizeRequests()
                .antMatchers("/", "/login", "/resources/**", "/resources/images/**", "/css/**").permitAll()//

                .antMatchers("/admin/**").hasAnyRole("Admin")//
                .antMatchers("/tutor/statistics/**").hasAnyRole("Admin", "Tutor")//
                .antMatchers("/display_table/**").hasAnyRole("Admin")//

                .antMatchers("/tutor/**").hasAnyRole("Tutor")//
                .antMatchers("/user/**").hasAnyRole("User")//

                .antMatchers("/requests").hasAnyRole("Admin", "Tutor")//

                .anyRequest().authenticated()//
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/welcome")
                .failureUrl("/login?error=true")
                .usernameParameter("loginname")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .and()
                .csrf().disable();

    }
}
