package ch.advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Advent6 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\silas\\Downloads\\advent6.txt";
            List<Integer> file = Files.lines(Paths.get(path)).flatMap(s -> Stream.of(s.split(","))).map(Integer::valueOf).collect(Collectors.toList());


        part2(file);
        }

    private static void part1(List<Integer> input) {
        // Idee: Sobald 1 Wert = 0 -> Füge 6 und 8 hinzu
        List<Integer> out;
        for (int i = 1; i <= 80; i++) {
            out = new ArrayList<>();
            for (int j : input) {
                if (j == 0) {
                    out.addAll(new ArrayList<Integer>(Arrays.asList(6, 8)));
                } else out.add(j - 1);
            }
            input = out;

            System.out.println("Tag:" + i + "\t" + out.size());
        }

    }

    private static void part2(List<Integer> input) {
        long[] list = new long[9];
        for (int i : input) {
            list[i]++;
        }

        System.out.println(list.length);
        for (int i = 0; i < 256; i++) {
            long reproduction = list[0];
            for (int j = 0; j < list.length-1; j++) {
                list[j] = list[j+1];
            }
            list[6] += reproduction;
            list[8] = reproduction;

        }
        System.out.println(Arrays.stream(list).sum());


    }

}
