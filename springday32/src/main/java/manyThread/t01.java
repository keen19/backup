package manyThread;

import org.openjdk.jol.info.ClassLayout;

public class t01 {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());

        }
    }
}
