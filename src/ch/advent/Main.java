package ch.advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\silas\\IdeaProjects\\AoC2021\\advent3.txt");
        Scanner scanner = new Scanner(file);

        List<String> list = new ArrayList<String>();
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        System.out.println(advent32(list));

    }

    static int advent32(List<String> list) {
        ArrayList<String> oxygen = new ArrayList<String>(list);
        ArrayList<String> co2 = new ArrayList<String>(list);

        int col1 = 0;
        int col2 = 0;

        while (oxygen.size() > 1) {
            int ones = 0;
            int zeroes = 0;
            for (int row = 0; row < oxygen.size(); row++) {
                if (oxygen.get(row).charAt(col1) == '0')
                    zeroes++;
                else
                    ones++;
            }
            char max = (ones >= zeroes ? '1' : '0');
            for (int row = oxygen.size() - 1; row >= 0; row--) {
                if (oxygen.get(row).charAt(col1) != max)
                    oxygen.remove(row);
            }
            col1++;
        }

        while (co2.size() > 1) {
            int ones = 0;
            int zeroes = 0;
            for (int row = 0; row < co2.size(); row++) {
                if (co2.get(row).charAt(col2) == '0')
                    zeroes++;
                else
                    ones++;
            }
            char min = (zeroes <= ones ? '0' : '1');
            for (int row = co2.size() - 1; row >= 0; row--) {
                if (co2.get(row).charAt(col2) != min)
                    co2.remove(row);
            }
            col2++;
        }

        return (Integer.parseInt(oxygen.get(0),2)*Integer.parseInt(co2.get(0),2));

    }

    static int advent31(List<String> list) {
        String gamma = "";
        String epsilon = "";

        for (int col = 0; col < list.get(0).length(); col++){
            int o = 0, z = 0;
            for (int row = 0; row < list.size(); row++){
                // lol, "" vs ''
                if (list.get(row).charAt(col) == '0'){
                    z++;
                }
                else {
                    o++;
                }
            }
            gamma += (o > z ? "1" : "0");
            epsilon += (o < z ? "1" : "0");
        }
        return (Integer.parseInt(gamma,2)*Integer.parseInt(epsilon,2));

    }

    static void advent22(List list) {
        int forward = 0, depth = 0, aim = 0;
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

    }

    static void advent11() {
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
