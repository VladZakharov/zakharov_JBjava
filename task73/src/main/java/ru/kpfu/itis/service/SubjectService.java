package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Subject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by vlad on 23.10.15.
 */
public interface SubjectService {

    void addScore(Subject subject);

    public BigDecimal getAverageScore(Integer id);

    public BigInteger getTotalScore(Integer id);

    public List<Integer> getSubjectScores(Integer id);

    public Integer getSubjectScore(Integer id, Integer subject);

    void removeSubject(Integer id);
}
