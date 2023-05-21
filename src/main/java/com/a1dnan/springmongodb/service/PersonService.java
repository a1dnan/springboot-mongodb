package com.a1dnan.springmongodb.service;

import com.a1dnan.springmongodb.collection.Person;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    String save(Person person);

    List<Person> getPersonStarsWith(String name);

    List<Person> getAll();

    void delete(String id);

    List<Person> getPersonByAge(int min, int max);

    Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable);

    List<Document> getOldestPersonByCity();
}
