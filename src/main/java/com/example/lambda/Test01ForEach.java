package com.example.lambda;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 *
 * @author MikeW
 */
public class Test01ForEach {

  public static void main(String[] args) {

    List<Person> pl = Person.createShortList();

    printNamesOldStyle(pl);

    printNamesLambda(pl);

  }

    private static void printNamesOldStyle(List<Person> pl) {
        System.out.println("\n=== Western Phone List ===");

        for (Iterator<Person> iterator = pl.iterator(); iterator.hasNext(); ) {
            Person person = iterator.next();
            person.printWesternName();
        }
    }

    private static void printNamesLambda(List<Person> pl) {
    System.out.println("\n=== Western Phone List ===");
    pl.forEach( p -> p.printWesternName() );

    System.out.println("\n=== Eastern Phone List ===");
    pl.forEach(Person::printEasternName);

    System.out.println("\n=== Custom Phone List ===");
    pl.forEach(p -> {
      System.out.println(p.printCustom(r -> "Name: " + r.getGivenName() + " EMail: " + r.getEmail()));
    });
  }

}
