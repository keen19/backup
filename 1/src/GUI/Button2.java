package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import  static GUI.SwingControl.*;

public class Button2 extends JFrame {
    private JButton b1=new JButton("BUtton1"),
                    b2=new JButton("BUtton2"),
                    b3=new JButton("BUtton3");
    private JTextField txt=new JTextField(10);
    class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String name=((JButton)e.getSource()).getText();
            txt.setText(name);
        }
    }
    private ButtonListener bl=new ButtonListener();
    public Button2(){
        b1.addActionListener(bl);
        b2.addActionListener(bl);
        b3.addActionListener(bl);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
        add(txt);
    }

    public static void main(String[] args) {
        run(new Button2(),400,150);
    }
}
