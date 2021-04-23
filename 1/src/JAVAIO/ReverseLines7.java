package JAVAIO;

import java.io.*;
import java.util.*;

public class ReverseLines7 {
    // Throw exceptions to console:
    public static String readAndReverse(String filename) throws IOException {
        // Reading input by lines:
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        LinkedList<String> list = new LinkedList<String>();
        StringBuilder sb = new StringBuilder(); // For output String
        while((s = in.readLine()) != null){
            list.add(s);
        }// Add each line to LinkedList
        while(list.peekLast() != null){ // While there is a lase line
            sb.append(list.pollLast() + "\n");
        }// Removes line
        in.close();
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        System.out.print(readAndReverse("ReverseLines7.java"));
    }
}