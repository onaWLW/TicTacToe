package code;
import java.awt.*;

import javax.swing.*;

public class guiBASE {

    guiBASE() {
        labelTXTConfig();
        panelGRILLEConfig();
        frameConfig();
        buttonRESTARTConfig();
        buttonQUITConfig();
        labelJOUEURConfig();
        buttonGIVRAConfig();
    }


    JLabel labelJOUEUR = new JLabel();

    private void labelJOUEURConfig() {
        labelJOUEUR.setForeground(new Color(0xFFFFFF));
        labelJOUEUR.setFont(new Font("Arial", Font.BOLD, 30));
        labelJOUEUR.setVerticalAlignment(JLabel.CENTER);
        labelJOUEUR.setHorizontalAlignment(JLabel.CENTER);
        labelJOUEUR.setBounds(520, 275, 500, 300);
        labelJOUEUR.setText("C'est au tour du joueur X");
        labelJOUEUR.setForeground(Color.red);
    }


    private JLabel labelTXT = new JLabel();

    private void labelTXTConfig() {
        labelTXT.setForeground(new Color(0xFFFFFF));
        labelTXT.setText("Bienvenue dans le TIC TAC TOE de qualitééé");
        labelTXT.setFont(new Font("Arial", Font.BOLD, 30));
        labelTXT.setVerticalAlignment(JLabel.CENTER);
        labelTXT.setHorizontalAlignment(JLabel.CENTER);
        labelTXT.setBounds(0, 10, 960, 50);
    }


    JPanel panelGRILLE = new JPanel();

    private void panelGRILLEConfig() {
        panelGRILLE.setBounds(100, 75, 450, 450);
    }


    JFrame frame = new JFrame();

    private void frameConfig() {
        frame.setVisible(true);
        frame.setSize(1000, 600);
        frame.setTitle("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0x474747));
        frame.setLayout(null);
        frame.add(labelTXT);
        ImageIcon image = new ImageIcon("ressources/imglogo.png");
        frame.setIconImage(image.getImage());
        frame.add(panelGRILLE);
        frame.add(buttonRESTART);
        frame.add(buttonQUIT);
        frame.add(labelJOUEUR);
        frame.add(buttonGIVRA);
    }


    JButton buttonRESTART = new JButton();

    private void buttonRESTARTConfig() {
        buttonRESTART.setBounds(650, 100, 200, 50);
        buttonRESTART.setText("RECOMMENCER");
        buttonRESTART.setFocusable(false);
        buttonRESTART.setBackground(Color.lightGray);
        buttonRESTART.setBorder(BorderFactory.createEtchedBorder());
    }


    JButton buttonQUIT = new JButton();

    private void buttonQUITConfig() {
        buttonQUIT.setBounds(650, 200, 200, 50);
        buttonQUIT.setText("QUITTER");
        buttonQUIT.setFocusable(false);
        buttonQUIT.setBackground(Color.lightGray);
        buttonQUIT.setBorder(BorderFactory.createEtchedBorder());
    }

    JButton buttonGIVRA = new JButton();

    private void buttonGIVRAConfig() {
        buttonGIVRA.setBounds(650, 300, 200, 50);
        buttonGIVRA.setText("GIVRA");
        buttonGIVRA.setFocusable(false);
        buttonGIVRA.setBackground(Color.lightGray);
        buttonGIVRA.setBorder(BorderFactory.createEtchedBorder());
    }


}
