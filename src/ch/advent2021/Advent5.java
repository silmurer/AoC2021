package ch.advent2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Advent5 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\silas\\IdeaProjects\\AoC2021\\advent5.txt";
        HashMap<Integer, Integer> map = new HashMap<>();
        List<String> file = Files.lines(Paths.get(path)).map(String::valueOf).collect(Collectors.toList());
        System.out.println(file);
        //file.stream().map(t -> Stream.of(t.split(",")).map(Integer::valueOf)).collect(Collectors.toList(map.put()));


        System.out.println(part51(file).getDangerZones());
    }

    public static Coordinate part51(List<String> list) {
        Coordinate map = new Coordinate();
        for (String line : list) {
            Matcher match = Pattern.compile("(\\d*),(\\d*) -> (\\d*),(\\d*)").matcher(line);
            match.find();
            int[] c = new int[]{
                    Integer.parseInt(match.group(1)),
                    Integer.parseInt(match.group(2)),
                    Integer.parseInt(match.group(3)),
                    Integer.parseInt(match.group(4))};
            if (c[0] == c[2] && c[1] != c[3]) {
                map.add(c[0], c[1]);
                int changeH = c[1] > c[3] ? -1 : +1;
                while (c[1] != c[3]) {
                    c[1] += changeH;
                    map.add(c[0], c[1]);
                }
            } else if (c[0] != c[2] && c[1] == c[3]) {
                map.add(c[0], c[1]);
                int changeV = c[0] > c[2] ? -1 : +1;
                while (c[0] != c[2]) {
                    c[0] += changeV;
                    map.add(c[0], c[1]);
                }
            }
            // diagonal
            else {
                map.add(c[0], c[1]);
                int[] changeD = new int[]{c[0] > c[2] ? -1 : +1, c[1] > c[3] ? -1 : +1};
                while (c[0] != c[2]) {
                    c[0] += changeD[0];
                    c[1] += changeD[1];
                    map.add(c[0], c[1]);
                }
            }
        }
        return map;
    }

    static class Coordinate {
        private int[][] map = new int[1000][1000];
        private int dangerZones = 0;

        public int getDangerZones() {
            return dangerZones;
        }

        public void add(int x, int y) {
            if (++map[x][y] == 2) dangerZones++;
        }
    }


}