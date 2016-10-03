package firstSamples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OldToNewStyle {

    public static void main(String[] args) {

        List<Integer> range = IntStream.rangeClosed(0, 10)
                .boxed().collect(Collectors.toList());

        List<Integer> lst2 = mapList(range);
        printList(lst2);

        List<Integer> lst3 = mapTwo(range, new Mapper() {
            @Override
            public Integer apply(Integer x) {
                return x*2;
            }
        });
        printList(lst3);

        List<Integer> lst4 = mapTwo(range, (x) -> x*2);
        printList(lst4);

        List<Integer> lst5 = range.stream()
                .map((x) -> x*2)
                .collect(Collectors.toList());

        printList(lst5);
    }

    public static List<Integer> mapList(List<Integer> range) {
        List<Integer> newRange = new ArrayList<>();
        for (Integer indx : range) {
            newRange.add(indx*2);
        }
        return newRange;
    }

    public static List<Integer> mapTwo(List<Integer> range, Mapper mapper) {
        List<Integer> newRange = new ArrayList<>();
        for (Integer indx : range) {
            newRange.add(mapper.apply(indx));
        }
        return newRange;
    }

    public static void printList(List<Integer> range) {
        String out = range.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println(out);
    }
}
