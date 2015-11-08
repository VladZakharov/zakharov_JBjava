package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import java.util.List;

@Controller
public class UserPageController {

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public String users(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "new-users";
    }

    @RequestMapping("/id{user_id}")
    public String userPage(@PathVariable("user_id") Long id, Model model) {
        User user = userService.getUser(id);
        if (user == null) {
            return "404";
        }
        model.addAttribute("user", user);
        return "new-index";
    }

    @RequestMapping("/{user_login}")
    public String userPage(@PathVariable("user_login") String login, Model model) {
        try {
            User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (login.equals(currentUser.getLogin())) {
                return "redirect:/";
            }
        } catch (Exception e) {
            return "redirect:/";
        }
        User user = userService.getUser(login);
        if (user == null) {
            return "404";
        }
        model.addAttribute("user", user);
        return "new-index";
    }

    @RequestMapping("/settings")
    public String setupInfo(Model model) {
        try {
            User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return "new-setup";
        } catch (Exception e) {
            return "redirect:/";
        }
    }

    @RequestMapping("/get_settings")
    public String getSettings(Model model) {
        try {
            User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("me", currentUser);
            return "settings";
        } catch (Exception e) {
            return "redirect:/";
        }
    }

    @RequestMapping("/apply_settings")
    public String applySettings(@ModelAttribute("login") String login,
                                @ModelAttribute("name") String name,
                                @ModelAttribute("surname") String surname,
                                @ModelAttribute("city") String city,
                                @ModelAttribute("birthday") String birthday) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        currentUser.setLogin(login);
        currentUser.setName(name);
        currentUser.setSurname(surname);
        currentUser.setCity(city);
        currentUser.setBirthday(birthday);
        userService.updateUser(currentUser);
        return "new-index";
    }

}
