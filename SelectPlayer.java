import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectPlayer extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    JRadioButton r1, r2;
    ButtonGroup g;
    JTextField t1, t2, t3;
    JButton b = new JButton("Submit");
    Container c = getContentPane();

    SelectPlayer() {
        setBounds(600, 200, 315, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        c.setLayout(null);

        l1 = new JLabel("Select Players");
        l1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
        l1.setBounds(70, 20, 200, 40);
        c.add(l1);

        r1 = new JRadioButton("One Player");
        r1.setBounds(20, 70, 150, 30);
        c.add(r1);
        r1.addActionListener(this);

        r2 = new JRadioButton("Two Player");
        r2.setBounds(20, 110, 150, 30);
        c.add(r2);
        r2.addActionListener(this);

        g = new ButtonGroup();
        g.add(r1);
        g.add(r2);

        l1 = new JLabel();
        l1.setBounds(20, 150, 250, 30);
        c.add(l1);
        l1.setVisible(false);

        l2 = new JLabel("Name of Player Two: ");
        l2.setBounds(20, 220, 250, 30);
        c.add(l2);
        l2.setVisible(false);

        t1 = new JTextField();
        t1.setBounds(20, 190, 180, 25);
        c.add(t1);
        t1.setVisible(false);

        t2 = new JTextField();
        t2.setBounds(20, 260, 180, 25);
        c.add(t2);
        t2.setVisible(false);

        b.setBounds(100, 300, 100, 30);
        c.add(b);
        b.addActionListener(this);
        b.setVisible(false);
        setVisible(true);

    }

    public static void main(String[] args) {

        new SelectPlayer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            if (r2.isSelected()) {
                if (t1.getText().equals("") || t2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Fill The Fields", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (!firstName(t1.getText().toString().toLowerCase())
                        || !firstName(t2.getText().toString().toLowerCase())) {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid name", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                new TwoPlayer(t1.getText().toString(), t2.getText().toString());
                setVisible(false);
            } else if (r1.isSelected()) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Fill The Fields", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (!firstName(t1.getText().toString().toLowerCase())) {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid name", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                new OnePlayer(t1.getText().toString());
                setVisible(false);

            }
        } else if (r1.isSelected()) {
            l1.setText("Enter Your Name: ");
            l1.setVisible(true);
            l2.setVisible(false);
            t1.setVisible(true);
            t2.setVisible(false);
            b.setVisible(true);
        } else if (r2.isSelected()) {
            l1.setText("Name of Player one: ");
            l1.setVisible(true);
            l2.setVisible(true);
            t1.setVisible(true);
            t2.setVisible(true);
            b.setVisible(true);

        }

    }

    public static boolean firstName(String firstName) {
        return firstName.matches("[a-z]*");
    }

}
