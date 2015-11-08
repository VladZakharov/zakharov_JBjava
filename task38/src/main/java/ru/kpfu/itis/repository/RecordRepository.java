package ru.kpfu.itis.repository;


import ru.kpfu.itis.model.Record;

import java.util.List;

public interface RecordRepository {

    List<Record> getAllRecords();

//    Record findUserByLogin(String login);

    void addRecord(Record record);

}