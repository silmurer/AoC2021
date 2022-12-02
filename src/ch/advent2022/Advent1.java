package ch.advent2022;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Advent1 {

    public static void main(String[] args) throws IOException {
        File file = new File("advent1.txt");
        Scanner scanner = new Scanner(file);
        List<String> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(scanner.nextLine());
            System.out.println("File read");
        }
    day1(input);
    }

    private static void day1(List<String> input) {
        List<Integer> list = new ArrayList<>();
        int value = 0;
        for (String a : input) {
            if (!Objects.equals(a, ""))
            {
                value += Integer.parseInt(a);
            }
            else {
                list.add(value);
                value = 0;
            }
        }
        System.out.println("Result 1: " + Collections.max(list));

        Collections.sort(list);
        List<Integer> b = list.subList(list.size() -3, list.size());
        System.out.println("Result 2: " + b.stream().mapToInt(Integer::intValue).sum() );
    }

    }
