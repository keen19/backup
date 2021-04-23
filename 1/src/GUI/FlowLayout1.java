package GUI;

import javax.swing.*;
import java.awt.*;
import static GUI.SwingControl.*;

public class FlowLayout1 extends JFrame {
    public FlowLayout1(){
        setLayout(new GridLayout(7,3));
        for (int i = 0; i < 20; i++) {
            add(new JButton("BUTTON"+i));
        }
    }

    public static void main(String[] args) {
        run(new FlowLayout1(),300,300);
    }
}
