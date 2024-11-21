import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Frame1{ 
    Frame1(){
        JFrame frame = new JFrame("Simple Swing Application");
        frame.setSize(180,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel user = new JLabel("Username :");
        JTextField userarea = new JTextField(15);
        JLabel pass = new JLabel("Password :");
        JPasswordField passarea = new JPasswordField(15);
        JButton reset = new JButton("Reset");
        JButton login = new JButton("Login");
        
        frame.add(user);
        frame.add(userarea);
        frame.add(pass);
        frame.add(passarea);
        frame.add(reset);
        frame.add(login);
        
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){ 
            userarea.setText(null);
            passarea.setText(null);
            }
        });
        // login.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e){
        //         lbl.setText("Right Button clicked");
        //     }
        // });
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
