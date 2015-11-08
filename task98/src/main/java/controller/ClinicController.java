package controller;

import model.MedicalClinic;
import model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ClinicService;
import util.Generator;

/**
 * Created by vlad on 27.10.15.
 */
@Controller
@RequestMapping(value = "/clinics")
public class ClinicController {

    @Autowired
    ClinicService clinicService;

    @RequestMapping(value = "/add")
    public String addClinic(Model model) {
        MedicalClinic clinic = new MedicalClinic();
        model.addAttribute("clinic", clinic);
        return "add-clinic";
    }

    @RequestMapping(value = "/add/process")
    public String addingProcess(@ModelAttribute MedicalClinic clinic, BindingResult result) {
//        validator.validate(clinic, result);
//        if (result.hasErrors()) {
//            return "add-clinic";
//        } else {
        clinic.setCreating_date(Generator.dateBefore());
        clinicService.addClinic(clinic);
        return "redirect:/";
//        }
    }

    @RequestMapping(value = "/{id}")
    public String clinicInfo(@PathVariable("id") Integer id, Model model) {
        MedicalClinic clinic = clinicService.getClinic(id);
        model.addAttribute("medicalClinic", clinic);
        model.addAttribute("offices", clinicService.getClinicOffices(id));
        model.addAttribute("avgSalary", clinicService.getAverageSalary(id));
        model.addAttribute("avgCost", clinicService.getAverageCost(id));
        model.addAttribute("profit", clinicService.getNetProfit(id));
        return "clinic-info";
    }

    @RequestMapping(value = "/{id}/add_office")
    public String addOffice(@PathVariable("id") Integer id, Model model) {
        Office office = new Office();
        model.addAttribute("clinic_id", id);
        model.addAttribute("office", office);
        return "add-office";
    }

    @RequestMapping(value = "/{id}/add_office/process")
    public String addingOffice(@PathVariable("id") Integer clinic_id, @ModelAttribute Office office, BindingResult result) {
//        validator.validate(clinic, result);
//        if (result.hasErrors()) {
//            return "add-clinic";
//        } else {
        office.setMedicalClinic(clinicService.getClinic(clinic_id));
        clinicService.addOffice(office);
        return "redirect:/clinics/" + clinic_id;
//        }
    }

}
