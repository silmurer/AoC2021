package ch.advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Stream;

public class Main {



    public static void main(String[] args) throws FileNotFoundException {
        advent1();
    }

    static void advent1() throws FileNotFoundException {

        File file = new File("C:\\Users\\silas\\Downloads\\advent1.txt");
        Scanner scanner = new Scanner(file);
        List<Integer> list = new ArrayList<>();

        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }

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
