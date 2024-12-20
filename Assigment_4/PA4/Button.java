//Servando Olvera, 1001909287

import javax.swing.*;  
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;  

public class Button implements ActionListener{
    Font big = new Font("",Font.BOLD, 15);
    JFrame frame;
    JTextField text;
    JButton button1, button2;

    public Button() {
        Border border = BorderFactory.createLineBorder(Color.black);

        frame = new JFrame("Buttons"); 
        frame.setSize(400,400);  
        frame.setLayout(null);  

        text = new JTextField();  
        text.setBounds(100,50,200,50);  
        text.setEditable(false);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setBorder(border);
        text.setFont(big);

        button1 = new JButton("Left"); 
        button1.setBounds(50,200,95,50);
        button1.addActionListener(this);
        button1.setFocusable(false);

        button2 = new JButton("Right"); 
        button2.setBounds(250,200,95,50);
        button2.addActionListener(this);
        button2.setFocusable(false); 

        frame.add(text);
        frame.add(button1);
        frame.add(button2);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1) {
            text.setText("Left Button Clicked!");
        }
        if(e.getSource() == button2) {
            text.setText("Right Button Clicked!");
        }
    }

    public static void main(String[] arg) {
        Button buttons = new Button();
    }

}