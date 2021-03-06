package rocks.zipcode;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by leon on 2/9/18.
 */
public class Console {


    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }
    /*
    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static Integer getIntegerInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        Integer userInput = scanner.nextInt();
        return userInput;
    }

    public static Double getDoubleInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        Double userInput = scanner.nextDouble();
        return userInput;
    }
    */
    public static Character getLetterInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        String userInput;

        while(true){
            userInput = scanner.nextLine().toLowerCase();
            if(userInput.length()==1){
                if(userInput.charAt(0)>='a' && userInput.charAt(0)<='z'){
                    break;
                }
            }
            println("Please enter a single letter:\n");
        }
        return userInput.charAt(0);
    }

    public static boolean keepPlaying() {
        boolean keepPlaying;
        String prompt = "Would you like to play again? (Please enter yes or no)";

        Scanner scanner = new Scanner(System.in);
        println(prompt);
        while(true){
            String userInput = scanner.nextLine();
            if(userInput.equalsIgnoreCase("yes")){
                keepPlaying = true;
                break;
            }
            else if(userInput.equalsIgnoreCase("no")){
                keepPlaying = false;
                break;
            }
            print("Please enter yes or no.\n");
        }

        return keepPlaying;
    }

}

