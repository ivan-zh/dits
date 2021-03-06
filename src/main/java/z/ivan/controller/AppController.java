package z.ivan.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class AppController {

    @GetMapping({"/", "/welcome"})
    public ModelAndView root(HttpServletRequest request) {

        HttpSession session = request.getSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String role = authorities.toString();

        if ("[ROLE_ADMIN]".equalsIgnoreCase(role)) {
            session.setAttribute("role", "Admin");
            return new ModelAndView("redirect: /admin/admin_main");
        } else if ("[ROLE_TUTOR]".equalsIgnoreCase(role)) {
            session.setAttribute("role", "Tutor");
            return new ModelAndView("redirect: /tutor/tutor_main");
        } else if ("[ROLE_USER]".equalsIgnoreCase(role)) {
            String name = authentication.getName();
            request.getSession().setAttribute("login", name);
            session.setAttribute("role", "User");
            return new ModelAndView("redirect: /user/user_main");
        } else {
            return new ModelAndView("redirect: /welcome");
        }
    }
}
