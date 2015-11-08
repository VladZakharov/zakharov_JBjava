package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String getIndexPage(Model model) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (currentUser == null) {
            return "redirect:/new-login";
        }
        model.addAttribute("user", userService.getUser(currentUser.getId()));
        return "new-index";
    }


}