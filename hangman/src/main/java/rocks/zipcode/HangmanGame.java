package rocks.zipcode;

import java.util.InputMismatchException;

public class HangmanGame {

    private String[] wordList = {"abstract","continue","for","new","switch","assert","default","package",
        "synchronized","boolean","do","if","private","this","break", "double","implements","protected","throw"};
    String gameString = this.generateWord();
    String blankSpaces = this.generateBlankSpaces(gameString);

    public void drawScreen(String gameString, String blankSpaces, int guessesLeft){
        System.out.printf("\nCurrent Guesses: %s\n",guessesLeft);
        System.out.printf("%s\n",blankSpaces);
        System.out.printf("%s\n",gameString);
    }

    public void startGame(){
        int guessesLeft = 5;
        Character letterGuess;

        System.out.println("Let's Play Hangman!");
        this.drawScreen(gameString,blankSpaces,guessesLeft);

        while(guessesLeft>0){
            letterGuess = Console.getLetterInput("Please enter a letter:");
            if(this.checkLetter(gameString,letterGuess)){
                System.out.printf(" %s",this.getIndexOfCorrectLetter(gameString,letterGuess));
            }
            else{
                guessesLeft--;
                System.out.printf("Incorrect\n");
            }
            this.drawScreen(gameString,blankSpaces,guessesLeft);
        }


    }

    public String generateWord(){
        int randomNum = (int)(Math.random()*wordList.length);
        return wordList[randomNum];
    }

    public String generateBlankSpaces(String gameString){
        String blankSpaces = "";
        for(int i=0;i<gameString.length();i++){
            blankSpaces += "_ ";
        }
        return blankSpaces;
    }

    public boolean checkLetter(String gameString, Character letterGuess){
        char[] charGameString = gameString.toCharArray();
        for(int i=0;i<charGameString.length;i++){
            if(charGameString[i]==letterGuess){
                return true;
            }
        }
        return false;
    }

    public int getIndexOfCorrectLetter(String gameString, Character letterGuess){
        char[] charGameString = gameString.toCharArray();
        for(int i=0;i<charGameString.length;i++){
            if(charGameString[i]==letterGuess){
                return i;
            }
        }
        //placeholder
        return 12345;
    }









}
