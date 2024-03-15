import java.util.Scanner;
import java.util.Random;
public class Main{
    
    public static void main(String [] args){
        Random rand= new Random();
        
        int randomNumber= rand.nextInt(100) + 1;
        int trys= 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Random number is " + randomNumber);
        while(true){
        System.out.println(" Enter the number you guessed (0-100)");
        int playerGuess = sc.nextInt();
        trys ++;
        
        if(playerGuess == randomNumber){
            System.out.println("You guessed it right");
            System.out.println("You took " + trys + " number of tries");
            break;
        }
            else if( randomNumber>playerGuess){
                System.out.println("NO ! The number you guessed is smaller.");
            }
            else{
                System.out.println("NO! The number you guessed is higher .");
            }
        
    }
    }
}