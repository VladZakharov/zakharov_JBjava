package ru.kpfu.itis.controller;

import org.springframework.ui.Model;
import service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vlad on 20.12.15.
 */
@Controller
public class HelloController {

    MessageService messageService = new MessageService();

    @RequestMapping(value = "/")
    public String getIndex(Model model) {
        model.addAttribute("message", messageService.getMessage());
        return "index";
    }

}
