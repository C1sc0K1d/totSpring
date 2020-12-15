package com.example.toh;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
public class Hero {

    @Id
    @GeneratedValue(generator = "customGenerator")
    @GenericGenerator(name = "customGenerator", strategy = "com.example.toh.IdGenerate")
    private Integer id;
    private String name;

    protected Hero(){}

    public Hero(String name){
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return String.format("Hero[id=%d, name='%s']", id, name);
    }
}
