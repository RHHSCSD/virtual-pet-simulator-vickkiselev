/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;

import java.util.*;
import javax.swing.JOptionPane;
import java.lang.Exception;
import java.io.*;

/*
Program: Pet Simulator
Author: Victoria Kiselev
Date: 19/03/2024
 */
public class VirtualPet {

    /**
     * @param args the command line arguments
     */
    /*
    ----Methods-------------------------------------------------------------------------------------------------------------------------------------
     */
    public static String namedRand() {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        String constantList = "bcdfghjklmnpqrstvwxyz";
        String vowelList = "aeiou";

        String name = "" + constantList.charAt(r.nextInt(0, 21));
        name = name.toUpperCase();

        // Shoeeses a random characters
        for (int i = 0; i < 5; i++) {
            // Character from a vowel list if the iteration number is even 
            if (i % 2 == 0) {
                char extraVowel = vowelList.charAt(r.nextInt(0, 5));
                name = name + extraVowel;
                //If a random integer is 1, it will use a double vowel
                if (r.nextInt(0, 2) == 1) {
                    name = name + extraVowel;
                }
                // Odd iterations will select a random constant
            } else {
                name = name + constantList.charAt(r.nextInt(0, 21));
            }
        }

        return name;
    }

    public static int numberGame() {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        int randNum = r.nextInt(0, 11);
        int points = 0;
        System.out.println("NUMBER GUESSING GAME\nEnter your guesses:");

        // The user has 10 guesses to guess the number before the game ends
        for (int i = 0; i < 11; i++) {

            int numGuess = kb.nextInt();

            // Correct if guess is the random number, subtracts points if incorrect
            if (numGuess == randNum) {
                points = 10 - i;
                System.out.println("Correct!");
                break;
            } else if ((numGuess != randNum) && (i == 10)) {
                System.out.println("Incorrect. You have not guessed the number.");
                points = 0;
            } else {
                System.out.println("Incorrect. Guess again.");
            }
        }

        return points;
    }

    public static int makeRandWord() {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        String constantList = "bcdfghjklmnpqrstvwxyz";
        String vowelList = "aeiou";

        String guessedList = "";

        final String baseWord = "abcde";

        String randWord = "";
        String revealedWord = "";

        int points = 0;

        // Generates a string in two parts using the base word and randomizing the order of the letters
        while (randWord.length() < 5) {
            int randInt = r.nextInt(0, 5);
            char randChar = baseWord.charAt(randInt);
            if (randWord.indexOf(randChar) == -1) {
                randWord += randChar;
            } else {
                continue;
            }
        }
        
        while (randWord.length() < 10) {
            int randInt = r.nextInt(0, 5);
            char randChar = baseWord.charAt(randInt);
            if (randWord.lastIndexOf(randChar) < 5) {
                randWord += randChar;
            } else {
                continue;
            }
        }

        System.out.println("PAIR GUESSING:\nEnter your guesses in the format of (x,y):");

        // 12 guessed to guess the correct pairings
        for (int i = 0; i < 13; i++) {

            // Reset the revealed word each iteration
            revealedWord = "";

            String letterGuess = kb.nextLine();

            int letter1 = letterGuess.charAt(1) - 48;
            int letter2 = letterGuess.charAt(3) - 48;

            // If the letters of each guessed index are the same, it is a correct guess. Otherwise, points are subtracted
            if (randWord.charAt(letter1) == randWord.charAt(letter2)) {
                guessedList = guessedList + randWord.charAt(letter1);
                System.out.println("Correct! The revealed word is:");
            } else {
                points = 20 - i;
                System.out.println("Inorrect. The revealed word is:");
            }
            // Print an X for each letter in the word unless the letter has already been guessed
            for (int j = 0; j < 10; j++) {
                if (guessedList.indexOf(randWord.charAt(j)) == -1) {
                    revealedWord += "X";
                } else {
                    revealedWord += randWord.charAt(j);
                }
            }

            System.out.println(revealedWord);

            // If all letters have been guessed, exit the loop
            if (guessedList.length() == 5) {
                break;
            }

        }
        return points;
    }

    public static int[] generateStats() {

        Random r = new Random();

        int healthMax = r.nextInt(5, 8);
        int foodMax = r.nextInt(5, 8);
        int energyMax = 20 - healthMax - foodMax;

        int[] generatedStats = new int[3];

        generatedStats[0] = healthMax;
        generatedStats[1] = foodMax;
        generatedStats[2] = energyMax;

        return generatedStats;
    }

    // methods to add stats to the file
    public static void addStat(File userFile, String stat) throws Exception {
        PrintWriter toFile = new PrintWriter (userFile);            
        toFile.println(stat);
        toFile.close();
    }
    
    public static void addStat(File userFile, int stat) throws Exception {
        PrintWriter toFile = new PrintWriter (userFile);            
        toFile.println(stat);
        toFile.close();
    }
    public static void addStat(File userFile, int[] stat) throws Exception {
        PrintWriter toFile = new PrintWriter (userFile);            
        toFile.println(stat.toString());
        toFile.close();
    }    


    /*
    -------------------------------------------------------------------------------------------------------------------------------------------------
     */
    public static void main(String[] args) throws Exception {
        /*
        ----Variables--------------------------------------------------------------------------------------------------------------------------------
         */
        String constantList = "bcdfghjklmnpqrstvwxyz";
        String vowelList = "aeiou";

        String animal = "";
        String name = "";
        String username = "";
        String password = "";

        int moneyCount = 0;

        boolean exitCase = false;
        boolean animalCreated = false;

        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        int[] petStats = new int[3];
        int[] currStats = new int[3];
        
        int gameCount = 0;;
        
        /*
        ----MAIN CODE------------------------------------------------------------------------------------------------------------------------------
         */
        System.out.print("                             ,\n"
                + "            ,-.       _,---._ __  / \\\n"
                + "           /  )    .-'       `./ /       PET\n"
                + "          (  (   ,'            `/    /|  SIMULATOR\n"
                + "           \\  `-\"             \\'\\   / |\n"
                + "            `.              ,  \\ \\ /  |\n"
                + "             /`.          ,'-`-----Y   |\n"
                + "            (            ;         |   '\n"
                + "            |  ,-.    ,-'          |  /\n"
                + "            |  | (   |             | /\n"
                + "            )  |  \\  `.___________|/\n"
                + "            `--'   `--'\n");

        username = JOptionPane.showInputDialog("Enter username:");
        File userFile = new File(username + ".txt");

        // if the user's file exists, summon the password and check if it is correct
        if (userFile.exists() == true) {
            animalCreated = true;
            for (int i = 0; i < 3; i++) {
                password = JOptionPane.showInputDialog("Enter password:");
                try {
                    Scanner input = new Scanner(userFile);
                    String correctPassword = input.nextLine();

                    if (password.equals(correctPassword) == true) {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null,"The password is incorrect.");
                    }

                } catch (Exception e) {
                    
                    password = JOptionPane.showInputDialog("Enter new password:");
                    addStat(userFile, password);
                }
            }
        }
        
        // while the user hasn't exited the game, run this loop
        while (exitCase == false) {
            // if an animal has not been created, show the following options, if it has, give the option to play with it
            if (animalCreated == false) {
                System.out.println("\n         1. START   2. INSTRUCTIONS  3. EXIT\n");
                System.out.print("Enter next action: ");
            } else {
                System.out.println("\n         1. PLAY/INTERACT   2. INSTRUCTIONS  3. EXIT\n");
                System.out.print("Enter next action: ");
            }

            switch (kb.nextLine()) {

                case "1":
                case "Start":
                case "Play":
                case "Interact":
                    if (animalCreated == false) {
                        // have user select their pet animal and name it
                        System.out.println("Choose an animal:\nCat\nBudgie\nRaccoon");
                        animal = kb.nextLine();
                        System.out.print("Are you certain? ");
                        switch (kb.nextLine()) {
                            case "yes":
                                System.out.println("Your chosen animal is " + animal);

                                System.out.println("1. SELECT NAME           2.RANDOM NAME");
                                switch (kb.nextLine()) {
                                    case "1":
                                    case "Select":
                                        System.out.print("Enter name: ");
                                        name = kb.nextLine();
                                        break;
                                    case "2":
                                    case "Random":
                                        name = namedRand();
                                        break;
                                }
                                System.out.println("Your pet's name is: " + name);

                                // generate and print the random stats 
                                petStats = generateStats();

                                System.out.print("STATS:\nMax health: " + petStats[0] + ("\nMax food: " + petStats[1] + "\nMax energy: " + petStats[2]));

                                animalCreated = true;
                                break;
                            case "no":
                                exitCase = true;
                                break;
                        }
                    } else {
                        // Guessing number game
                        moneyCount = numberGame() * 100;
                        System.out.println("You have earned $" + moneyCount + " so far.");

                        // Letter pair game
                        moneyCount = moneyCount + makeRandWord() * 100;
                        System.out.println("Thank you for playing, you earned $" + moneyCount + ".");
                        gameCount += 1;
                    }
                    break;
                case "2":
                case "Instructions":
                    System.out.print("Instructions!!");
                    break;
                case "3":
                case "Exit":
                    // add all stats at end of session to the user's file
                    addStat (userFile,animal);
                    addStat (userFile,petStats);
                    addStat (userFile,currStats);
                    addStat (userFile,moneyCount);
                    
                    System.out.println("Day summary:\nPet - "+animal+"\nTimes played: "+gameCount);
                    
                    exitCase = true;
                    break;
            }
        }
    }
}
