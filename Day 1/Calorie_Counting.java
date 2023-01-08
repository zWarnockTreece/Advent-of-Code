import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Calorie_Counting {
    public static ArrayList<ArrayList<Integer>> elvesCalories = new ArrayList<>();
	public static void main(String[] args){
       
        try(BufferedReader br = Files.newBufferedReader(Paths.get("input.txt"))){
            String line;
            ArrayList<Integer> elfCalories = new ArrayList<>();
            while((line = br.readLine()) != null){
                if(!line.equals("")) elfCalories.add(Integer.parseInt(line));
                else{
                    elvesCalories.add(elfCalories);
                    elfCalories = new ArrayList<>();
                }
            }
            elvesCalories.add(elfCalories);
        }catch(Exception e){e.printStackTrace();}

        partOne();
        partTwo();
	}

    static int sum(ArrayList<Integer> values){
        int total = 0;
        for(int i : values) total += i;
        return total;
    }

    static void partOne(){
        int max = Integer.MIN_VALUE;
        for(ArrayList<Integer> l : elvesCalories) max = Integer.max(max, sum(l));
        System.out.println(max);
    }

    static void partTwo(){
        ArrayList<Integer> totals = new ArrayList<>();
        for(ArrayList<Integer> l : elvesCalories) totals.add(sum(l));
        Collections.sort(totals, Collections.reverseOrder());
        
        int top3 = totals.get(0) + totals.get(1) + totals.get(2);
        System.out.println(top3);
    }
}