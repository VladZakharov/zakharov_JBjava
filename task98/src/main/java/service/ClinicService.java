package service;

import model.MedicalClinic;
import model.Office;
import model.People;

import java.util.List;

/**
 * Created by vlad on 27.10.15.
 */
public interface ClinicService {

    void addClinic(MedicalClinic clinic);

    List<MedicalClinic> getAllClinics();

    MedicalClinic getClinic(Integer id);

    Office addOffice(Office office);

    List<Office> getClinicOffices(Integer id);

    void addPeople(People people);

    void dropAll();

    Integer getAverageSalary(Integer id);

    Integer getAverageCost(Integer id);

    Integer getNetProfit(Integer id);

}
