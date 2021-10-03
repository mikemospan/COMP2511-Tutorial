package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>(Arrays.asList(new String[] {"1", "2", "3", "4", "5"}));
        int total = 0;
        for (String string : strings) {
            total += Integer.parseInt(string);
        }
        System.out.println(total);

        List<String> strings2 = new ArrayList<String>(Arrays.asList(new String[] {"1", "2", "3", "4", "5"}));
        List<Integer> ints = strings2.stream().map(Integer::parseInt).collect(Collectors.toList()); // new ArrayList<Integer>();
        for (String string : strings) {
            ints.add(Integer.parseInt(string));
        }
        System.out.println(ints);
    }


}