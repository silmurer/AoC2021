package ch.advent2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Advent7 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\silas\\IdeaProjects\\AoC2021\\advent7.txt");


        List<Integer> list = new ArrayList<>();
        long[] lists;
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(",");
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        System.out.println(part72(list));

    }
    public static int part71(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        int median = sortedList.get(sortedList.size()/2);
        int price = 0;
        for (int i : list){
            price += Math.abs(i-median);
        }
        return price;
    }

    public static int part72(List<Integer> list) {
        int[] intList = list.stream().mapToInt(Integer::intValue).toArray();
        int mittelwert = (int) Arrays.stream(intList).average().getAsDouble();
        int price = 0;
        for (int pos : intList) {
            int abstand = Math.abs(pos-mittelwert);
            price += abstand*(abstand+1)/2;
        }
        return price;
    }
}
