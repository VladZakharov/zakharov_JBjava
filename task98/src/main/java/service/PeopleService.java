package service;

import model.PatientData;
import model.People;
import model.StuffData;

/**
 * Created by vlad on 28.10.15.
 */
public interface PeopleService {
    
    People getPeople(Integer id);

    PatientData addData(PatientData data);

    StuffData addData(StuffData data);

    PatientData getPatientData(Integer id);

    StuffData getStuffData(Integer id);

    Integer getMonthSalary(Integer id);
}
