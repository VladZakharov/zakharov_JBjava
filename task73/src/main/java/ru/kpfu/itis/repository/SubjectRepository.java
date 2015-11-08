package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.Subject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by vlad on 23.10.15.
 */
public interface SubjectRepository {
    BigDecimal getAverage(Integer id);

    BigInteger getScore(Integer id);

    Integer getScore(Integer id, Integer subject);

    List<Integer> getSubjectScores(Integer id);

    void updateSubject(Subject subject);

    void removeSubject(Integer id);
}
