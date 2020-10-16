package com.example.learnings.jsonb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person,Long> {

//    @Query(value = "select * from cart_sub_items where attributes->>'homesOrderId'=? and lob='HOME'",nativeQuery = true)
    @Query(value = "select * from Person where properties->>'homesId'=? and lob=?",nativeQuery = true)
    List<Person>findByHomesId(String id,String lob);

}
