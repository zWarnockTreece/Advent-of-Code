import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class No_Space {
    public static HashMap<String, ArrayList<String>> dirs = new HashMap<>();
    public static int total = 0;
    public static Node root = new Node(null, true, 0, "/");
    public static Node currDir = root;
    public static ArrayList<Integer> dirSizes = new ArrayList<>();
    public static void main(String[] args){


        try(BufferedReader br = Files.newBufferedReader(Paths.get("input.txt"))){
            String line;
            while((line = br.readLine()) != null){
                String[] terms = line.split(" ");

                if(!terms[0].equals("$")){
                    boolean dir = (terms[0].equals("dir"));
                    if(dir) currDir.children.add(new Node(currDir, dir, 0, terms[1]));
                    else currDir.children.add(new Node(currDir, dir, Integer.parseInt(terms[0]), terms[0]));

                }else if(terms[1].equals("cd")){
                    if(terms[2].equals("..")) currDir = currDir.parent;
                    else{
                        for(Node n : currDir.children){
                            if(n.name.equals(terms[2])){
                                currDir = n;
                                break;
                            }
                        }
                    }
                }
                
            }
        }catch(Exception e){e.printStackTrace();}

        for(Node n : root.children){
            int a = (getSize(n, true));
        }
        /*System.out.println(dirSizes);
        int sum = 0;
        for(int i : dirSizes) if(i < 100000) sum += i;
        System.out.println(sum);*/

        
        int availableSpace = 70000000 - getSize(root, false);
        int spaceNeeded = 30000000 - availableSpace;
        int minSize = Integer.MAX_VALUE;

        for(int i : dirSizes) if(i > spaceNeeded && i < minSize) minSize = i;
        System.out.println(minSize);
        
    }
    static int getSize(Node node, boolean list){
        int dirSize = 0;
        for(Node n : node.children){
            if(!n.isDir) dirSize += n.size;
            else dirSize += getSize(n, list);
        }
        if(node.isDir && list) dirSizes.add(dirSize);
        return dirSize;
    }
}

class Node{
    public ArrayList<Node> children = new ArrayList<>();
    public Node parent;
    public boolean isDir;
    public int size = 0;
    public ArrayList<Integer> sizes = new ArrayList<>();
    public String name;

    public Node(Node _parent, boolean _isDir, int _size, String _name){
        parent = _parent;
        isDir = _isDir;
        size = _size;
        name = _name;
    }

    public String toString(int offset){
        String out = "";
        for(Node n : children){
            for(int i = 0; i < offset; i++) out += "    ";
            out += n.name;
            out += System.lineSeparator();
            if(n.isDir) out += n.toString(offset + 1);
        }
        return out;
    }
}
