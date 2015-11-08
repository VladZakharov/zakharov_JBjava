package service.impl;

import model.MedicalClinic;
import model.Office;
import model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClinicRepository;
import service.ClinicService;

import java.util.List;

/**
 * Created by vlad on 27.10.15.
 */
@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    ClinicRepository repository;

    @Override
    public void addClinic(MedicalClinic clinic) {
        repository.addClinic(clinic);
    }

    @Override
    public List<MedicalClinic> getAllClinics() {
        return repository.getAllClinics();
    }

    @Override
    public MedicalClinic getClinic(Integer id) {
        return repository.getClinic(id);
    }

    @Override
    public Office addOffice(Office office) {
        return repository.addOffice(office);
    }

    @Override
    public List<Office> getClinicOffices(Integer id) {
        return repository.getClinicOffices(id);
    }

    @Override
    public void addPeople(People people) {
        repository.addPeople(people);
    }

    @Override
    public void dropAll() {
        repository.dropAll();
    }

    @Override
    public Integer getAverageSalary(Integer id) {
        return repository.getAverageSalary(id);
    }

    @Override
    public Integer getAverageCost(Integer id) {
        return repository.getAverageCost(id);
    }

    @Override
    public Integer getNetProfit(Integer id) {
        return repository.getNetProfit(id);
    }

}
