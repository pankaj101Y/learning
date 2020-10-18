package com.example.learnings.jsonb;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "Person")
@Getter
@Setter
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@org.hibernate.annotations.TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(columnDefinition = "jsonb", name = "properties")
    @Type(type = "jsonb")
    Map<String,Object>map;

    @Column(name = "lob")
    String lob;
}
