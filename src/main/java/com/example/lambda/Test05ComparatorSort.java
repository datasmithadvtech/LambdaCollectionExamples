package com.example.lambda;

import java.util.Comparator;
import java.util.List;

public class Test05ComparatorSort {
    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();

        System.out.println("\n=== Persons Sorted By Last Name ===");
        personList.sort((p1, p2) ->
                p1.getSurName().compareTo(p2.getSurName()));

        personList.forEach(Person::printWesternName);

        System.out.println("\n=== Persons Sorted By Last Name and First Name===");

        //Why does this give an error when I combine comparing and personComparator into one line?
        Comparator<Person> comparing = Comparator.comparing(person-> person.getSurName());
        Comparator<Person> personComparator = comparing.thenComparing(person -> person.getGivenName());
        personList.sort(personComparator);


        //More succinct way of sorting
        personList.sort(Comparator
                .comparing(Person::getSurName)
                .thenComparing(Comparator.comparing(Person::getSurName)));

        personList.forEach(Person::printWesternName);


    }
}
