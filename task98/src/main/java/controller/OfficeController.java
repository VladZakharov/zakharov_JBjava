package controller;

import model.*;
import model.enums.PeopleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.OfficeService;

/**
 * Created by vlad on 28.10.15.
 */
@Controller
@RequestMapping(value = "/offices")
public class OfficeController {

    @Autowired
    OfficeService officeServise;

    @RequestMapping(value = "/{id}")
    public String officeInfo(@PathVariable("id") Integer id, Model model) {
        Office office = officeServise.getOffice(id);
        model.addAttribute("office", office);
        model.addAttribute("patients",officeServise.getOfficePatients(id));
        model.addAttribute("stuffs",officeServise.getOfficeStuffs(id));
        model.addAttribute("providers",officeServise.getOfficeProviders(id));
        model.addAttribute("operSupps",officeServise.getOperationSuppliers(id));
        model.addAttribute("avgSalary",officeServise.getAverageSalary(id));
        model.addAttribute("avgCost",officeServise.getAverageCost(id));
        return "office-info";
    }

    @RequestMapping(value = "/{id}/add_patient")
    public String addPatient(@PathVariable("id") Integer id, Model model) {
        People people = new People();
        model.addAttribute("office_id", id);
        model.addAttribute("people", people);
        model.addAttribute("type", PeopleType.PATIENT.toString());
        return "add-people";
    }

    @RequestMapping(value = "/{id}/add_Patient/process")
    public String addingPatient(@PathVariable("id") Integer id, @ModelAttribute People people, BindingResult result) {
//        validator.validate(clinic, result);
//        if (result.hasErrors()) {
//            return "add-clinic";
//        } else {
        people.setType(PeopleType.PATIENT);
        people.setOffice(officeServise.getOffice(id));
        officeServise.addPeople(people);
        return "redirect:/offices/" + id;
//        }
    }

    @RequestMapping(value = "/{id}/add_stuff")
    public String addStuff(@PathVariable("id") Integer id, Model model) {
        People people = new People();
        model.addAttribute("office_id", id);
        model.addAttribute("people", people);
        model.addAttribute("type", PeopleType.STUFF.toString());
        return "add-people";
    }

    @RequestMapping(value = "/{id}/add_Stuff/process")
    public String addingStuff(@PathVariable("id") Integer id, @ModelAttribute People people, BindingResult result) {
//        validator.validate(clinic, result);
//        if (result.hasErrors()) {
//            return "add-clinic";
//        } else {
        people.setType(PeopleType.STUFF);
        people.setOffice(officeServise.getOffice(id));
        officeServise.addPeople(people);
        return "redirect:/offices/" + id;
//        }
    }

    @RequestMapping(value = "/{id}/add_provider")
    public String addProvider(@PathVariable("id") Integer id, Model model) {
        Provider provider = new Provider();
//        JuridicalInfo juridicalInfo = new JuridicalInfo();
        model.addAttribute("office_id", id);
        model.addAttribute("provider", provider);
//        model.addAttribute("juridicalInfo", juridicalInfo);
        return "add-provider";
    }

    @RequestMapping(value = "/{id}/add_provider/process")
    public String addingProvider(@PathVariable("id") Integer id, @ModelAttribute Provider provider, BindingResult result) {
//        validator.validate(clinic, result);
//        if (result.hasErrors()) {
//            return "add-clinic";
//        } else {
        provider.setOffice(officeServise.getOffice(id));
        JuridicalInfo ji = new JuridicalInfo();
        ji.setNumber("default number");
        ji.setSeries("default series");
        provider.setJuridicalInfo(ji);
        officeServise.addJI(ji);
        officeServise.addProvider(provider);
        return "redirect:/offices/" + id;
//        }
    }

    @RequestMapping(value = "/{id}/get_up_delivery")
    public String getUpDelivery(@PathVariable("id") Integer id, Model model) {
        OperationSupplier os = new OperationSupplier();
        model.addAttribute("office_id", id);
        model.addAttribute("providers", officeServise.getOfficeProviders(id));
        model.addAttribute("os", os);
        return "set-delivery";
    }

}
