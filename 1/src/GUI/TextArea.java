package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.*;
import net.mindview.util.*;
import static GUI.SwingControl.*;


public class TextArea extends JFrame {
    private JButton b=new JButton("增加数据"),
    c=new JButton("清理数据"),
    b3=new JButton("BUTTON3");
    private JTextArea t=new JTextArea(20,40);
    private Map<String,String> m=new HashMap<String,String>();
    public TextArea(){
        m.putAll(Countries.capitals());
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Map.Entry me:m.entrySet()){
                    t.append(me.getKey()+":"+me.getValue()+"\n");
                }
            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.setText("");
            }
        });
        setLayout(new FlowLayout());
        add(new JScrollPane(t));
        add(b);
        add(c);
    }

    public static void main(String[] args) {
        run(new TextArea(),475,425);
    }

}
