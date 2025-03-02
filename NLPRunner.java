public class NLPRunner {
  public static void main(String[] args) {

 
  // File paths for the password checking data files  
 String PasswordsFile = "Passwords.txt";
 String NumbersFile = "Numbers.txt";
 String SymbolsFile = "Symbols.txt";
 String UpperCaseLettersFile = "UpperCaseLetters.txt";
 String LowerCaseLettersFile = "LowerCaseLetters.txt";
String LettersFile = "Letters.txt";


    
// Create an instance of the PasswordChecker class by passing file paths    
PasswordChecker passwords = new PasswordChecker(PasswordsFile,NumbersFile,SymbolsFile,UpperCaseLettersFile,LowerCaseLettersFile,LettersFile);


  
// Prompt the user for a password and analyze its strength   
passwords.prompt();

    
    
    
    
  }
}
