import java.util.ArrayList;
import java.util.Scanner;

public class PasswordChecker{

    // Declare lists to store passwords and character sets
private ArrayList<String> passwords;
private ArrayList<String> numbers;
private ArrayList<String> symbols;
private ArrayList<String> uppercaseletters;
private ArrayList<String> lowercaseletters;
private ArrayList<String> letters;
private ArrayList<String> StrongPassword = new ArrayList<>();


 
  
/*
 * Constructor to initialize lists with data from files.
 * @param PasswordsFile The file containing common passwords.
 * @param NumbersFile The file containing common numbers.
 * @param SymbolsFile The file containing common symbols.
 * @param UpperCaseLettersFile The file containing uppercase letters.
 * @param LowerCaseLettersFile The file containing lowercase letters.
 * @param LettersFile The file containing all letters.
  */
  public PasswordChecker(String PasswordsFile, String NumbersFile, String SymbolsFile, String UpperCaseLettersFile, String LowerCaseLettersFile,String LettersFile) {
    this.passwords = FileReader.toStringList(PasswordsFile);
    this.numbers = FileReader.toStringList(NumbersFile);
    this.symbols = FileReader.toStringList(SymbolsFile);
    this.uppercaseletters = FileReader.toStringList(UpperCaseLettersFile);
    this.lowercaseletters = FileReader.toStringList(LowerCaseLettersFile);
    this.letters = FileReader.toStringList(LettersFile);
  }

 /*
  * Prompts the user to enter a password and analyzes its strength.
  */  
public void prompt(){

Scanner input = new Scanner(System.in);
String user = "";
String Password1 = "";
boolean status = true;

System.out.print("Hello there what is your name? ");
    user = input.nextLine();

System.out.print("Hi "  + user + ", please enter your password: ");
    Password1 = input.nextLine();
 System.out.println("");
  
   // Store password in an array
  passwordInArray(Password1);

    // Check if the password is common
   if (confirmPassword(Password1)) {
          System.out.println("Your password is common");
    }
   else {
          System.out.println("Your password is uncommon");
    }

  // Checking for symbols
 if (checkForSymbols(Password1)) {
          System.out.println("Your password has symbols");
    }
   else {
          System.out.println("Your password has no symbols");
          StrongPassword.add("$");
          status = false;
    }

    // Checking for numbers
  if (checkForNumbers(Password1)) {
          System.out.println("Your password has numbers");
    }
   else {
          System.out.println("Your password has no numbers");
          StrongPassword.add("2");
          status = false;
    }

    // Checking for uppercase letters
    if (checkForUpperCase(Password1)) {
          System.out.println("Your password has uppercase letter");
    }
   else {
          System.out.println("Your password does not have upper case letters");
          StrongPassword.add("W");
          status = false;
    }

   // Checking for lowercase letters
  if (checkForLowerCase(Password1)) {
          System.out.println("Your password has lowercase letter");
    }
   else {
          System.out.println("Your password does not have lowercase letters");
          StrongPassword.add("x");
          status = false;
    }

    System.out.println("");
  
    // Print the new strong password if necessary
   if (status == true){
    System.out.println("Your current password is strong ");
   }
   else  System.out.println("Your new strong password is ");

    // Print the new strong password
     int length = StrongPassword.size();
     for (int z = 0; z < length ; z++){
         System.out.print(StrongPassword.get(z));
     }
}
  /*
   * Stores the user's password in an array for processing.
   * @param InputPassword The password entered by the user.
   */
public void passwordInArray(String InputPassword){
     int length = InputPassword.length();
     for (int index = 0; index < length; index ++){
          StrongPassword.add(InputPassword.substring(index, index+1));
    }
}
  /*
   * This is my student developed algorithm.
   * Checks if the password contains symbols.
   * @param InputPassword The password entered by the user.
   * @return True if a symbol is found, false otherwise.
   */
  public boolean checkForSymbols(String InputPassword){
     boolean checksymbols = false;
     int length = InputPassword.length();
     for (int index = 0; index < length; index ++){

         for(int y = 0; y < symbols.size(); y++ ) {
             String currentLine = symbols.get(y);
             if (currentLine.equals(InputPassword.substring(index, index+1))){
             checksymbols = true;
            }
        }
     }
return checksymbols;
}

/*
 * This is my student developed algorithm.
 * Checks if the password contains numbers.
 * @param InputPassword The password entered by the user.
 * @return True if a number is found, false otherwise.
 */
public boolean checkForNumbers(String InputPassword){
     boolean checknumbers = false;
     int length = InputPassword.length();
     for (int index = 0; index < length; index ++){

         for(int y = 0; y < numbers.size(); y++ ) {
             String currentLine = numbers.get(y);
             if (currentLine.equals(InputPassword.substring(index, index+1))){
             checknumbers = true;
            }
        }
     }
return checknumbers;
}

/**
  * This is my student created algorithm.
  * Checks if the password contains uppercase letters.
  * @param InputPassword The password entered by the user.
  * @return True if an uppercase letter is found, false otherwise.
  */
public boolean checkForUpperCase(String InputPassword){
     boolean checkUpperCase = false;
     int length = InputPassword.length();
     for (int index = 0; index < length; index ++){

         for(int y = 0; y < uppercaseletters.size(); y++ ) {
             String currentLine = uppercaseletters.get(y);
             if (currentLine.equals(InputPassword.substring(index, index+1))){
             checkUpperCase = true;
            }
        }
     }
return checkUpperCase;
}
 /**
  * This is my student created algorithm.
  * Checks if the password contains characters from a given list.
  * @param inputPassword The password entered by the user.
  * @param characterList  The list of characters to check from.
  * @return True if the password contains any character from the list, false otherwise.
     */
  public boolean checkForLowerCase(String InputPassword){
     boolean checkLowerCase = false;
     int length = InputPassword.length();
     for (int index = 0; index < length; index ++){

         for(int y = 0; y < lowercaseletters.size(); y++ ) {
             String currentLine = lowercaseletters.get(y);
             if (currentLine.equals(InputPassword.substring(index, index+1))){
             checkLowerCase = true;
            }
        }
     }
return checkLowerCase;
}

  /**
     * Checks if the password is found in a list of common passwords.
     * @param inputPassword The password entered by the user.
     * @return True if the password is found in the list, false otherwise.
     */
public boolean confirmPassword(String InputPassword) {
    boolean passwordFound = false;
  
    for (int index = 0; index < passwords.size(); index++) {
        String currentLine = passwords.get(index);
        if (currentLine.equals(InputPassword)) {
        passwordFound = true;
        }
    }
    return passwordFound;
 }

  
    }
