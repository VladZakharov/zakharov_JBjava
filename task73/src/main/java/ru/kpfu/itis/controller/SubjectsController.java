package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.model.Subject;
import ru.kpfu.itis.service.StudentService;
import ru.kpfu.itis.service.SubjectService;

import java.util.List;

@Controller
@RequestMapping(value = "/scores")
public class SubjectsController {

    @Autowired
    SubjectService subjectService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/{stud_id}/{sub_id}/remove")
    public String editSubjects(@PathVariable("stud_id") Integer stud_id, @PathVariable("sub_id") Integer sub_id, Model model) {
        subjectService.removeSubject(sub_id);
        String stud_name = studentService.getStudent(stud_id).getName();
        Subject sub = new Subject();
        model.addAttribute("subject", sub);
        model.addAttribute("student_id", stud_id);
        model.addAttribute("student_name", stud_name);
        model.addAttribute("aScore", subjectService.getAverageScore(stud_id));
        model.addAttribute("tScore", subjectService.getTotalScore(stud_id));
        List<Subject> subs = studentService.getStudentSubjects(stud_id);
        model.addAttribute("subjects", subs);
        return "redirect:/students/" + stud_id + "/info";
    }

}
