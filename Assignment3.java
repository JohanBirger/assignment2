import java.util.Random;
import java.util.Scanner;

/**
 * A game of rock-paper-scissor
 * created by Teacher
 * commented by Johan Birgersson
 */
public class Assignment3 {
    // Creates environment
    public static void main(String[] args) {
        run();
    }
    // executions
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String inputString = "";
        int[] score;
        String[] alternatives = {"rock", "scissors", "paper"};
        String[] methods = {"crushes", "cuts", "covers"};
        boolean quit = false, isWinner;
        // While the game has not been terminated, computer asks for input.
        while(!quit) {
            user_interface();
            isWinner = false;
            score = new int[2];
            // While the game has no winner and has not been terminated, computer asks for input.
            while(!quit && !isWinner) {
                System.out.println("Make your choice (rock, paper or scissors): ");
                inputString = scanner.nextLine().trim();
                //if user input is q quit the program is terminated 
                if(inputString.equalsIgnoreCase("Q")) {
                    System.out.println("Bye!");
                    quit = true;
                }
                //handles user input to proceed game, initialising the input as empty.
                else {
                    int input = -1;
                    // when the input is equal to one of the set alternatives that input is the users choice.
                    for(int choice_from_alternatives = 0; choice_from_alternatives < alternatives.length; choice_from_alternatives ++) {
                        if(alternatives[choice_from_alternatives].equalsIgnoreCase(inputString)) {
                            input = choice_from_alternatives;
                        }
                    }
                    //if the user does not provide input, comp tells user to choose a valid input.
                    if(input == -1) {
                        System.out.println("Invalid input. Valid input is rock, paper or scissors.");
                    }

                    else {
                        //initialising a choice from the computer using the method random with a max of index 3.
                        int computerChoice = new Random().nextInt(3);
                        System.out.println("Computer chooses " + alternatives[computerChoice] + ".");
                        // if computers choice wins the score increases for the computer.
                        if((computerChoice - 1) == input || (computerChoice + 2) == input) {
                            score[0] ++;
                            System.out.println("Your " + alternatives[input] + " " + methods[input] + " computers " +
                                    alternatives[computerChoice] + " (" + score[0] + " - " + score[1] + ").");
                        }
                        //if the computer choice equals the input, no score is recorded and game proceeds.
                        else if(computerChoice == input) {
                            System.out.println("Same choise, no winner.");
                        }

                        else {
                            //if user input wins the score is increased for the user
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

    public static void user_interface() {
        System.out.println("** WELCOME TO ROCK-PAPER-SCISSORS **");
        System.out.println("The game where rock crushes scissors, scissors cuts paper and paper covers rock. Best of five wins.");
        System.out.println("Terminate program by typing Q.");
    }

    public static boolean score_limit(int[] player) {
        //if
        if(player[0] == 3 || player[1] == 3) {
            String winner = "Computer";

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