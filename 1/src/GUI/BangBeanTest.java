package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TooManyListenersException;
import static GUI.SwingControl.*;

public class BangBeanTest extends JFrame {
    private JTextField txt=new JTextField(20);
    class BBL implements ActionListener{
        private int count=0;
        @Override
        public void actionPerformed(ActionEvent event){
            txt.setText("BangBean action "+count++);
        }
    }
    public BangBeanTest(){
        BangBean bb=new BangBean();
        try {
            bb.addActionListener(new BBL());
        }catch (TooManyListenersException e){
            txt.setText("TOO MANY LISTENERS");
        }
        add(bb);
        add(BorderLayout.SOUTH,txt);
    }

    public static void main(String[] args) {
        run(new BangBeanTest(),400,500);
    }
}
