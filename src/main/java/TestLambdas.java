import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ryanknight on 10/3/16.
 */
public class TestLambdas {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        Mapper mapper = x -> x * 2;

        List<Integer> collect = integers.stream()
                .filter(x -> (x % 2 == 0))
                .map(x -> x * 2)
                .collect(Collectors.toList());
    }

    private static void mapList(List<Integer> integers, Mapper mapper) {
        List<Integer> newInts = new ArrayList<>();
        for (Integer indx : integers) {
            newInts.add(mapper.operation(indx));
        }
    }
}
