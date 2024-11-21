import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ConnectionBuilder;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sign up form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(new GridLayout(6,4));
        
      
        //name
        JLabel name = new JLabel("Name : ");
        JTextField namearea = new JTextField(50);
        //email
        JLabel email = new JLabel("Email : ");
        JTextField emailarea = new JTextField(50);
        //password
        JLabel password = new JLabel("Password : ");
        JPasswordField passarea = new JPasswordField(50);
        //gender
        JLabel gender = new JLabel("Gender : ");
        JRadioButton btn1 = new JRadioButton("Male");
        JRadioButton btn2 = new JRadioButton("Female");
        JRadioButton btn3 = new JRadioButton("Other");
        //grouping buttons
        ButtonGroup grp = new ButtonGroup();
        grp.add(btn1);
        grp.add(btn2);
        grp.add(btn3);
        //button
        JButton register = new JButton("Register user");
        JButton reset = new JButton("Reset");
        //action
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                namearea.setText(null);
                emailarea.setText(null);
                passarea.setText(null);
                grp.clearSelection();
            }
        });

        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String name = namearea.getText();
                String email = emailarea.getText();
                String pass = new String( passarea.getPassword());
                String gender = "";
                if(btn1.isSelected()) gender = "male";
                if(btn2.isSelected()) gender = "female";
                if(btn3.isSelected()) gender = "other";
                //connection - db
                String url = "jdbc:mysql://localhost:3306/javauser";
                String user = "root";
                String password = "hema@23";

                Connection c = null;
                try {
                    c = DriverManager.getConnection(url, user, password);
                    // System.out.println("connection done");
                    String q1 = "Insert into user(name,email,password,gender) values (?,?,?,?)";
                    PreparedStatement stmt = c.prepareStatement(q1);
                    stmt.setString(1, name);
                    stmt.setString(2, email);
                    stmt.setString(3, pass);
                    stmt.setString(4, gender);

                    stmt.executeUpdate();

                    JOptionPane.showMessageDialog(frame, "successful insertion", "succses", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    // TODO: handle exception
                    System.out.println("user not registered"+ex);
                    JOptionPane.showMessageDialog(frame, "unsuccessful insertion", "fail", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        frame.add(name);
        frame.add(namearea);
        frame.add(email);
        frame.add(emailarea);
        frame.add(password);
        frame.add(passarea);
        frame.add(gender);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(register);
        frame.add(reset);

        frame.setVisible(true);
    }
}
