import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;  
import java.util.*;

public class TicTacToe extends WindowAdapter implements ActionListener {
    Font big = new Font("",Font.BOLD,125);
    Font small = new Font("",Font.BOLD,75);

    Random random = new Random();

    JFrame popUP;
    JFrame frame = new JFrame("Tic Tac Toe");
    JPanel title = new JPanel();
    JPanel board = new JPanel();
    JLabel text = new JLabel();

    JButton buttons[] = new JButton[9];

    boolean PlayerOneTurn;
    boolean run;

    int count = 0;

    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50)); //Grayish
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text.setBackground(new Color(25,25,25)); // True Black
        text.setForeground(new Color(255, 95, 31)); // Neon Orange
        text.setFont(small);
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("Tic Tac Toe!");
        text.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0,0, 800, 110);

        board.setLayout(new GridLayout(3,3,10,10));
        board.setBackground(new Color(25,25,25)); //True Black

        for(int i=0; i<9; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(new Color(50,50,50)); //Grayish
            board.add(buttons[i]);
            buttons[i].setFont(big);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title.add(text);
        frame.add(title, BorderLayout.NORTH);
        frame.add(board);

        turn();
    }

    public void actionPerformed(ActionEvent e) {
        for(int j=0; j<9; j++) {
            if(e.getSource() == buttons[j]) {
                if(PlayerOneTurn==true) { //Player One's turn
                    if(buttons[j].getText()=="") {
                        buttons[j].setForeground(new Color(255,0,0)); // red
                        buttons[j].setText("X");
                        PlayerOneTurn = false;
                        check();
                        computer_move();
                    }
                } else { //player two's/computer's turn
                    if(buttons[j].getText()=="") {
                        buttons[j].setForeground(new Color(0,0,255)); // blue
                        buttons[j].setText("O");
                        PlayerOneTurn = true;
                        text.setText("Your Turn!");
                        check();
                    }
                }
            }
        }
    }

    public void attempt() {
        int x = random.nextInt(9);
        if(buttons[x].getText()=="") {
            buttons[x].doClick();
        } else {
            attempt();
        }
    }

    public void computer_move() {
        if((buttons[4].getText()=="") && count<1) {
            buttons[4].doClick();
            count++;
        } else if(count<1) {
            attempt();
            count++;
            
        } else {
            if((buttons[0].getText()=="") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) {
                buttons[0].doClick();
            } else if((buttons[0].getText()=="X") && (buttons[1].getText()=="") && (buttons[2].getText()=="X")) {
                buttons[1].doClick();
            } else if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="")) {
                buttons[2].doClick();
            } else if((buttons[3].getText()=="") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) {
                buttons[3].doClick();
            } else if((buttons[3].getText()=="X") && (buttons[4].getText()=="") && (buttons[5].getText()=="X")) {
                buttons[4].doClick();
            } else if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="")) {
                buttons[5].doClick();
            } else if((buttons[6].getText()=="") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) {
               buttons[6].doClick(); 
            } else if((buttons[6].getText()=="X") && (buttons[7].getText()=="") && (buttons[8].getText()=="X")) {
                buttons[7].doClick(); 
            } else if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="")) {
                buttons[8].doClick(); 
            } else if((buttons[0].getText()=="") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) {
                buttons[0].doClick();
            } else if((buttons[0].getText()=="X") && (buttons[3].getText()=="") && (buttons[6].getText()=="X")) {
                buttons[3].doClick();
            } else if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="")) {
                buttons[6].doClick();
            } else if((buttons[1].getText()=="") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) {
                buttons[1].doClick();
            } else if((buttons[1].getText()=="X") && (buttons[4].getText()=="") && (buttons[7].getText()=="X")) {
                buttons[4].doClick();
            } else if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="")) {
                buttons[7].doClick();
            } else if((buttons[2].getText()=="") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) {
                buttons[2].doClick();
            } else if((buttons[2].getText()=="X") && (buttons[5].getText()=="") && (buttons[8].getText()=="X")) {
                buttons[5].doClick();
            } else if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="")) {
                buttons[8].doClick();
            } else if((buttons[0].getText()=="") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) {
                buttons[0].doClick();
            } else if((buttons[0].getText()=="X") && (buttons[4].getText()=="") && (buttons[8].getText()=="X")) {
                buttons[4].doClick();
            } else if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="")) {
                buttons[8].doClick();
            } else if((buttons[2].getText()=="") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) {
                buttons[2].doClick();
            } else if((buttons[2].getText()=="X") && (buttons[4].getText()=="") && (buttons[6].getText()=="X")) {
                buttons[4].doClick();
            } else if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="")) {
                buttons[6].doClick();
            } else if(buttons[0].getText()=="") {
                buttons[0].doClick();
            } else if(buttons[1].getText()=="") {
                buttons[1].doClick();
            } else if(buttons[2].getText()=="") {
                buttons[2].doClick();
            } else if(buttons[3].getText()=="") {
                buttons[3].doClick();
            } else if(buttons[4].getText()=="") {
                buttons[4].doClick();
            } else if(buttons[5].getText()=="") {
                buttons[5].doClick();
            } else if(buttons[6].getText()=="") {
                buttons[6].doClick();
            } else if(buttons[7].getText()=="") {
                buttons[7].doClick();
            } else if(buttons[8].getText()=="") {
                buttons[8].doClick();
            }
        }
    }

    public void turn() {
        try{
            Thread.sleep(2000);
        } catch (InterruptedException ei) {
            ei.printStackTrace();
        }
        PlayerOneTurn = true;
        text.setText("You Go First");
    }

    public void draw() {
        int empty_spaces = 9;
        for(int i=0; i<9; i++) {
            if((buttons[i].getText()=="X") || (buttons[i].getText()=="O")) {
                empty_spaces--;
            }
        }
        if(empty_spaces==0) {
            for(int k=0; k<9; k++) {
                buttons[k].setEnabled(false);
            }
            text.setText("Draw!");
            reset();
        }
    }

    public void check(){
        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) {
            xWins(0,1,2);
        } else if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) {
            xWins(3,4,5);
        } else if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) {
            xWins(6,7,8);
        } else if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) {
            xWins(0,3,6);
        } else if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) {
            xWins(1,4,7);
        } else if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) {
            xWins(2,5,8);
        } else if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) {
            xWins(0,4,8);
        } else if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) {
            xWins(2,4,6);
        } else if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")) {
            oWins(0,1,2);
        } else if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")) {
            oWins(3,4,5);
        } else if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) {
            oWins(6,7,8);
        } else if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")) {
            oWins(0,3,6);
        } else if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")) {
            oWins(1,4,7);
        } else if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")) {
            oWins(2,5,8);
        } else if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")) {
            oWins(0,4,8);
        } else if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) {
            oWins(2,4,6);
        } else {
            draw();
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int k=0; k<9; k++) {
            buttons[k].setEnabled(false);
        }
        text.setText("You Win!");
        reset();
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int k=0; k<9; k++) {
            buttons[k].setEnabled(false);
        }
        text.setText("Computer Wins!");
        reset();
    }

    public void reset(){
        int n = JOptionPane.showConfirmDialog(frame, "Would You Like To PLay Again?","", JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_OPTION) {
            frame.setVisible(false);
            frame.dispose();
            TicTacToe new_game = new TicTacToe();
        } else {
            frame.setVisible(false);
            frame.dispose();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
    }
}