package GUI;

import jdk.internal.dynalink.beans.StaticClass;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

import static GUI.SwingControl.*;

class SubmitSwingProgram1 extends JFrame {
    JLabel label1;
    public SubmitSwingProgram1(){
        label1=new JLabel("this is a lable");
        add(label1);
    }
}
    public class SubmitSwingProgram {
         static SubmitSwingProgram1 ssp;
        public static void main(String[] args) throws Exception{
        run(ssp=new SubmitSwingProgram1(),300,100);
            TimeUnit.SECONDS.sleep(2);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ssp.label1.setText("hhhhhh");
                }
            });
    }}

