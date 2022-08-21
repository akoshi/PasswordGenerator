package PasswordGenerator;

import java.util.*;

public class Main {

    public static void main(String[] args){
        System.out.println("Welcome to Password Generator!");
        System.out.println("Passwords has a minimum length of 6 and maximum length of 20.");
        System.out.println("A lowercase, uppercase, and a number are always included. Special characters are optional.");
        Scanner scn = new Scanner(System.in);
        int length = getLength(scn);
        boolean specialCharactersValid = getSpecialCharacters(scn);
    
        PasswordGenerator.getPassword(length, specialCharactersValid);
    }

    static int getLength(Scanner scn){
        int length = 0;
        System.out.println("Please enter length between 6 and 20.");
        while(true){
            try {
                length = scn.nextInt();
                if(length >= 6 && length <= 20){
                    return length;
                }
                System.out.print("Invalid length. Please enter length between 6 and 20.");
            }catch(InputMismatchException e){
                System.out.print("Invalid length input. Please enter an integer.");
                scn.nextLine();
            }
        }
        
    }

    static boolean getSpecialCharacters(Scanner input){
        String specialCharacter = " ";
        System.out.println("Do you want special characters? Please enter Y/N.");
        
        while(true){
            specialCharacter = input.next();
            if(specialCharacter.equalsIgnoreCase("y")){
                input.close();
                return true;
            }
            else if(specialCharacter.equalsIgnoreCase("n")){
                input.close();
                return false;
            }
            else{
                System.out.println("Please enter Y or N");
                input.nextLine();
            }
        }
    }

}
