package z.ivan.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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
            session.setAttribute("role", "admin");
            return new ModelAndView("redirect: /admin/admin_main");
        } else if ("[ROLE_TUTOR]".equalsIgnoreCase(role)) {
            session.setAttribute("role", "tutor");
            return new ModelAndView("redirect: /tutor/tutor_main");
        } else if ("[ROLE_USER]".equalsIgnoreCase(role)) {
            session.setAttribute("role", "user");
            return new ModelAndView("redirect: /");
        } else {
            return new ModelAndView("redirect: /welcome");
        }

    }
}
