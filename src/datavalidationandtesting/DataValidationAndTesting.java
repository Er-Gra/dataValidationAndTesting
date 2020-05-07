/*
 * May 1st, 2020
 * Erika Graham
 * Data validation and testing using try... catch and a test log
 */
package datavalidationandtesting;

import java.util.Scanner;

public class DataValidationAndTesting {

    public static boolean isInteger(String word){ 
      try{  
        Integer.parseInt(word);
        return true;
        } catch(NumberFormatException e){  
        return false;  
        }  
    }
    
    public static boolean isDouble(String word){
        try{  
        Double.parseDouble(word);
        return true;
        } catch(NumberFormatException e){  
        return false;  
        } 
    }
    
    public static boolean hasLetterZ(String word){
        return word.contains("z"); //assume this is true
    }
    
    public static boolean isOdd (int num1){
        int remainder = num1 % 2;
        
        if (remainder == 1)
        {
            //This is an odd number.
            return true;
        } else
        {
            //this is an even number
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner KeyedInput = new Scanner (System.in);
        
        String word1;
        int value = 0;
        
        //question one -- enter a string that is greater than 6 characters long.
        while(value == 0)
        {//enter word larger than 6 characters long
            System.out.println("Enter a word greater than 6 letters long."); 
            word1 = KeyedInput.nextLine();
            
             //check if the string has numbers
            if((isInteger(word1)==true)||(isDouble(word1)==true)){
                System.out.println("Please enter a word, not a number.");
                System.out.println("");
                value=1; //check that the input is a string and is 6 characters long
            } else if ((word1.length()>=6)&&(isInteger(word1)==false)&&(isDouble(word1)==false)){
                System.out.println("Valid input. Continue to next question.");
                System.out.println("");
                value=1;
            }
        }
        
        //question two -- enter a string that contains at least one lowercase “a”
        while (value ==1){
            String lowercase = "a";
            System.out.println("Enter a word that has at least one lower case 'a' ");
            word1 = KeyedInput.nextLine();
            
            //check that the word has at least one lower case 'a'
            if (word1.contains(lowercase))
            {
                System.out.println("The letter 'a' is in the word.");
                System.out.println("");
                value = 2;
            }else if (isInteger(word1)==true)
            {
                System.out.println("Please enter a word with the letter 'a', not a number");
                System.out.println("");
            }else if(!word1.contains(lowercase))
            {
                System.out.println("invalid input");
                System.out.println("");
            }
        }
        
        //question three -- string that is between 5 and 15 characters long, and does not contain the letter “z”.
        while (value==2)
        {
            
            String lowercasetwo = "z";
            System.out.println("Enter a word that is between 5 and 15 characters long and doesn't contain the letter 'z'");
            word1=KeyedInput.nextLine();
            
            //check if word.length()>=5 && <=15
            
            try{
                if((word1.length()>=5)&&(word1.length()<=15)){
                    if (hasLetterZ(word1)==false)
                    {//output statement when all requirements are complete
                        System.out.println("That's a valid input, you can go to the next stage\n");
                        value=3;
                    }
                }
                if(hasLetterZ(word1)==true){//checks for letter 'z'
                        
                        System.out.println("Invalid input. Please enter a letter that doesn't contain the letter 'z'\n");
                    }
                //check if word contains a z
            } catch(IndexOutOfBoundsException ioobe)
            {
                System.out.println("Please enter a word that is in between 5 and 15 characters.\n");
            }
        }
        
        //question four -- enter an integer between 5 and 500.
        while (value==3){
            boolean flag = false;
            int number =0;
            
            System.out.println("Enter an integer between 5 and 500");
            String inputnumber = KeyedInput.nextLine();
            //check if the String is a number
            
            try {
                number = Integer.parseInt(inputnumber);
                flag = true;
            } catch (NumberFormatException nfe){
                System.out.println("");
            }
            //now that the String is a number, check if the number is within the parameters
            if ((flag==true)&&(number>=5)&&(number<=500)){
                System.out.println("That's a valid input, you can go to the next stage.\n");
                value=4;
            } else {
                System.out.println("That's not a valid input, enter a number greater than 5 and less than 500\n");
            }
        }
        
        //question five -- user must enter a negative integer.
        while (value==4){
            boolean flag = false;
            int number =0;
            
            System.out.println("Enter a negative integer");
            String usernumber = KeyedInput.nextLine();
            
            //check if the String can be converted to a number
             try {
                number = Integer.parseInt(usernumber);
                flag = true;
            } catch (NumberFormatException nfe){
                System.out.println("");
            }
            
            if (number < 0){
                System.out.println("This is a valid input, continue to next question\n");
                value = 5;
            } else {
                System.out.println("That's not a valid input, please enter a negative number");
            }
        }
        
        //question six -- user must enter a positive, odd integer.
        while (value==5){
            int number = 0;
            boolean flag = false;
            
            System.out.println("Enter a positive, odd integer");
            String positive = KeyedInput.nextLine();
            //convert the string to an integer
            try {
                number = Integer.parseInt(positive);
                flag = true;
            } catch (NumberFormatException nfe){
                System.out.println("");
            }
            
            if ((number>0)&&(isOdd(number)==true))
            {
                System.out.println("\nCongratulations, you've entered valid data into this program.\n");
                value = 6;
                 
            }else{
                System.out.println("This is not a valid input");
            }
        }
    }
}
