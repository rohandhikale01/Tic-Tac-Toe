import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class OnePlayer extends JFrame implements ActionListener {

    String p1;
    Container c = getContentPane();
    int count = 0, myValue = 0, temp = 0, mycount = 0;
    String ply;
    int Arr[] = new int[9];
    Font f = new Font("Verdana", Font.PLAIN | Font.BOLD, 35);
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, p;
    Color myColor = null;
    JLabel l = new JLabel();
    boolean flag[] = new boolean[18];

    OnePlayer(String p1) {
        this.p1 = p1.toUpperCase();

        setBounds(600, 200, 315, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        c.setLayout(null);

        b1 = new JButton();
        b1.setBounds(0, 0, 100, 100);
        c.add(b1);

        b2 = new JButton();
        b2.setBounds(100, 0, 100, 100);
        c.add(b2);

        b3 = new JButton();
        b3.setBounds(200, 0, 100, 100);
        c.add(b3);

        b4 = new JButton();
        b4.setBounds(0, 100, 100, 100);
        c.add(b4);

        b5 = new JButton();
        b5.setBounds(100, 100, 100, 100);
        c.add(b5);

        b6 = new JButton();
        b6.setBounds(200, 100, 100, 100);
        c.add(b6);

        b7 = new JButton();
        b7.setBounds(0, 200, 100, 100);
        c.add(b7);

        b8 = new JButton();
        b8.setBounds(100, 200, 100, 100);
        c.add(b8);

        b9 = new JButton();
        b9.setBounds(200, 200, 100, 100);
        c.add(b9);

        p = new JButton("Play Again");
        p.setBounds(50, 400, 200, 30);
        c.add(p);
        p.setVisible(false);
        p.addActionListener(this);

        l.setBounds(20, 350, 400, 30);
        c.add(l);
        l.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

        for (int i = 0; i < 18; i++) {
            flag[i] = true;
        }

        setVisible(true);
    }

    public static void main(String[] args) {

        new OnePlayer("User");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            Arr[0] = 1;
            System.out.println("by 1");
            isWinner(b1, Color.RED, "x");

        } else if (e.getSource() == b2) {
            Arr[1] = 1;
            isWinner(b2, Color.RED, "x");
            System.out.println("by 2");

        } else if (e.getSource() == b3) {
            Arr[2] = 1;
            isWinner(b3, Color.RED, "x");
            System.out.println("by 3");

        } else if (e.getSource() == b4) {
            Arr[3] = 1;
            isWinner(b4, Color.RED, "x");
            System.out.println("by 4");

        } else if (e.getSource() == b5) {
            Arr[4] = 1;
            isWinner(b5, Color.RED, "x");
            System.out.println("by 5");

        } else if (e.getSource() == b6) {
            Arr[5] = 1;
            isWinner(b6, Color.RED, "x");
            System.out.println("by 6");

        } else if (e.getSource() == b7) {
            Arr[6] = 1;
            isWinner(b7, Color.RED, "x");
            System.out.println("by 7");

        } else if (e.getSource() == b8) {
            Arr[7] = 1;
            isWinner(b8, Color.RED, "x");
            System.out.println("by 8");

        } else if (e.getSource() == b9) {
            Arr[8] = 1;
            isWinner(b9, Color.RED, "x");
            System.out.println("by 9");

        } else if (e.getSource() == p) {
            setVisible(false);
            new OnePlayer(p1);
            return;
        }

        isWinner(getButton(), Color.BLUE, "O");

    }

    public void isWinner(JButton b, Color c, String ply) {
        // to set fonts,color & text & remove Action Listener
        b.setFont(f);
        b.setForeground(c);
        b.setText(ply);
        b.removeActionListener(this);
        mycount++;

        if (temp != 0) {
            return;

        } else if (Service.isSecondWins(Arr)) {
            temp = 1;
            System.out.println(" Computer is Winner");
            l.setText("Com. WINS");
            p.setVisible(true);
            SetUnEditableButtons();

        } else if (Service.isFirstWins(Arr)) {
            temp = 1;
            System.out.println(p1 + "is Winner");
            l.setText(p1 + " WINS");
            p.setVisible(true);
            SetUnEditableButtons();

        } else if (mycount == 9) {
            l.setText("Game Draw . . .");
            System.out.println(" Game Draw . . .");
            p.setVisible(true);
            System.out.println("new game ");

            // try {
                SetUnEditableButtons();
            // } catch (Exception m) {
            //     System.out.println("occr");
            // }

        }
    }

    public JButton getButton() {

        if (((Arr[1] == 2 && Arr[2] == 2) || (Arr[4] == 2 && Arr[8] == 2) || (Arr[3] == 2 && Arr[6] == 2))
                && Arr[0] == 0) {
            Arr[0] = 2;
            System.out.println(" At 1 by 1");
            return b1;
        }

        else if (((Arr[0] == 2 && Arr[2] == 2) || (Arr[4] == 2 && Arr[7] == 2)) && Arr[1] == 0) {
            Arr[1] = 2;
            System.out.println(" At 2 by 1");
            return b2;
        } else if (((Arr[0] == 2 && Arr[1] == 2) || (Arr[4] == 2 && Arr[6] == 2) || (Arr[5] == 2 && Arr[8] == 2))
                && Arr[2] == 0) {
            Arr[2] = 2;
            System.out.println(" At 3 by 1");
            return b3;

        }

        else if (((Arr[0] == 2 && Arr[6] == 2) || (Arr[4] == 2 && Arr[5] == 2)) && Arr[3] == 0) {
            Arr[3] = 2;
            System.out.println(" At 4 by 1");
            return b4;

        } else if (((Arr[1] == 2 && Arr[7] == 2) || (Arr[3] == 2 && Arr[5] == 2) || (Arr[0] == 2 && Arr[8] == 2)
                || (Arr[2] == 2 && Arr[6] == 2)) && Arr[4] == 0) {
            Arr[4] = 2;
            System.out.println(" At 5 by 1");
            return b5;

        }

        else if (((Arr[3] == 2 && Arr[4] == 2) || (Arr[2] == 2 && Arr[8] == 2)) && Arr[5] == 0) {
            Arr[5] = 2;
            System.out.println(" At 6 by 1");
            return b6;
        }

        else if (((Arr[0] == 2 && Arr[3] == 2) || (Arr[4] == 2 && Arr[2] == 2) || (Arr[7] == 2 && Arr[8] == 2))
                && Arr[6] == 0) {
            Arr[6] = 2;
            System.out.println(" At 7 by 1");
            return b7;

        }

        else if (((Arr[1] == 2 && Arr[4] == 2) || (Arr[6] == 2 && Arr[8] == 2)) && Arr[7] == 0) {
            Arr[7] = 2;
            System.out.println(" At 8 by 1");
            return b8;

        }

        else if (((Arr[0] == 2 && Arr[4] == 2) || (Arr[2] == 2 && Arr[5] == 2) || (Arr[6] == 2 && Arr[7] == 2))
                && Arr[8] == 0) {
            Arr[8] = 2;
            System.out.println(" At 9 by 1");
            return b9;

        } else if (((Arr[1] == 1 && Arr[2] == 1) || (Arr[4] == 1 && Arr[8] == 1) || (Arr[3] == 1 && Arr[6] == 1))
                && Arr[0] == 0) {
            Arr[0] = 2;
            System.out.println(" At 1");
            return b1;
        }

        else if (((Arr[0] == 1 && Arr[2] == 1) || (Arr[4] == 1 && Arr[7] == 1)) && Arr[1] == 0) {
            Arr[1] = 2;
            System.out.println(" At 2");
            return b2;
        }

        else if (((Arr[0] == 1 && Arr[1] == 1) || (Arr[4] == 1 && Arr[6] == 1) || (Arr[5] == 1 && Arr[8] == 1))
                && Arr[2] == 0) {
            Arr[2] = 2;
            System.out.println(" At 3");
            return b3;
        }

        else if (((Arr[0] == 1 && Arr[6] == 1) || (Arr[4] == 1 && Arr[5] == 1)) && Arr[3] == 0) {

            Arr[3] = 2;
            System.out.println(" At 4");
            return b4;
        }

        else if (((Arr[1] == 1 && Arr[7] == 1) || (Arr[3] == 1 && Arr[5] == 1) || (Arr[0] == 1 && Arr[8] == 1)
                || (Arr[2] == 1 && Arr[5] == 1)) && Arr[4] == 0) {
            Arr[4] = 2;
            System.out.println(" At 5");
            return b5;
        }

        else if (((Arr[2] == 1 && Arr[8] == 1) || (Arr[3] == 1 && Arr[4] == 1)) && Arr[5] == 0) {
            Arr[5] = 2;
            System.out.println(" At 6");
            return b6;
        }

        else if (((Arr[0] == 1 && Arr[3] == 1) || (Arr[4] == 1 && Arr[2] == 1) || (Arr[7] == 1 && Arr[8] == 1))
                && Arr[6] == 0) {
            Arr[6] = 2;
            System.out.println(" At 7");
            return b7;
        }

        else if (((Arr[1] == 1 && Arr[4] == 1) || (Arr[6] == 1 && Arr[8] == 1)) && Arr[7] == 0) {
            Arr[7] = 2;
            System.out.println(" At 8");
            return b8;
        }

        else if (((Arr[0] == 1 && Arr[4] == 1) || (Arr[2] == 1 && Arr[5] == 1) || (Arr[6] == 1 && Arr[7] == 1))
                && Arr[8] == 0) {
            Arr[8] = 2;
            System.out.println(" At 9");
            return b9;
        } else if (isLastButton()) {
            int last_btn = 0;
            for (int i = 0; i < 9; i++) {
                if (Arr[i] == 0) {
                    last_btn = i;
                    break;
                }
            }

            return getRandomButton(last_btn);

        } else {
            Random r = new Random();
            int rand_int1 = r.nextInt(0,9);
            // ThreadLocalRandom.current().nextInt();
            int j = rand_int1;
            boolean myFlag = true;
            while (myFlag) {
                if (Arr[j] == 0) {
                    System.out.println("breaking loop" + j);
                    Arr[j] = 2;
                    myFlag = false;
                    break;
                } else {
                    rand_int1++;
                    j = (rand_int1 % 9);
                }
            }
            return getRandomButton(j);

        }
    }

    public boolean isLastButton() {
        int temp_count = 0;
        for (int i = 0; i < 9; i++) {
            if (Arr[i] == 0) {
                count++;
            }
        }

        if (temp_count == 1)
            return true;
        else
            return false;
    }

    public JButton getRandomButton(int valueAt) {
        if (valueAt == 0)
            return b1;
        else if (valueAt == 1)
            return b2;
        else if (valueAt == 2)
            return b3;
        else if (valueAt == 3)
            return b4;
        else if (valueAt == 4)
            return b5;
        else if (valueAt == 5)
            return b6;
        else if (valueAt == 6)
            return b7;
        else if (valueAt == 7)
            return b8;
        else
            return b9;
    }

    public void SetUnEditableButtons() {
        JButton b;
        for (int i = 0; i < 9; i++) {
            if (Arr[i] == 0) {
                getRandomButton(i).removeActionListener(this);
                Arr[i] = -1;
            }
        }
    }
}
