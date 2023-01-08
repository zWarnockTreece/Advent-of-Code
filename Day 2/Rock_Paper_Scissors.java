import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Rock_Paper_Scissors {

    public static HashMap<String, Integer> outcomes = new HashMap<>();
    public static void main(String[] args){
        //partOne();
        partTwo();
    }

    static void partOne(){
        char[] opponentMoves = {'A', 'B', 'C'};
        char[] playerMoves = {'X', 'Y', 'Z'};
        char[] comparisonArray = {'A', 'B', 'C', 'A', 'B'};

        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j++){
                char oMove = opponentMoves[i];
                char pMove = playerMoves[j];
                int score = j + 1;

                if(oMove == comparisonArray[j + 2]) score += 6;
                else if(oMove == comparisonArray[j]) score += 3;

                outcomes.put("" + oMove + " " + pMove, score);
            }
        }

        int total = 0;
        try(BufferedReader br = Files.newBufferedReader(Paths.get("input.txt"))){
            String line;
            while((line = br.readLine()) != null){
                total += outcomes.get(line);
            }
        }catch(Exception e){e.printStackTrace();}
        System.out.println(total);
    }

    static void partTwo(){
        char[] opponentMoves = {'A', 'B', 'C'};
        char[] playerMoves = {'X', 'Y', 'Z'};
        char[] comparisonArray = {'A', 'B', 'C', 'A', 'B'};

        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j++){
                char oMove = opponentMoves[i];
                char pMove = playerMoves[j];
                int score = 0;
                
                switch(j){
                    case 0:
                    score += comparisonArray[i + 2] - 64;
                    break;
                    case 1:
                    score += 3;
                    score += comparisonArray[i] - 64;
                    break;
                    case 2:
                    score += 6;
                    score += comparisonArray[i + 1] - 64;
                    break;
                }

                outcomes.put("" + oMove + " " + pMove, score);
            }
        }

        int total = 0;
        try(BufferedReader br = Files.newBufferedReader(Paths.get("input.txt"))){
            String line;
            while((line = br.readLine()) != null){
                total += outcomes.get(line);
            }
        }catch(Exception e){e.printStackTrace();}
        System.out.println(total);
    }
}