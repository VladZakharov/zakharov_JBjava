package repository.impl;

import model.*;
import model.enums.PeopleType;
import org.springframework.stereotype.Repository;
import repository.OfficeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by vlad on 28.10.15.
 */
@Repository
public class OfficeRepositoryImpl implements OfficeRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Office getOffice(Integer id) {
        Query query = em.createNativeQuery("SELECT * FROM office WHERE id = ?", Office.class);
        query.setParameter(1, id);
        return (Office) query.getSingleResult();
    }

    @Override
    public List<People> getOfficePatients(Integer id) {
        Query query = em.createNativeQuery("SELECT * FROM people WHERE type = ? AND office_id = ?", People.class);
        query.setParameter(1, PeopleType.PATIENT.name());
        query.setParameter(2, id);
        return query.getResultList();
    }

    @Override
    @Transactional
    public People addPeople(People people) {
        return em.merge(people);
    }

    @Override
    public List<Provider> getOfficeProviders(Integer id) {
        Query query = em.createNativeQuery("SELECT * FROM provider WHERE office_id = ?", Provider.class);
        query.setParameter(1, id);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Provider addProvider(Provider provider) {
        return em.merge(provider);
    }

    @Override
    @Transactional
    public void addJI(JuridicalInfo ji) {
        em.persist(ji);
    }

    @Override
    public List<People> getOfficeStuffs(Integer id) {
        Query query = em.createNativeQuery("SELECT * FROM people WHERE type = ? AND office_id = ?", People.class);
        query.setParameter(1, PeopleType.STUFF.name());
        query.setParameter(2, id);
        return query.getResultList();
    }

    @Override
    @Transactional
    public OperationSupplier addOperationSupplier(OperationSupplier op) {
        return em.merge(op);
    }

    @Override
    public List<OperationSupplier> getOperationSuppliers(Integer id) {
        Query query = em.createNativeQuery("SELECT * FROM operation_supplier WHERE office_id = ?", OperationSupplier.class);
        query.setParameter(1, id);
        return query.getResultList();
    }

    @Override
    public Integer getAverageSalary(Integer id) {
        Query query = em.createNativeQuery("SELECT AVG(salary) FROM stuff_data WHERE people_id IN (SELECT id FROM people WHERE office_id = ? AND type = ?)");
        query.setParameter(1, id);
        query.setParameter(2, PeopleType.STUFF.name());
        BigDecimal result = (BigDecimal) query.getSingleResult();
        return result.toBigInteger().intValue();
    }

    @Override
    public Integer getAverageCost(Integer id) {
        Query query = em.createNativeQuery("SELECT AVG(cost) FROM patient_data WHERE people_id IN (SELECT id FROM people WHERE office_id = ? AND type = ?)");
        query.setParameter(1, id);
        query.setParameter(2, PeopleType.PATIENT.name());
        BigDecimal result = (BigDecimal) query.getSingleResult();
        return result.toBigInteger().intValue();
    }
}
