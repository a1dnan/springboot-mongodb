package com.a1dnan.springmongodb.controller;

import com.a1dnan.springmongodb.collection.Person;
import com.a1dnan.springmongodb.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public String save(@RequestBody Person person){
        return personService.save(person);
    }

    @GetMapping
    public List<Person> getAll(){
        return personService.getAll();
    }

    @GetMapping("/filter")
    public List<Person> getPersonStarsWith(@RequestParam String name){
        return personService.getPersonStarsWith(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        personService.delete(id);
    }

    @GetMapping("/age")
    public List<Person> getByPersonAge(@RequestParam int min, @RequestParam int max){
        return personService.getPersonByAge(min, max);
    }

    @GetMapping("/search")
    public Page<Person> searchPerson(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) String city,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size
    ) {
        Pageable pageable
                = PageRequest.of(page,size);
        return personService.search(name,minAge,maxAge,city,pageable);
    }

    @GetMapping("/oldest")
    public List<Document> getOldestPerson(){
        return personService.getOldestPersonByCity();
    }

}
