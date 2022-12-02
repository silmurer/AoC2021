package ch.advent2021;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Advent10 {
    public Stack<String> open;
    public Stack<String> close;
    public static List<String> isOpen = Arrays.asList("[","{","(","<");

    public static void main(String[] args) throws IOException {


        File file = new File("C:\\Users\\silas\\Downloads\\advent10.txt");
        Scanner scanner = new Scanner(file);
        List<String> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(scanner.nextLine());
            System.out.println("File read");
        }}

    private static void part1() {
        // Idee: Schauen ob von der Art her die letzte Klammer geschlossen wird
        //List<Character> illegalChar = input.stream().map(char)





    }

//    private static void checker(String openChar, String nextChar) {
//        long sum = 0;
//
//            if (openChar.equals(correctChar)){
//
//
//            }
//
//        sum += switch(nextChar) {
//        case ')'-> 3;
//        case '>' -> 25137;
//        case ']' -> 57;
//        case '}' -> 1197;
//        default -> throw new IllegalArgumentException();
//
//            System.out.println(sum);
//    };
//
//        }

    private static Map<Character, Integer> createLegalsScoreMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(')', 1);
        map.put(']', 2);
        map.put('}', 3);
        map.put('>', 4);
        return map;
    }


    private static Map<Character, Integer> createIllegalsScoreMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(')', 3);
        map.put(']', 57);
        map.put('}', 1197);
        map.put('>', 25137);
        return map;
    }

    private static Map<Character, Character> createOpenCloseMap() {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        map.put('<', '>');
        return map;
    }
}
