package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ProviderService;

@Controller
@RequestMapping(value = "/providers")
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @RequestMapping(value = "/all")
    public String getAll(Model model) {
        model.addAttribute("providers", providerService.getAllProviders());
        return "all-providers";
    }

    @RequestMapping(value = "/{id}")
    public String getAll(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("provider", providerService.getProvider(id));
        return "provider-info";
    }

}
