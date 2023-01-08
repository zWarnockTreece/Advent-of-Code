import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tuning_Trouble {
    public static String input;
    public static void main(String[] args){
        try(BufferedReader br = Files.newBufferedReader(Paths.get("input.txt"))){
            input = br.readLine();
        }catch(Exception e){e.printStackTrace();}

        //int startIndex = start();
        int startIndex = startMessage();
        System.out.println(startIndex);
    }

    static int start(){
        for(int offset = 0; offset < input.length(); offset++){
            int[] chars = new int[26];
            String sequence = input.substring(offset, offset + 4);
            System.out.println(sequence);
            boolean unique = true;

            for(char c : sequence.toCharArray()){
                chars[c - 'a']++;
                if(chars[c - 'a'] > 1) unique = false;
            }

            if(unique){
                return offset + 4;
            }
        }
        return -1;
    }

    static int startMessage(){
        for(int offset = 0; offset < input.length(); offset++){
            int[] chars = new int[26];
            String sequence = input.substring(offset, offset + 14);
            System.out.println(sequence);
            boolean unique = true;

            for(char c : sequence.toCharArray()){
                chars[c - 'a']++;
                if(chars[c - 'a'] > 1) unique = false;
            }

            if(unique){
                return offset + 14;
            }
        }
        return -1;
    }
}
