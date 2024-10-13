package com.insert.service;

import com.insert.entity.InsertEntity;
import com.insert.exceptions.NonExistentIdValueException;
import com.insert.repository.TestRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class InsertService {

    TestRepository repository;

    public void removeAllRecords() {
        repository.deleteAll();
    }

    public InsertEntity addNewValue(String text) {
        InsertEntity insertEntity = new InsertEntity();
        insertEntity.setRandomText(text);
        return repository.save(insertEntity);
    }

    public void saveAll(List<InsertEntity> list){
        repository.saveAll(list);

    }

    public String updateValue(int id, String text) {
        InsertEntity insertEntity = getValue(id);
        insertEntity.setRandomText(text);
        repository.save(insertEntity);
        return text;
    }

    public InsertEntity getValue(long id) {
        return repository.findById(id).orElseThrow(() -> new NonExistentIdValueException(0));
    }

    public void removeValue(long id) {
        repository.deleteById(id);
    }

}
