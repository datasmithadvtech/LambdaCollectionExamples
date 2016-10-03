package com.example.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test06Files {
    public static void main(String[] args) {
        getAirports();
    }

    private static void getAirports() {
        try {
            Stream<String> lines = Files.lines(Paths.get("data/airline-flights/airports.csv"));

            Consumer<String> stringConsumer = line -> System.out.println("line = " + line);
            // lines.peek(stringConsumer).count();

            List<Airport> airportList = lines
                    .skip(1)
                    //.peek(stringConsumer)
                    .map(line -> Airport.createAirport(line))
                    .collect(Collectors.toList());

            airportList.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
