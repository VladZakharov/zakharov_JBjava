package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Record;
import ru.kpfu.itis.repository.RecordRepository;
import ru.kpfu.itis.service.RecordService;

import java.util.List;

/**
 * Created by vlad on 10.10.15.
 */

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordRepository repository;

    @Override
    public List<Record> getAllRecords() {
        return repository.getAllRecords();
    }

    @Override
    public void addRecord(Record record) {
        if (record == null) {
            return;
        }
        repository.addRecord(record);
    }
}