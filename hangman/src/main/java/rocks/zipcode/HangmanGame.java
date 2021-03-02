package rocks.zipcode;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class HangmanGame {

    private String[] wordList = {"abstract","assert","boolean","break","byte","case","catch","char","class","continue","default","do","double",
    "else","enum","extends","final","finally","float","for","if","implements","import","instanceof","int","interface","long","native","new",
    "package","private","protected","public","return","short","static","super","switch","synchronized","this","throws","throw","transient",
    "try","void","volatile","while"};


    public void drawScreen(String gameString, String blankSpaces, int guessesLeft){
        System.out.printf("\nCurrent Guesses: %s\n",guessesLeft);
        System.out.printf("%s\n",blankSpaces);
    }

    public void startGame(){
        String gameString = this.generateWord();
        String blankSpaces = this.generateBlankSpaces(gameString);
        int guessesLeft = 5;
        Character letterGuess;

        System.out.printf("Let's Play Hangman!");
        this.drawScreen(gameString,blankSpaces,guessesLeft);

        while(true){
            letterGuess = Console.getLetterInput("Please enter a letter:");
            if(this.checkLetter(gameString,letterGuess)){
                blankSpaces = this.addLettersToBlanks(blankSpaces,getIndexOfCorrectLetter(gameString,letterGuess),letterGuess);
                System.out.printf("\n%s is correct!",letterGuess);
                if(this.checkWin(gameString,blankSpaces)){
                    System.out.printf("\nThe word was \"%s\"!\n",gameString);
                    System.out.printf("Congratulations! You win!\n");
                    break;
                }
            }
            else{
                guessesLeft--;
                System.out.printf("\n%s is incorrect!",letterGuess);
                if(guessesLeft==0){
                    System.out.printf("\nSorry. You lose.\n");
                    System.out.printf("The correct answer was \"%s\".\n",gameString);
                    break;
                }
            }
            this.drawScreen(gameString,blankSpaces,guessesLeft);
        }

        if(Console.keepPlaying()){
            this.startGame();
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

    public String addLettersToBlanks(String blankSpaces,ArrayList<Integer> indices,Character letterGuess){
        char[] charBlankSpace = blankSpaces.toCharArray();
        for(int i=0;i<indices.size();i++){
            charBlankSpace[indices.get(i)*2] = letterGuess;
        }

        String returnString = new String(charBlankSpace);
        return returnString;
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

    public ArrayList<Integer> getIndexOfCorrectLetter(String gameString, Character letterGuess){
        ArrayList<Integer> correctLetterIndices = new ArrayList<>();
        char[] charGameString = gameString.toCharArray();
        for(int i=0;i<charGameString.length;i++){
            if(charGameString[i]==letterGuess){
                correctLetterIndices.add(i);
            }
        }
        return correctLetterIndices;
    }

    public boolean checkWin(String gameString,String blankSpaces){
        char[] charBlankSpaces = blankSpaces.toCharArray();
        String blankSpacesRemoved = "";

        for(int i=0;i<charBlankSpaces.length;i=i+2){
            blankSpacesRemoved += charBlankSpaces[i];
        }

        if(blankSpacesRemoved.equals(gameString)){
            return true;
        }
        else{
            return false;
        }

    }









}
