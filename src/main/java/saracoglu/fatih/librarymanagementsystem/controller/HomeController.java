package saracoglu.fatih.librarymanagementsystem.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String index() {
        return "redirect:login";
    }

    @GetMapping("/login")
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) {
            for (GrantedAuthority grantedAuthority : auth.getAuthorities()){
                if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                    return "redirect:home";
                } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                    return "redirect:admin";
                }
            }
        } else {
            return "login";
        }
        return "login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
