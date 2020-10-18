package com.example.learnings.jsonb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class Worker {

    @Autowired PersonRepo personRepo;

    @PostConstruct
    public void play(){
        Person[] person=new Person[5];
        for (int i=0;i<4;i++){
            person[i]=new Person();
            Map<String,Object>map=new HashMap<>();
            map.put("homesId","1");
            person[i].setMap(map);
            if (i%2==0)person[i].setLob("home");

            personRepo.save(person[i]);
        }

        person[4]=new Person();
        Map<String,Object>map=new HashMap<>();
        map.put("homesId","5");
        person[4].setMap(map);


        personRepo.save(person[4]);

        List<Person>people=personRepo.findByHomesId("1","home");
        log.info("persons are  {}",people.toString());

    }
}
