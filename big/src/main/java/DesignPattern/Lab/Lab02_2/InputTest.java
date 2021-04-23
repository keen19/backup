package DesignPattern.Lab.Lab02_2;

import java.io.*;

public class InputTest {
    public static void main(String[] args) throws Exception {
        int c=0;
//        FileInputStream fileInputStream = new FileInputStream("./src/main/java/DesignPattern/Lab/Lab02_2/test.txt");
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedInputStream bis=new BufferedInputStream(
                new FileInputStream("./src/main/java/DesignPattern/Lab/Lab02_2/test.txt"));
        InputStream reverseInputStream = new ReverseInputStream(bis);

        while ((c = reverseInputStream.read())>=0){
            System.out.print((char) c);
        }

        reverseInputStream.close();
        }
}
