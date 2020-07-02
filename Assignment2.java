import javax.swing.*;
import java.util.*;


/** This program takes input from the user, a sentence and a letter, and returns
  * length of sentence, index places of the letter and number of occurances.
  */

public class Assignment2 {

    public static void main(String[] arg) {

        // User gives initial input
        String sentence = JOptionPane.showInputDialog("Enter a sentence: ");
        String letter = JOptionPane.showInputDialog("Enter a letter: ");

        // Counts the number of instances of the letter given in the sentence given
        try{
        int instances = 0;
        int place;
        for (place = 0; place < sentence.length(); place=place+1) {
            if (sentence.charAt(place) == letter.charAt(0))
                instances= instances + 1;

        }
        // Looking for the first instance of the given letter
        int first;
        first= sentence.indexOf(letter);
        // Defining a variable for the last index of the given letter to call in output
        int last_index;
        last_index= sentence.lastIndexOf(letter);

        // Output depending on whether or not the instructions were followed correctly

            if (sentence.length() > 1 && letter.length() > 0)
                if (instances <= 1)
                    JOptionPane.showMessageDialog(null, "The first instance of " + letter + " is at index number  " + first + " \n The last instance is at index number " + last_index + "\n The letter " + letter + " appears " + instances + " time. \n The sentence contains " + sentence.length() + " characters.");
                else
                    JOptionPane.showMessageDialog(null, "The first instance of " + letter + " is at index number " + first + " \n The last instance of " + letter + " is at index number " + last_index + "\n The letter " + letter + " appears " + instances + " times. \n The sentence contains " + sentence.length() + " characters.");
            else
                JOptionPane.showMessageDialog(null, "Please enter both a sentence and one letter");
        }
        catch(StringIndexOutOfBoundsException Exception) {
            JOptionPane.showMessageDialog(null, "Both a sentence and ONE letter");

        }


        }


    }

