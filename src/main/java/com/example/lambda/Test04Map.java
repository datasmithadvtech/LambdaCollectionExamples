package com.example.lambda;

import java.util.List;
import java.util.OptionalDouble;

/**
 *
 * @author MikeW
 */
public class Test04Map {

  public static void main(String[] args) {
    List<Person> pl = Person.createShortList();

    getAverageAgeOldStyle(pl);

    getAverageAgeLambdas(pl);
    
  }

  private static void getAverageAgeOldStyle(List<Person> pl) {
    // Calc average age of pilots old style
    System.out.println("== Calc Old Style ==");
    int sum = 0;
    int count = 0;

    for (Person p:pl){
      if (p.getAge() >= 23 && p.getAge() <= 65 ){
        sum = sum + p.getAge();
        count++;
      }
    }

    long average = sum / count;
    System.out.println("Total Ages: " + sum);
    System.out.println("Average Age: " + average);
  }


  private static void getAverageAgeLambdas(List<Person> pl) {
    SearchCriteria search = SearchCriteria.getInstance();

    // Get sum of ages
    System.out.println("\n== Calc New Style ==");
    long totalAge = pl
            .stream()
            .filter(search.getCriteria("allPilots"))
            .mapToInt(p -> p.getAge())
            .sum();

    // Get average of ages
    OptionalDouble averageAge = pl
            .parallelStream()
            .filter(search.getCriteria("allPilots"))
            .mapToDouble(p -> p.getAge())
            .average();

    System.out.println("Total Ages: " + totalAge);
    System.out.println("Average Age: " + averageAge.getAsDouble());
  }



}
