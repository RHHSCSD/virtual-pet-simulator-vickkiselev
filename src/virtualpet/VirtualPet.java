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

import java.util.Scanner;

public class VirtualPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner kb = new Scanner(System.in);
        
        System.out.print("                             ,\n" +
"            ,-.       _,---._ __  / \\\n" +
"           /  )    .-'       `./ /       PET\n" +
"          (  (   ,'            `/    /|  SIMULATOR\n" +
"           \\  `-\"             \\'\\   / |\n" +
"            `.              ,  \\ \\ /  |\n" +
"             /`.          ,'-`-----Y   |\n" +
"            (            ;         |   '\n" +
"            |  ,-.    ,-'          |  /\n" +
"            |  | (   |             | /\n" +
"            )  |  \\  `.___________|/\n" +
"            `--'   `--'");
        
        System.out.println("\n         1. START   2. INSTRUCTIONS  3. EXIT");
        
        System.out.print("Enter next action: ");
        
        switch (kb.nextLine()){
            case "1":
            case "Start":
                System.out.println("Choose an animal:\nCat\nBudgie\nRaccoon");
                String animal = kb.nextLine();
                System.out.print("Are you certain? ");
                switch (kb.nextLine()) {
                    case "yes":
                        System.out.println("Your chosen animal is " + animal);
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
        
    }
    
}
