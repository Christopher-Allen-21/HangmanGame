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
            println("Please enter a single letter:");
        }
        return userInput.charAt(0);
    }

}

