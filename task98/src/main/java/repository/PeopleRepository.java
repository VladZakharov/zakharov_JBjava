package repository;

import model.PatientData;
import model.People;
import model.StuffData;

/**
 * Created by vlad on 28.10.15.
 */
public interface PeopleRepository {
    
    People getPeople(Integer id);

    PatientData addData(PatientData data);

    PatientData getPatientData(Integer id);

    StuffData getStuffData(Integer id);

    StuffData addData(StuffData data);

    Integer getMonthSalary(Integer id);
}
