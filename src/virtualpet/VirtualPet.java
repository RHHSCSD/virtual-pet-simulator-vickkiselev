/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;

import java.util.*;
import javax.swing.JOptionPane;

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
    public static String randNamer() {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        String constantList = "bcdfghjklmnpqrstvwxyz";
        String vowelList = "aeiou";

        String name = "" + constantList.charAt(r.nextInt(0, 21));
        name = name.toUpperCase();

        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                char extraVowel = vowelList.charAt(r.nextInt(0, 5));
                name = name + extraVowel;
                if (r.nextInt(0, 2) == 1) {
                    name = name + extraVowel;
                }
            } else {
                name = name + constantList.charAt(r.nextInt(0, 21));
            }
        }

        return name;
    }

    public static void loginOutput() {
            
            final String correctUser = "snoopy";
            final String correctPass = "toto";
            
            for (int i = 0; i < 3; i++) {
                String username = JOptionPane.showInputDialog("Enter username:");
                String password = JOptionPane.showInputDialog("Enter password:");
                System.out.print("Enter password: ");

                if ((username.equals(correctUser)) && (password.equals(correctPass))) {
                    System.out.println("Correct.\n");
                    break;
                } else {
                    if (i == 2) {
                        System.exit(0);
                    }
                    System.out.println("Incorrect. Try again");
                }
            }
        }
  

    /*
    -------------------------------------------------------------------------------------------------------------------------------------------------
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /*
        ----Variables--------------------------------------------------------------------------------------------------------------------------------
         */
        String constantList = "bcdfghjklmnpqrstvwxyz";
        String vowelList = "aeiou";
        String guessedList = "";

        final String baseWord = "abcde";

        String animal = "";
        String name = "";
        String randWord = "";
        String revealedWord = "";

        int moneyCount = 0;
        int pointAmount1 = 0;
        int pointAmount2 = 0;

        boolean exitCase = false;
        boolean animalCreated = false;

        Scanner kb = new Scanner(System.in);
        Random r = new Random();

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

       
        loginOutput();
        
        while (exitCase == false) {
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
                                        name = randNamer();
                                        break;
                                }
                                System.out.println("Your pet's name is: " + name);

                                int healthMax = r.nextInt(5, 8);
                                int foodMax = r.nextInt(5, 8);
                                int energyMax = 20 - healthMax - foodMax;

                                System.out.print("STATS:\nMax health: " + healthMax + ("\nMax food: " + foodMax + "\nMax energy: " + energyMax));

                                animalCreated = true;
                                break;
                            case "no":
                                exitCase = true;
                                break;
                        }
                    } else {
                        // Guessing number game
                        int randNum = r.nextInt(0, 11);
                        System.out.println("Enter your guesses:");

                        for (int i = 0; i < 11; i++) {

                            int numGuess = kb.nextInt();

                            if (numGuess == randNum) {
                                pointAmount1 = 10 - i;
                                System.out.println("Correct!");
                                break;
                            } else if ((numGuess != randNum) && (i == 10)) {
                                System.out.println("Incorrect. You have not guessed the number.");
                                pointAmount1 = 0;
                            } else {
                                System.out.println("Incorrect. Guess again.");
                            }
                        }
                        moneyCount = pointAmount1 * 100;
                        System.out.println("You have earned $" + moneyCount + " so far.");
                        kb.nextLine();

                        // Letter pairs
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

                        System.out.println("Enter your guesses in the format of (x,y):");

                        for (int i = 0; i < 13; i++) {

                            // reset the revealed word each iteration
                            revealedWord = "";

                            String letterGuess = kb.nextLine();

                            int letter1 = letterGuess.charAt(1) - 48;
                            int letter2 = letterGuess.charAt(3) - 48;

                            if (randWord.charAt(letter1) == randWord.charAt(letter2)) {
                                guessedList = guessedList + randWord.charAt(letter1);
                                System.out.println("Correct! The revealed word is:");
                            } else {
                                pointAmount2 = 20 - i;
                                System.out.println("Inorrect. The revealed word is:");
                            }
                            for (int j = 0; j < 10; j++) {
                                if (guessedList.indexOf(randWord.charAt(j)) == -1) {
                                    revealedWord += "X";
                                } else {
                                    revealedWord += randWord.charAt(letter1);
                                }
                            }

                            System.out.println(revealedWord);

                            if (guessedList.length() == 5) {
                                break;
                            }
                        }
                        moneyCount = moneyCount + pointAmount2 * 100;
                        System.out.println("Thank you for playing, you earned $" + moneyCount + ".");
                    }
                    break;
                case "2":
                case "Instructions":
                    System.out.print("Instructions!!");
                    break;
                case "3":
                case "Exit":
                    exitCase = true;
                    break;
            }
        }
    }
}
