package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.model.Student;
import ru.kpfu.itis.model.Subject;
import ru.kpfu.itis.service.StudentService;
import ru.kpfu.itis.service.SubjectService;
import ru.kpfu.itis.util.StudentFormValidator;

import java.util.List;

@Controller
@RequestMapping(value = "/students")
public class StudentsController {

    @Autowired
    StudentService studentService;

    @Autowired
    SubjectService subjectService;

    StudentFormValidator validator = new StudentFormValidator();

    @RequestMapping(value = "/all")
    public String showAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "all-students";
    }

    @RequestMapping(value = "/add")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add-student";
    }

    @RequestMapping(value = "/{id}/info")
    public String editSubjects(@PathVariable("id") Integer id, Model model) {
        String stud_name = studentService.getStudent(id).getName();
        Subject sub = new Subject();
        model.addAttribute("subject", sub);
        model.addAttribute("student_id", id);
        model.addAttribute("student_name", stud_name);
        model.addAttribute("aScore", subjectService.getAverageScore(id));
        model.addAttribute("tScore", subjectService.getTotalScore(id));
        List<Subject> subs = studentService.getStudentSubjects(id);
        model.addAttribute("subjects", subs);
        return "student-info";
    }

    @RequestMapping(value = "/add_student", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute Student student, BindingResult result) {
        validator.validate(student, result);
        if (result.hasErrors()) {
            return "add-student";
        } else {
            studentService.addStudent(student);
            return "redirect:/students/all";
        }
    }

    @RequestMapping(value = "{id}/set_scores")
    public String setSubjects(@ModelAttribute Subject sub, @PathVariable("id") Integer id) {
        sub.setStudentId(studentService.getStudent(id));
        subjectService.addScore(sub);
        return "redirect:/students/" + id + "/info";
    }

}
