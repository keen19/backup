package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;

import static GUI.SwingControl.run;

public class Buttons extends JFrame {
    private  JButton jb=new JButton("JBUtton");
    private BasicArrowButton
    up=new BasicArrowButton(BasicArrowButton.NORTH),
    down=new BasicArrowButton(BasicArrowButton.SOUTH),
    left=new BasicArrowButton(BasicArrowButton.WEST),
    right=new BasicArrowButton(BasicArrowButton.EAST);
    public Buttons(){
        setLayout(new FlowLayout());
        add(jb);
        add(new JToggleButton("JTB"));
        add(new JCheckBox("JCB"));
        add(new JRadioButton("JRB"));
        JPanel jp=new JPanel();
        jp.setBorder(new TitledBorder("DIRECTIONS"));
        jp.add(up);
        jp.add(down);
        jp.add(left);
        jp.add(right);
        add(jp);
    }

    public static void main(String[] args) {
        run(new Buttons(),350,200);
    }
}
