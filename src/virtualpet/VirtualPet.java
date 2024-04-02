/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;

import java.util.*;

/*
Program: Pet Simulator
Author: Victoria Kiselev
Date: 19/03/2024
 */
public class VirtualPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String constantList = "bcdfghjklmnpqrstvwxyz";
        String vowelList = "aeiou";

        final String correctUser = "snoopy";
        final String correctPass = "toto";
        
        string name = "";

        Scanner kb = new Scanner(System.in);
        Random r = new Random();

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

        System.out.print("Enter username: ");
        String username = kb.nextLine();

        System.out.print("Enter password: ");
        String password = kb.nextLine();

        if ((username.equals(correctUser)) && (password.equals(correctPass))) {

            System.out.println("\n         1. START   2. INSTRUCTIONS  3. EXIT\n");

            System.out.print("Enter next action: ");

            switch (kb.nextLine()) {
                case "1":
                case "Start":
                    System.out.println("Choose an animal:\nCat\nBudgie\nRaccoon");
                    String animal = kb.nextLine();
                    System.out.print("Are you certain? ");
                    switch (kb.nextLine()) {
                        case "yes":
                            System.out.println("Your chosen animal is " + animal);

                            System.out.println("1. SELECT NAME           2.RANDOM NAME");
                            switch (kb.nextLine()) {
                                case "1":
                                case "Select":
                                    System.out.print("Enter name: ");
                                    String name = kb.nextLine();
                                    break;
                                case "2":
                                case "Random":
                                    name = "" + (constantList.charAt(r.nextInt(0, 21)));
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
                                    break;
                            }
                            System.out.print("You pet's name is: " + randomName);
                            
                            
                            
                            
                            break;
                        case "no":
                            System.exit(0);
                            break;
                    }

                    break;
                case "2":
                case "Instructions":
                    System.out.print("Instructions!!");
                    break;
                case "3":
                case "Exit":
                    System.exit(0);
                    break;
            }
        } else {
            System.out.print("INCORRECT");
            System.exit(0);
        }

    }

}
