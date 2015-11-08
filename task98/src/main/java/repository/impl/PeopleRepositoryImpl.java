package repository.impl;

import model.PatientData;
import model.People;
import model.StuffData;
import org.springframework.stereotype.Repository;
import repository.PeopleRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * Created by vlad on 28.10.15.
 */
@Repository
public class PeopleRepositoryImpl implements PeopleRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public People getPeople(Integer id) {
        Query query = em.createNativeQuery("SELECT * FROM people WHERE id = ?", People.class);
        query.setParameter(1, id);
        return (People) query.getSingleResult();
    }

    @Override
    @Transactional
    public PatientData addData(PatientData data) {
        return em.merge(data);
    }

    @Override
    public PatientData getPatientData(Integer id) {
        Query query = em.createNativeQuery("SELECT * FROM patient_data WHERE people_id = ?", PatientData.class);
        query.setParameter(1, id);
        return (PatientData) query.getSingleResult();
    }

    @Override
    public StuffData getStuffData(Integer id) {
        Query query = em.createNativeQuery("SELECT * FROM stuff_data WHERE people_id = ?", StuffData.class);
        query.setParameter(1, id);
        return (StuffData) query.getSingleResult();
    }

    @Override
    public Integer getMonthSalary(Integer id) {
        Query query = em.createNativeQuery("SELECT salary FROM stuff_data WHERE people_id = ?");
        query.setParameter(1, id);
        int s = (int) query.getSingleResult();
        query = em.createNativeQuery("SELECT expected_time FROM stuff_data WHERE people_id = ?");
        query.setParameter(1, id);
        int et = (int) query.getSingleResult();
        return 4 * s * et;
    }

    @Override
    @Transactional
    public StuffData addData(StuffData data) {
        return em.merge(data);
    }

}
