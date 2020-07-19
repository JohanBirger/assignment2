package assignment3;

import java.util.Random;
import java.util.Scanner;

/** A game of rock paper scissor
 * @author teacher
 * Commented by Johan Birgersson
 */

public class Assignment3 {
    /** Executes program
     * @param args not used
     */
    public static void main(String[] args) {
        run();
    }

    /** run method initiates a scanner method to interpret user input.
     *  Adds objects to be assigned value and creates array with elements to be used as markers for values in game. <br>
     *  Whole game is encased in a while loop that constantly checks for a winner or termination, ergo a score value that triggers the <br>
     *  iswinner variable to be true or user input that triggers quit boolean to be true. <br>
     *  If user input is valid, ergo one of the elements in the alternatives array, the computer tries this value against a randomly generated element. <br>
     */

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String inputString = "";
        int[] score;
        String[] alternatives = {"rock", "scissors", "paper"};
        String[] methods = {"crushes", "cuts", "covers"};
        boolean quit = false, isWinner;
        // while the game has not been terminated, computer asks for input.
        while(!quit) {
            user_interface();
            isWinner = false;
            score = new int[2];
            // while game has no winner and has not been terminated, computer asks for input.
            while(!quit && !isWinner) {
                System.out.println("Make your choice (rock, paper or scissors): ");
                inputString = scanner.nextLine().trim();
                // if user input is "q" the program is terminated
                if(inputString.equalsIgnoreCase("Q")) {
                    System.out.println("Bye!");
                    quit = true;
                }
                // handles user input to proceed game, initialising the input as  empty.
                else {
                    int input = -1;
                    // when the input is equal to one of the set alternatives that input is the users choice.
                    for(int i = 0; i < alternatives.length; i ++) {
                        if(alternatives[i].equalsIgnoreCase(inputString)) {
                            input = i;
                        }
                    }
                    // if the user does not provide input, comp tells user to choose a valid input.
                    if(input == -1) {
                        System.out.println("Invalid input. Valid input is rock, paper or scissors.");
                    }
                    //
                    else {
                        // initialising a choice from the computer using the method random with a max if index 3.
                        int computerChoice = new Random().nextInt(3);
                        System.out.println("Computer chooses " + alternatives[computerChoice] + ".");
                        // if computers choice wins the score increases for the computer.
                        if((computerChoice - 1) == input || (computerChoice + 2) == input) {
                            score[0] ++;
                            System.out.println("Your " + alternatives[input] + " " + methods[input] + " computers " +
                                    alternatives[computerChoice] + " (" + score[0] + " - " + score[1] + ").");
                        }
                        //if the computer choice equals the input no score is recorded and the game proceeds.
                        else if(computerChoice == input) {
                            System.out.println("Same choise, no winner.");
                        }

                        else {
                            // if user input wins the score is increased for the user.
                            score[1] ++;
                            System.out.println("Computers " + alternatives[computerChoice] + " " + methods[computerChoice] +
                                    " your " + alternatives[input] + " (" + score[0] + " - " + score[1] + ").");
                        }
                        isWinner = score_limit(score);
                    }
                }
            }
        }
        scanner.close();
    }
    // create method for user interface
    public static void user_interface() {
        System.out.println("** WELCOME TO ROCK-PAPER-SCISSORS **");
        System.out.println("The game where rock crushes scissors, scissors cuts paper and paper covers rock. Best of five wins.");
        System.out.println("Terminate program by typing Q.");
    }

    /** creates method for score keeping, checks for winner
     * @param player variable that holds player score
     * @return score_limit is only used if "if statement" is true
     */

    public static boolean score_limit(int[] player) {
        // someone has score of 3, check if user, if not computer wins.
        if(player[0] == 3 || player[1] == 3) {
            String winner = "Computer";
            // if user has score of 3, user is winner.
            if(player[0] == 3) {
                winner = "You";
            }
            System.out.println(winner + " have won (" + player[0] + " - " + player[1] + ")!");
            return true;
        }

        else {
            return false;
        }
    }
}
