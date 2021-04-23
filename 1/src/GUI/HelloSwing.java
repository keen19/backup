package GUI;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class HelloSwing {
    public static void main(String[] args) throws Exception{
        JFrame frame=new JFrame("Hello SWING");
        JLabel label=new JLabel("A LABEL");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                label.setText("HEY! THIS IS DIFFERENT");
            }
        });


    }
}
