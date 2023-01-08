import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Supply_Stacks {
    public static ArrayList<List<Character>> stacks = new ArrayList<>();
    public static void main(String[] args){
        stacks.add("FCJPHTW".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        stacks.add("GRVFZJBH".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        stacks.add("HPTR".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        stacks.add("ZSNPHT".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        stacks.add("NVFZHJCD".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        stacks.add("PMGFWDZ".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        stacks.add("MVZWSJDP".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        stacks.add("NDS".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        stacks.add("DZSFM".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));

        try(BufferedReader br = Files.newBufferedReader(Paths.get("input.txt"))){
            String line;
            while((line = br.readLine()) != null){
                int[] vals = parseInstruction(line);
                //stack(vals[0], vals[1], vals[2]);
                stack9001(vals[0], vals[1], vals[2]);
            }
        }catch(Exception e){e.printStackTrace();}

        for(int i = 0; i < stacks.size(); i++){
            System.out.println(stacks.get(i));
        }
    }

    static int[] parseInstruction(String instruction){
        int count, origin, target; //Terms 1, 3, and 5
        String[] terms = instruction.split(" ");
        count = Integer.parseInt(terms[1]);
        origin = Integer.parseInt(terms[3]) - 1;
        target = Integer.parseInt(terms[5]) - 1;

        return new int[]{count, origin, target};
    }

    static void stack(int count, int origin, int target){
        for(int i = 0; i < count; i++){
            int stackSize = stacks.get(origin).size();
            char c = stacks.get(origin).get(stackSize - 1);

            stacks.get(origin).remove(stackSize - 1);
            stacks.get(target).add(c);
        }
    }

    static void stack9001(int count, int origin, int target){
        ArrayList<Character> chars = new ArrayList<>();

        for(int i = 0; i < count; i++){
            int stackSize = stacks.get(origin).size();

            char c = stacks.get(origin).get(stackSize - 1);
            stacks.get(origin).remove(stackSize - 1);

            chars.add(c);
        }

        Collections.reverse(chars);
        for(char c : chars) stacks.get(target).add(c);
    }
}
