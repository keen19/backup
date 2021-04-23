package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static GUI.SwingControl.*;

public class Faces extends JFrame {
    private static Icon[] faces;
    private JButton jb,jb2=new JButton("Disable");
    private boolean made=false;
    public Faces(){
        faces=new Icon[]{
                new ImageIcon(getClass().getResource("1.gif")),
                new ImageIcon(getClass().getResource("2.gif")),
                new ImageIcon(getClass().getResource("3.gif")),
                new ImageIcon(getClass().getResource("4.gif")),
                new ImageIcon(getClass().getResource("5.gif")),
        };
        jb=new JButton("JButton",faces[3]);
        setLayout(new FlowLayout());
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(made){
                    jb.setIcon(faces[3]);
                    made=false;
                }else {
                    jb.setIcon(faces[0]);
                    made=true;
                }
                jb.setVerticalAlignment(JButton.TOP);
                jb.setHorizontalAlignment(JButton.LEFT);
            }
        });
        jb.setRolloverEnabled(true);
        jb.setRolloverIcon(faces[1]);
        jb.setPressedIcon(faces[2]);
        jb.setDisabledIcon(faces[3]);
        jb.setToolTipText("yow!");
        jb.setToolTipText("ff");
        add(jb);
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jb.isEnabled()){
                    jb2.setText("eNATABLE");
                    jb.setEnabled(false);
                }else {
                    jb.setEnabled(true);
                    jb2.setText("dISABLE");
                }
            }
        });
        add(jb2);
    }

    public static void main(String[] args) {
        run(new Faces(),250,125);
    }
}
