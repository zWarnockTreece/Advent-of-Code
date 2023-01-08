import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Rucksack_Reorganization {
    public static ArrayList<String> bags = new ArrayList<>();
    public static void main(String[] args){
        try(BufferedReader br = Files.newBufferedReader(Paths.get("input.txt"))){
            String line;
            while((line = br.readLine()) != null){
                bags.add(line);
            }
        }catch(Exception e){e.printStackTrace();}

        partOne();
        partTwo();
    }

    static void partOne(){
        ArrayList<Integer> priorities = new ArrayList<>();
        for(String s : bags){
            int mid = s.length()/2;

            List<Character> i1 = s.substring(0, mid).chars().mapToObj(e -> (char)e).collect(Collectors.toList());
            List<Character> i2 = s.substring(mid).chars().mapToObj(e -> (char)e).collect(Collectors.toList());;

            for(char c : i1){
                if(i2.indexOf(c) != -1){
                    if(c >= 97) priorities.add(c - 96);
                    else priorities.add(c - 38);
                    break;
                }
            }
        }

        int total = 0;
        for(int i : priorities) total += i;
        System.out.println(total);
    }

    static void partTwo(){
        ArrayList<Integer> priorities = new ArrayList<>();
        ArrayList<String[]> squads = new ArrayList<>();
        for(int i = 0; i < bags.size(); i += 3){
            String[] squad = {bags.get(i), bags.get(i + 1), bags.get(i + 2)};
            squads.add(squad);
        }

        for(String[] s : squads){
            Arrays.sort(s, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2){
                    int l1 = s1.length(); int l2 = s2.length();
                    if(l1 == l2) return 0;
                    else if(l1 > l2) return 1;
                    else return -1;
                }
            });
            List<Character> s1 = s[0].chars().mapToObj(e -> (char)e).collect(Collectors.toList());
            List<Character> s2 = s[1].chars().mapToObj(e -> (char)e).collect(Collectors.toList());
            List<Character> s3 = s[2].chars().mapToObj(e -> (char)e).collect(Collectors.toList());

            for(char c : s1){
                if(s2.indexOf(c) != -1 && s3.indexOf(c) != -1){
                    if(c >= 97) priorities.add(c - 96);
                    else priorities.add(c - 38);
                    break;
                }
            }
        }

        int total = 0;
        for(int i : priorities) total += i;
        System.out.println(total);
    }
}