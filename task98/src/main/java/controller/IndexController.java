package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ClinicService;

@Controller
public class IndexController {

    @Autowired
    ClinicService clinicService;

    @RequestMapping(value = "/")
    public String getMainPage(Model model) {
        model.addAttribute("clinics", clinicService.getAllClinics());
        return "main";
    }

}
