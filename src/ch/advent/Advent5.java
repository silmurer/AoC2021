package ch.advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Advent5 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\silas\\Downloads\\advent5.txt";
        List<Integer> file = Files.lines(Paths.get(path)).flatMap(s -> Stream.of(s.split(","))).map(Integer::valueOf).collect(Collectors.toList());


        part1();
    }

    private static void part1() {


    }
}
