import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TwoPlayer extends JFrame implements ActionListener {

    Container c = getContentPane();
    int count = 0, myValue = 0, temp = 0, mycount = 0;
    String ply;
    int Arr[] = new int[9];
    Font f = new Font("Verdana", Font.PLAIN | Font.BOLD, 35);
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, p;
    Color myColor = null;
    JLabel l=new JLabel();
    String p1,p2;
    TwoPlayer(String p1,String p2) {
       
        this.p1=p1.toUpperCase();
        this.p2=p2.toUpperCase();



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
        l.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,30));

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

        setVisible(true);

    }

    public static void main(String[] args) throws Exception {
        new TwoPlayer("Player1","Player2");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (count == 0) {
            ply = "X";
            myValue = 1;
            count = 1;
            myColor = Color.RED;

        } else {
            ply = "O";
            myValue = 2;
            count = 0;
            myColor = Color.BLUE;
        }
        if (e.getSource() == b1) {
            Arr[0] = myValue;
            isWinner(Arr, b1, myColor, f, ply);

        } else if (e.getSource() == b2) {
            Arr[1] = myValue;
            isWinner(Arr, b2, myColor, f, ply);

        } else if (e.getSource() == b3) {
            Arr[2] = myValue;
            isWinner(Arr, b3, myColor, f, ply);

        } else if (e.getSource() == b4) {
            Arr[3] = myValue;
            isWinner(Arr, b4, myColor, f, ply);

        } else if (e.getSource() == b5) {
            Arr[4] = myValue;
            isWinner(Arr, b5, myColor, f, ply);

        } else if (e.getSource() == b6) {
            Arr[5] = myValue;
            isWinner(Arr, b6, myColor, f, ply);

        } else if (e.getSource() == b7) {
            Arr[6] = myValue;
            isWinner(Arr, b7, myColor, f, ply);

        } else if (e.getSource() == b8) {
            Arr[7] = myValue;
            isWinner(Arr, b8, myColor, f, ply);

        } else if (e.getSource() == b9) {
            Arr[8] = myValue;
            isWinner(Arr, b9, myColor, f, ply);

        } else if (e.getSource() == p) {
            setVisible(false);
            new TwoPlayer(p1,p2);
        }

    }

    public  void isWinner(int arr[], JButton b, Color c, Font f, String ply) {
        // to set fonts,color & text & remove Action Listener
        b.setFont(f);
        b.setForeground(c);
        b.setText(ply);
        b.removeActionListener(this);
        mycount++;

        if (temp != 0) {
            return;

        }else if (Service.isFirstWins(arr)) {
            temp++;
            System.out.println(p1+"is Winner");
            l.setText(p1+" WINS");
            p.setVisible(true);
            SetUnEditableButtons();
        } else if (Service.isSecondWins(arr)) {
            temp++;
            System.out.println(p2+ "is Winner");
            l.setText(p2+" WINS");
            p.setVisible(true);
            SetUnEditableButtons();
        } 
        
        else if (mycount == 9) {
            l.setText("Game Draw . . .");
        System.out.println(" Game Draw . . .");
        p.setVisible(true);

    }
}

public void SetUnEditableButtons()
    {
            JButton b;
            for(int i=0;i<9;i++)
            {
                if(Arr[i]==0)
                {
                    getRandomButton(i).removeActionListener(this);
                    Arr[i]=-1;
                }
            }
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
}

