package ru.kpfu.itis.repository.impl;

/**
 * Created by vlad on 23.10.15.
 */

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Subject;
import ru.kpfu.itis.repository.SubjectRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Repository
public class SubjectRepositoryImpl implements SubjectRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public BigDecimal getAverage(Integer id) {
        Query query = em.createNativeQuery("SELECT AVG(score) FROM subjects WHERE student_id = ?");
        query.setParameter(1, id);
        return (BigDecimal) query.getSingleResult();
    }

    @Override
    public BigInteger getScore(Integer id) {
        Query query = em.createNativeQuery("SELECT SUM(score) FROM subjects WHERE student_id = ?");
        query.setParameter(1, id);
        return (BigInteger) query.getSingleResult();
    }

    @Override
    public Integer getScore(Integer id, Integer subject) {
        Query query = null;
        try {
            query = em.createNativeQuery("SELECT score FROM subjects WHERE student_id = ? and subject_type = ?");
            query.setParameter(1, id);
            query.setParameter(2, subject);
            return (Integer) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Integer> getSubjectScores(Integer id) {
        Query query = null;
        try {
            query = em.createNativeQuery("SELECT score FROM subjects WHERE student_id = ?");
            query.setParameter(1, id);
            return query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    @Transactional
    public void updateSubject(Subject subject) {
        em.merge(subject);
    }

    @Override
    @Transactional
    public void removeSubject(Integer id) {
        Query query = em.createNativeQuery("DELETE FROM subjects WHERE id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

}
