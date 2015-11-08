package service.impl;

import model.PatientData;
import model.People;
import model.StuffData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PeopleRepository;
import service.PeopleService;

/**
 * Created by vlad on 28.10.15.
 */
@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    PeopleRepository repository;


    @Override
    public People getPeople(Integer id) {
        return repository.getPeople(id);
    }

    @Override
    public PatientData addData(PatientData data) {
        return repository.addData(data);
    }

    @Override
    public StuffData addData(StuffData data) {
        return repository.addData(data);
    }

    @Override
    public PatientData getPatientData(Integer id) {
        return repository.getPatientData(id);
    }

    @Override
    public StuffData getStuffData(Integer id) {
        return repository.getStuffData(id);
    }

    @Override
    public Integer getMonthSalary(Integer id) {
        return repository.getMonthSalary(id);
    }
}
