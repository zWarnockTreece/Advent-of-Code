import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Camp_Cleanup {
    public static ArrayList<Assignment[]> pairs = new ArrayList<>();
    public static void main(String[] args) {
        try(BufferedReader br = Files.newBufferedReader(Paths.get("input.txt"))){
            String line;
            while((line = br.readLine()) != null){
                String[] pair = line.split(",");
                String[] p1 = pair[0].split("-");
                String[] p2 = pair[1].split("-");

                int l1 = Integer.parseInt(p1[0]);
                int u1 = Integer.parseInt(p1[1]);
                int l2 = Integer.parseInt(p2[0]);
                int u2 = Integer.parseInt(p2[1]);

                pairs.add(new Assignment[]{new Assignment(l1, u1), new Assignment(l2, u2)});
            }
        }catch(Exception e){e.printStackTrace();}

        partOne();
        partTwo();
    }

    static void partOne(){
        int count = 0;
        for(Assignment[] pair : pairs){
            if(pair[0].isContainedBy(pair[1]) || pair[1].isContainedBy(pair[0])) count++;
        }
        System.out.println(count);
    }

    static void partTwo(){
        int count = 0;
        for(Assignment[] pair : pairs){
            if(pair[0].overlapsWith(pair[1]) || pair[1].overlapsWith(pair[0])) count++;
        }
        System.out.println(count);
    }
}

class Assignment {
    private int lowerBound;
    private int upperBound;

    public Assignment(int _lowerBound, int _upperBound){
        lowerBound = _lowerBound;
        upperBound = _upperBound; 
    }

    public Boolean isContainedBy(Assignment a2){
        return (lowerBound >= a2.lowerBound && upperBound <= a2.upperBound);
    }

    public Boolean overlapsWith(Assignment a2){
        return ((lowerBound >= a2.lowerBound && lowerBound <= a2.upperBound) || (upperBound <= a2.upperBound && upperBound >= a2.lowerBound));
    }

    public String toString(){
        String out = "";
        out += lowerBound;
        out += " - ";
        out += upperBound;
        return out;
    }
}
