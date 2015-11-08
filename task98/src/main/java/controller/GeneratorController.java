package controller;

import model.*;
import model.enums.PeopleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ClinicService;
import service.OfficeService;
import service.PeopleService;
import service.ProviderService;
import util.Generator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

/**
 * Created by vlad on 30.10.15.
 */
@Controller
@RequestMapping(value = "/generate")
public class GeneratorController {

    private int office_min = 1;
    private int office_max = 5;

    private int patient_min = 10;
    private int patient_max = 60;

    private int stuff_min = 3;
    private int stuff_max = 10;

    private int provider_min = 1;
    private int provider_max = 3;

    @PersistenceContext
    EntityManager em;

    @Autowired
    ClinicService clinicService;

    @Autowired
    OfficeService officeServise;

    @Autowired
    PeopleService peopleServise;

    @Autowired
    ProviderService providerService;

    private static Integer clinic_id = 0;
    private static Integer office_id = 0;
    private static Integer patient_id = 0;
    private static Integer stuff_id = 0;
    private static Integer provider_id = 0;

    public void generateClinics(int n) {
        ;
        int stop = clinic_id + n;
        for (int i = 0; clinic_id < stop; clinic_id++, i++) {
            generateClinic("Generated Clinic №" + clinic_id);
        }
    }

    public void generateClinic(String name) {
        int license_n = (int) (Math.random() * 10e6);
        MedicalClinic clinic = new MedicalClinic(name, Generator.dateBefore(), license_n);
        clinicService.addClinic(clinic);

        generateOffices(Generator.integer(office_min, office_max), clinic);
    }

    public void generateOffices(int n, MedicalClinic clinic) {
        int stop = office_id + n;
        for (int i = 0; office_id < stop; office_id++, i++) {
            generateOffice("Generated Office №" + office_id, clinic);
        }
    }

    public void generateOffice(String name, MedicalClinic clinic) {
        Office office = new Office(Generator.city(), clinic, Generator.street());
        office = clinicService.addOffice(office);
        generatePatients(Generator.integer(patient_min, patient_max), office);
        generateStuffs(Generator.integer(stuff_min, stuff_max), office);
        generateProviders(Generator.integer(provider_min, provider_max), office);
        generateOperationSuppliers(office);
    }

    public void generatePatients(int n, Office office) {
        int stop = patient_id + n;
        for (int i = 0; patient_id < stop; patient_id++, i++) {
            generatePatient("Generated Patient №" + patient_id, office);
        }
    }

    public void generatePatient(String name, Office office) {
        People people = new People(name,
                Generator.passportSeries(),
                Generator.passportNumber(),
                Generator.passportIssued(),
                PeopleType.PATIENT,
                office);
        people = officeServise.addPeople(people);
        generatePatientData(people);
    }

    public void generatePatientData(People people) {
        PatientData data = new PatientData(Generator.dateBefore(), Generator.integer(2000, 200000), people);
        peopleServise.addData(data);
    }

    public void generateStuffs(int n, Office office) {
        int stop = stuff_id + n;
        for (int i = 0; stuff_id < stop; stuff_id++, i++) {
            generateStuff("Generated Stuff №" + stuff_id, office);
        }
    }

    public void generateStuff(String name, Office office) {
        People people = new People(name,
                Generator.passportSeries(),
                Generator.passportNumber(),
                Generator.passportIssued(),
                PeopleType.STUFF,
                office);
        people = officeServise.addPeople(people);
        generateStuffData(people);
    }

    public void generateStuffData(People people) {
        Date ed = Generator.dateBefore();
        StuffData data = new StuffData(ed, Generator.dateOrNull(ed, new Date()), Generator.integer(3, 14) * 4, Generator.integer(10, 80) * 10, people);
        peopleServise.addData(data);
    }

    public void generateProviders(int n, Office office) {
        int stop = provider_id + n;
        for (int i = 0; provider_id < stop; provider_id++, i++) {
            generateProvider("Generated Provider №" + provider_id, office);
        }
    }

    public void generateProvider(String name, Office office) {
        JuridicalInfo ji = new JuridicalInfo(Generator.passportSeries(), Generator.passportNumber());
        officeServise.addJI(ji);
        Provider provider = new Provider(name, ji, office);
        officeServise.addProvider(provider);
    }

    public void generateOperationSuppliers(Office office) {
        for (Provider p : officeServise.getOfficeProviders((int) office.getId())) {
            generateOperationSupplier(office,p);
        }
    }

    public void generateOperationSupplier(Office office, Provider provider) {
        Date begin_date = Generator.dateBefore();
        OperationSupplier op = new OperationSupplier(begin_date, Generator.dateOrNull(begin_date, new Date()), office, Generator.integer(1,30), provider);
        officeServise.addOperationSupplier(op);
    }

    @RequestMapping(value = "/auto/{n}")
    public String auto(@PathVariable("n") Integer n) {
        generateClinics(n);
        return "redirect:/";
    }

    @RequestMapping(value = "/drop_db")
    public String dropDB() {
        clinicService.dropAll();
        return "redirect:/";
    }

}
