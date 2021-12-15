package ch.advent;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Advent4 {
    public static void main(String[] args0) throws FileNotFoundException {
        File file = new File("C:\\Users\\silas\\IdeaProjects\\AoC2021\\advent4.txt");

        System.out.println(getLastWinning(file).getScore());

    }
    public static Board getChampion(File file) {
        Game game = new Game(file);
        ArrayList<Integer> states = new ArrayList<>();
        for (Board board : game.board){
            states.add(board.step(game.draws));
        }
        return game.board.get(states.indexOf(Collections.min(states)));
    }
    public static Board getLastWinning(File file) {
        Game game = new Game(file);
        ArrayList<Integer> state = new ArrayList<>();
        for (Board board : game.board){
            state.add(board.step(game.draws));
        }
        return game.board.get(state.indexOf(Collections.max(state)));
    }



    static class Game {
        List<Board> board = new ArrayList<>();
        int[] draws;

        public Game(File file) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                draws = Stream.of(reader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
                String row;
                ArrayList<Integer> fill = new ArrayList<>();
                while ((row = reader.readLine()) != null) {
                    if (row.trim().length() == 0) {
                        if (fill.size() == 25) board.add(new Board(fill.stream().mapToInt(i -> i).toArray()));
                    fill.clear();
                }else {
                            String[] segments = row.trim().split(" ");
                            for (String segment : segments) {
                                try {
                                    fill.add(Integer.parseInt(segment));

                                } catch (Exception ignored) {
                                }
                            }
                        }
                }
            } catch (IOException ignored) {
            }
        }

    }

    static class Board {
        enum State {WAIT, WINROW, WINCOL}

        State state = State.WAIT;
        int code = 0;
        int value = 0;
        boolean[] data;
        HashMap<Integer, Integer> index = new HashMap<>();
        int score = 0;

        public Board(int[] data) {
            this.data = new boolean[data.length];
            for (int i = 0; i < data.length; i++) index.put(data[i], i);

        }

        public int step(int[] draw) {
            for (int i = 0; i < draw.length; i++) {
                try {
                    int j = index.get(draw[i]);
                    data[j] = true;
                    if ((state = checkWin(j)) != State.WAIT) {
                        code = (i * 1000) + (j + (state == State.WINCOL ? 25 : 0));
                        value = draw[i];
                        return code;
                    }
                } catch (Exception ignored) {
                }
            }
            return 0;
        }

        public State checkWin(int place) {
            int c = 0;
            int row = place - (place % 5);
            try {
                while (c != 5 && data[row++]) {
                    c++;
                }
            } catch (Exception ignored) {
            }
            if (c == 5) return State.WINROW;
            c = 0;
            int col = place % 5;
            while (c != 5 && data[col]) {
                col += 5;
                c++;
            }
            return (c == 5) ? State.WINCOL : State.WAIT;

        }

        public int getScore() {
            if (state == State.WAIT) return 0;
            score = 0;
            for (int i : index.keySet()) {
                if (!data[index.get(i)]) {
                    score += i;
                }
            }
            return score * value;
        }
    }
}
