package com.sda.rentalloapp;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Objects;

class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

public class HashCollectionsTest {

    @Test
    public void equalityTestForPersons(){
        Person lukasz = new Person("Lukasz");
        Person lukasz2 = new Person("Lukasz");

        boolean theSame = lukasz2.equals(lukasz);
        System.out.println("the same objects??: " + theSame);
        boolean theSameObject = lukasz2 == lukasz;
        System.out.println("theSameObject:  " +  theSameObject);

        List<Person> persons = List.of(lukasz, lukasz2);
        System.out.println("persons size: " + persons.size());
        System.out.println("Is lukasz on the list?: " + persons.contains(lukasz));
        System.out.println("Is lukasz2 on the list?: " + persons.contains(lukasz2));




    }


}
