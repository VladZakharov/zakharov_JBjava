package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Record;

import java.util.List;

/**
 * Created by vlad on 10.10.15.
 */
public interface RecordService {

    List<Record> getAllRecords();

    void addRecord(Record record);

}
