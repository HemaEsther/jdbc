import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Frame1{ 
    Frame1(){
        JFrame frame = new JFrame("Simple Swing Application");
        frame.setSize(180,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton left = new JButton("Left");
        JButton right = new JButton("Right");
        JLabel lbl = new JLabel("Click a button" );
        frame.add(left);
        frame.add(right);
        frame.add(lbl);
        left.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){ 
            lbl.setText("Left Button clicked");
            }
        });
        right.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                lbl.setText("Right Button clicked");
            }
        });
        frame.setVisible(true);



        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new Frame1();
            }
        });
    }
}
