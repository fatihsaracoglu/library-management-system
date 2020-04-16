package saracoglu.fatih.librarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import saracoglu.fatih.librarymanagementsystem.dto.UserDto;
import saracoglu.fatih.librarymanagementsystem.model.User;
import saracoglu.fatih.librarymanagementsystem.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserDto userRegistrationDto() {
        return new UserDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) {
            for (GrantedAuthority grantedAuthority : auth.getAuthorities()){
                if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                    return "redirect:home";
                }else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                    return "redirect:admin";
                }
            }
        }

        return "signup";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
                                      BindingResult result){

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "signup";
        }

        userService.save(userDto);
        return "redirect:/signup?success";
    }

}
