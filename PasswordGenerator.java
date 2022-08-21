package PasswordGenerator;

import java.util.*;
import java.security.SecureRandom;

public class PasswordGenerator {

    static String lowercase = "abcdefghijklmnopqrstuvwxyz";
    static String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String digit = "0123456789";
    static String specialCharacters = "^$*.[]{}()?-\"!@#%&/\\,><':;|_~`";
    static Random rnd = new SecureRandom();
    static Scanner scn = new Scanner(System.in);
        
    static char[] lowercaseArray = lowercase.toCharArray();
    static char[] uppercaseArray = uppercase.toCharArray();
    static char[] digitArray = digit.toCharArray();


    static void getPassword(int length, boolean specialCharactersValid){
        StringBuilder sb = new StringBuilder(length);
        String allCharacters = "";
        int ind = 3;

        //lowercase, uppercase and number are always included when generating password
        allCharacters = (lowercase + uppercase + digit);
        sb.append(lowercaseArray[rnd.nextInt(lowercaseArray.length)]);
        sb.append(uppercaseArray[rnd.nextInt(uppercaseArray.length)]);
        sb.append(digitArray[rnd.nextInt(digitArray.length)]);

        //adds a special character to the password if selected by the user
        if (specialCharactersValid){
            char[] specialCharactersArray = specialCharacters.toCharArray();
            sb.append(specialCharactersArray[rnd.nextInt(specialCharactersArray.length)]);
            allCharacters += specialCharacters;
            ind++;
            }
        
        //converts all valid characters to an array
        char [] allCharactersArray = allCharacters.toCharArray();

        //fills the rest of the password from the array of valid characters
        for(int a = ind; a< length; a++)
            sb.append(allCharactersArray[rnd.nextInt(allCharactersArray.length)]);
        
        //calls the shuffleString() to shuffle the generated password
        shuffleString(sb.toString());
        return;
    }

    //shuffles the password generated from getPassword()
    static void shuffleString(String sb){
        List<String> characters = Arrays.asList(sb.split(""));
        String password = "";
        Collections.shuffle(characters);
        for (String character : characters)
            password += character;
        System.out.println("Password generated: "+ password);
        return;
    }

}
