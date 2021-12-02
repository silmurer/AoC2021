package ch.advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Stream;

public class Main {



    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\silas\\Downloads\\advent2.txt");
        Scanner scanner = new Scanner(file);

        List<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        advent2(list);
    }


    static void advent2(List<String> list) {
        int forward = 0;
        int depth = 0;
        int aim = 0;
        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()){
            String command = iterator.next();

            if (Objects.equals(command, "forward")){
                int val = Integer.parseInt(iterator.next());
                forward += val;
                depth += aim * val;
            }
            if (Objects.equals(command, "up")){
                aim -= Integer.parseInt(iterator.next());
            }
            if (Objects.equals(command, "down")){
                aim += Integer.parseInt(iterator.next());
            }
        }
        int a = forward * depth;
        System.out.println(a);

    }

    static void advent1() {
        List<Integer> list = new ArrayList<>();
        ListIterator<Integer> iterator = list.listIterator();
        int value = iterator.next();
        int value2 = iterator.next();
        int value3 = iterator.next();
        int comb = value + value2 + value3;
        int comb2;

        int a = 0;
        while (iterator.hasNext()){

            comb2 = comb - value;
            value = value2;
            value2 = value3;
            value3 = iterator.next();
            comb2 = comb2 + value3;

            if (comb < comb2) {
                a++;
            }
            comb = comb2;
        }
        System.out.println(a);
    }
}
