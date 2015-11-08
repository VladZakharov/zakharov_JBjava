package repository.impl;

import model.MedicalClinic;
import model.Office;
import model.People;
import model.enums.PeopleType;
import org.springframework.stereotype.Repository;
import repository.ClinicRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by vlad on 27.10.15.
 */
@Repository
public class ClinicRepositoryImpl implements ClinicRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void addClinic(MedicalClinic clinic) {
        em.persist(clinic);
    }

    @Override
    public List<MedicalClinic> getAllClinics() {
        Query query = em.createNativeQuery("SELECT * FROM med_clinic", MedicalClinic.class);
        return query.getResultList();
    }

    @Override
    public MedicalClinic getClinic(Integer id) {
        Query query = em.createNativeQuery("SELECT * FROM med_clinic WHERE id = ?", MedicalClinic.class);
        query.setParameter(1, id);
        return (MedicalClinic) query.getSingleResult();
    }

    @Override
    @Transactional
    public Office addOffice(Office office) {
        return em.merge(office);
    }

    @Override
    public List<Office> getClinicOffices(Integer id) {
        Query query = em.createNativeQuery("SELECT * FROM office WHERE medclinic_id = ?", Office.class);
        query.setParameter(1, id);
        return query.getResultList();
    }

    @Override
    public void addPeople(People people) {
        em.merge(people);
    }

    @Override
    @Transactional
    public void dropAll() {
        Query query;
//        query = em.createNativeQuery("DROP SEQUENCE public.hibernate_sequence RESTRICT");
//        query.executeUpdate();

        query = em.createNativeQuery("DELETE FROM stuff_data");
        query.executeUpdate();

        query = em.createNativeQuery("DELETE FROM patient_data");
        query.executeUpdate();

        query = em.createNativeQuery("DELETE FROM operation_supplier");
        query.executeUpdate();

        query = em.createNativeQuery("DELETE FROM provider");
        query.executeUpdate();

        query = em.createNativeQuery("DELETE FROM people");
        query.executeUpdate();

        query = em.createNativeQuery("DELETE FROM office");
        query.executeUpdate();

        query = em.createNativeQuery("DELETE FROM jur_info");
        query.executeUpdate();

        query = em.createNativeQuery("DELETE FROM med_clinic");
        query.executeUpdate();
    }

    @Override
    public Integer getAverageSalary(Integer id) {
        Query query = em.createNativeQuery("SELECT AVG(salary) FROM stuff_data WHERE people_id IN (SELECT id FROM people WHERE type = ? AND office_id IN (SELECT id FROM office WHERE medclinic_id = ?))");
        query.setParameter(1, PeopleType.STUFF.name());
        query.setParameter(2, id);
        BigDecimal result = (BigDecimal) query.getSingleResult();
        return result.toBigInteger().intValue();
    }

    @Override
    public Integer getAverageCost(Integer id) {
        Query query = em.createNativeQuery("SELECT AVG(cost) FROM patient_data WHERE people_id IN (SELECT id FROM people WHERE type = ? AND office_id IN (SELECT id FROM office WHERE medclinic_id = ?))");
        query.setParameter(1, PeopleType.PATIENT.name());
        query.setParameter(2, id);
        BigDecimal result = (BigDecimal) query.getSingleResult();
        return result.toBigInteger().intValue();
    }

    @Override
    public Integer getNetProfit(Integer id) {
        Query query;
        query = em.createNativeQuery("SELECT SUM(cost) FROM patient_data WHERE people_id IN (SELECT id FROM people WHERE type = ? AND office_id IN (SELECT id FROM office WHERE medclinic_id = ?))");
        query.setParameter(1, PeopleType.PATIENT.name());
        query.setParameter(2, id);
        int profit = ((BigInteger) query.getSingleResult()).intValue();
        query = em.createNativeQuery("SELECT SUM(4 * salary * expected_time) FROM stuff_data WHERE people_id IN (SELECT id FROM people WHERE type = ? AND office_id IN (SELECT id FROM office WHERE medclinic_id = ?))");
        query.setParameter(1, PeopleType.STUFF.name());
        query.setParameter(2, id);
        int cost = ((BigInteger) query.getSingleResult()).intValue();

        return (profit - cost);
    }

}
