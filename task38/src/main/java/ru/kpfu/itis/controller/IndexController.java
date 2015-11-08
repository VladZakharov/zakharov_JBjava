package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.model.Record;
import ru.kpfu.itis.service.RecordService;
import ru.kpfu.itis.util.RecordValidator;

@Controller
public class IndexController {

    @Autowired
    RecordService recordService;

    RecordValidator validator = new RecordValidator();

    @RequestMapping(value = "/")
    public String getIndexPage(Model model) {
        model.addAttribute("record", new Record());
        return "index";
    }

    @RequestMapping(value = "/all")
    public String showAllUsers(Model model) {
        model.addAttribute("records", recordService.getAllRecords());

        return "all-records";
    }

    @RequestMapping(value = "/add_record", method = RequestMethod.POST)
    public String saveRecord(@ModelAttribute Record record, BindingResult result) {
        validator.validate(record, result);
        if (result.hasErrors()) {
            return "index";
        } else {
            recordService.addRecord(record);
            return "redirect:/all";
        }
    }

}
