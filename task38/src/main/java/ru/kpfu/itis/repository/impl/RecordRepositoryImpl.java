package ru.kpfu.itis.repository.impl;


import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Record;
import ru.kpfu.itis.repository.RecordRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecordRepositoryImpl implements RecordRepository {

    List<Record> records = new ArrayList<Record>() {{
//        add(new User("Максим", "Игнатьев", "vietto", "1234", "20"));
//        add(new User("Андрей", "Титов", "amigo", "1234", "20"));
//        add(new User("Михаил", "Магомедов", "misha", "1234", "19"));
//        add(new User("Саша", "Прискин", "alex", "1234", "19"));
    }};

    @Override
    public List<Record> getAllRecords() {
        return records;
    }

//    @Override
//    public Record findUserByLogin(String login) {
//        for (User user : users) {
//            if (user.getLogin() != null && user.getLogin().equals(login)) {
//                return user;
//            }
//        }
//        return null;
//    }

    @Override
    public void addRecord(Record record) {
        records.add(record);
    }
}
