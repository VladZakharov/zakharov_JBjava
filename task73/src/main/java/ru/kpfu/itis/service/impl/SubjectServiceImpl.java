package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Subject;
import ru.kpfu.itis.repository.SubjectRepository;
import ru.kpfu.itis.service.SubjectService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by vlad on 21.10.15.
 */

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public void addScore(Subject subject) {
        if (subject == null) {
            return;
        }
        subjectRepository.updateSubject(subject);
    }

    @Override
    public BigDecimal getAverageScore(Integer id) {
        return subjectRepository.getAverage(id);
    }

    @Override
    public BigInteger getTotalScore(Integer id) {
        return subjectRepository.getScore(id);
    }

    @Override
    public List<Integer> getSubjectScores(Integer id) {
        return subjectRepository.getSubjectScores(id);
    }

    @Override
    public Integer getSubjectScore(Integer id, Integer subject) {
        return subjectRepository.getScore(id, subject);
    }

    @Override
    public void removeSubject(Integer id) {
        subjectRepository.removeSubject(id);
    }
}
