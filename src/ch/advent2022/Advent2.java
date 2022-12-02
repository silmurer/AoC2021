package ch.advent2022;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static ch.advent2022.Advent2.Outcome.*;
import static ch.advent2022.Advent2.Sign.*;

public class Advent2 {
    private static final Map<String,Sign> translateElve = Map.of(
            "A",ROCK,
            "B",PAPER,
            "C",SCISSOR
    );
    private static final Map<String,Sign> translateHuman = Map.of(
            "X",ROCK,
            "Y",PAPER,
            "Z",SCISSOR
    );
    private static final Map<String,Outcome> getOutcome = Map.of(
            "X", LOSS,
            "Y", DRAW,
            "Z", WIN
    );

    public static void main(String[] args) throws IOException {
        File file = new File("advent2.txt");
        Scanner scanner = new Scanner(file);
        List<String> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(scanner.nextLine());
        }

        day2(input);
    }
    private static void day2(List<String> input) {
        int result = 0, result2 = 0;
        for (String game : input)
        {
            String[] gameInput = game.split("\\p{Zs}");

            result = result + part1(translateElve.get(gameInput[0]), translateHuman.get(gameInput[1]));
            result2 = result2 + part2(translateElve.get(gameInput[0]), getOutcome.get(gameInput[1]));

        }
        System.out.println("Result 1:" + result);
        System.out.println("Result 2:" + result2);
    }

    private static int part1(Sign elveMove, Sign myMove)
    {
        switch (elveMove)
        {
            case ROCK -> {
                return myMove == PAPER ? getValue(PAPER,WIN) : myMove == ROCK ? getValue(ROCK,DRAW) : SCISSOR.value;
            }
            case PAPER -> {
                return myMove == SCISSOR ? getValue(SCISSOR,WIN) : myMove == PAPER ? getValue(PAPER,DRAW) : ROCK.value;
            }
            case SCISSOR -> {
                return myMove == ROCK ? getValue(ROCK,WIN) : myMove == SCISSOR ? getValue(SCISSOR,DRAW) : PAPER.value;
            }
            default -> {
                System.out.println("Error: Match invalid");
                return 0;
            }
        }

    }

    private static int part2(Sign elveMove, Outcome outcome) {
        switch (outcome) {
            case WIN -> {
                return elveMove == SCISSOR ? getValue(ROCK,WIN) : getValue(elveMove,WIN) + 1;
            }
            case DRAW -> {
                return getValue(elveMove,DRAW);
            }
            case LOSS -> {
                return elveMove == ROCK ? SCISSOR.value : elveMove.value - 1;
            }
            default -> {
                System.out.println("Error: Match invalid");
                return 0;
            }
        }
    }

    public enum Sign
    {
        ROCK(1),
        PAPER(2),
        SCISSOR(3);

        public final int value;
        Sign(int value) {
            this.value = value;
        }
    }

    public enum Outcome
    {
        WIN(6),
        DRAW(3),
        LOSS(0);

        public final int value;
        Outcome(int value) {
            this.value = value;
        }
    }

    private static int getValue(Sign sign, Outcome outcome)
    {
        return sign.value + outcome.value;
    }

}
