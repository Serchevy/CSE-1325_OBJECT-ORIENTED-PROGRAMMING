//Servando Olvera, 1001909287

import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.border.Border;

public class Calculator implements ActionListener{
    Font big = new Font("",Font.BOLD, 30);

    JFrame frame;
    JTextField txtField;
    JPanel panel;

    JButton operations[] = new JButton[6];
    JButton add, sub, mul, div, eql, clr;

    JButton numbers[] = new JButton[10];

    int n1, n2, res;
    char oper;

    public Calculator() {
        Border border = BorderFactory.createLineBorder(Color.black);

        frame = new JFrame("Integer Calclator!");
        frame.setSize(420, 575);
        frame.setLayout(null);

        txtField = new JTextField();
        txtField.setBounds(10, 10, 400, 80);
        txtField.setBorder(border);
        txtField.setEditable(false);
        txtField.setHorizontalAlignment(SwingConstants.RIGHT);
        txtField.setFont(big);

        add = new JButton("+");
        sub = new JButton("-");
        div = new JButton("%");
        mul = new JButton("x");
        eql = new JButton("=");
        clr = new JButton("C");

        operations[0] = add;
        operations[1] = sub;
        operations[2] = mul;
        operations[3] = div;
        operations[4] = eql;
        operations[5] = clr;

        for(int i=0; i<6; i++) {
            operations[i].addActionListener(this);
            operations[i].setFocusable(false);
            operations[i].setFont(big);
        }

        for(int j=0; j<10; j++) {
            numbers[j] = new JButton(Integer.toString(j));
            numbers[j].addActionListener(this);
            numbers[j].setFocusable(false);
            numbers[j].setFont(big);
        }

        panel = new JPanel();
        panel.setBounds(10, 105, 400, 435);  
        panel.setLayout(new GridLayout(4, 4, 10, 10));     
        
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(add);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(sub);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mul);
        panel.add(clr);
        panel.add(numbers[0]);
        panel.add(eql);
        panel.add(div);

        frame.add(panel);
        frame.add(txtField);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<10; i++) {
            if(e.getSource() == numbers[i]) {
                txtField.setText(txtField.getText() + (Integer.toString(i)));
            }
        }

        if(e.getSource() == add) {
            n1 = Integer.parseInt(txtField.getText());
            oper = '+';
            txtField.setText("");
        }
        if(e.getSource() == sub) {
            n1 = Integer.parseInt(txtField.getText());
            oper = '-';
            txtField.setText("");
        }
        if(e.getSource() == div) {
            n1 = Integer.parseInt(txtField.getText());
            oper = '%';
            txtField.setText("");
        }
        if(e.getSource() == mul) {
            n1 = Integer.parseInt(txtField.getText());
            oper = '*';
            txtField.setText("");
        }
        if(e.getSource() == eql) {
            n2 = Integer.parseInt(txtField.getText());
            switch(oper) {
                case '+':
                    res = n1 + n2;
                    break;
                case '-':
                    res = n1 - n2;
                    break;
                case '%':
                    if(n2==0){
                        txtField.setText("ERROR!");
                    }
                    res = n1/n2;
                    break;
                case '*':
                    res = n1 * n2;
                    break;
            }
            txtField.setText(Integer.toString(res));
            n1 = res;
        }
        if(e.getSource() == clr) {
            txtField.setText("");
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    } 
}