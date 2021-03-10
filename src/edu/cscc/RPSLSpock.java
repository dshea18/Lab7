package edu.cscc;
import java.util.Random;


/**
 * RPSLSpock Class to validate human pick, determine computer pick and the winner of the RPSLSpock game
 * @author Daniel Shea
 * @version 1.0
 */
public class RPSLSpock {

    static Random rand = new Random(System.currentTimeMillis());

    public static final String ROCK = "rock";
    public static final String PAPER = "paper";
    public static final String SCISSORS = "scissors";
    public static final String LIZARD = "lizard";
    public static final String SPOCK = "spock";


    /**
     * Validate human choice as false or acceptable response
     * @param pick is the humans choice
     * @return false or acceptable h_pick values of ROCK, PAPER, SCISSORS, LIZARD or SPOCK
     */
    public static boolean isValidPick(String pick) {
        if (pick == null) {
            return false;
        }
        pick = pick.trim();
        return (ROCK.equalsIgnoreCase(pick) ||
                PAPER.equalsIgnoreCase(pick) ||
                SCISSORS.equalsIgnoreCase(pick) ||
                LIZARD.equalsIgnoreCase(pick) ||
                SPOCK.equalsIgnoreCase(pick));
    }


    /**
     * Computer opponent's RSPLSpock pick generator
     * @return computer pick values of ROCK, PAPER, SCISSORS, LIZARD or SPOCK
     */
    public static String generatePick() {
        String pick = null;
        switch (rand.nextInt(5)) {
            case 0:
                pick = ROCK;
                break;
            case 1:
                pick = PAPER;
                break;
            case 2:
                pick = SCISSORS;
                break;
            case 3:
                pick = LIZARD;
                break;
            case 4:
                pick = SPOCK;
                break;
        }
        return pick;
    }


    /**
     * Comparison of human pick to computer to determine if computer won
     * @param c_pick Computer's generated value of ROCK, PAPER, SCISSORS, LIZARD or SPOCK
     * @param h_pick Human's pick of ROCK, PAPER, SCISSORS, LIZARD or SPOCK
     * @return True for values of computer winning and False for computer losing
     */
    public static boolean isComputerWin(String c_pick,String h_pick) {
        h_pick = h_pick.toLowerCase();
        return ((ROCK.equals(c_pick) && (SCISSORS.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (PAPER.equals(c_pick) && (ROCK.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SCISSORS.equals(c_pick) && (PAPER.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (LIZARD.equals(c_pick) && (PAPER.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SPOCK.equals(c_pick) && (ROCK.equals(h_pick) || SCISSORS.equals(h_pick))));
    }
}