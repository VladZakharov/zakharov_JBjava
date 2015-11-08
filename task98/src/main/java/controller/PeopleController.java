package controller;

import model.People;
import model.enums.PeopleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.PeopleService;

/**
 * Created by vlad on 28.10.15.
 */
@Controller
@RequestMapping(value = "/peoples")
public class PeopleController {

    @Autowired
    PeopleService peopleServise;

    @RequestMapping(value = "/{id}")
    public String peopleInfo(@PathVariable("id") Integer id, Model model) {
        People people = peopleServise.getPeople(id);
        model.addAttribute("people", people);
        if (people.getType().equals(PeopleType.PATIENT)) {
            model.addAttribute("patientData", peopleServise.getPatientData(id));
        } else {
            model.addAttribute("stuffData", peopleServise.getStuffData(id));
            model.addAttribute("monthSalary", peopleServise.getMonthSalary(id));
        }
        return "people-info";
    }

}
