package code;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.*;

public class gui extends guiBASE implements ActionListener {

    gui() {
        BoutonGrilleConfig();
        buttonRESTART.addActionListener(this);
        buttonQUIT.addActionListener(this);
        buttonGIVRA.addActionListener(this);
    }

    static char joueur = 'X';

    private JButton[] button = new JButton[9];

    private void BoutonGrilleConfig() {
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton();
        }
        for (JButton b : button) {
            panelGRILLE.add(b);
            b.setBackground(Color.white);
            b.setFocusable(false);
            b.addActionListener(this);
        }
        panelGRILLE.setLayout(new GridLayout(3, 3));
    }

    private void caseValue(JButton button) {
        ImageIcon croix = new ImageIcon("ressources/imgcroix.png");
        ImageIcon rond = new ImageIcon("ressources/imgrond.png");
        if (joueur == 'X') {
            button.setIcon(croix);
            button.setDisabledIcon(croix);
        } else if (joueur == 'O') {
            button.setIcon(rond);
            button.setDisabledIcon(rond);
        }
        button.setEnabled(false);
    }

    private void switchLabel() {
        if (joueur == 'X') {
            labelJOUEUR.setText("C'est au tour du joueur X");
            labelJOUEUR.setForeground(Color.red);
        } else if (joueur == 'O') {
            labelJOUEUR.setText("C'est au tour du joueur O");
            labelJOUEUR.setForeground(Color.cyan);
        }
    }

    private void FinDePartie(char c) {
        for (JButton b : button) {
            b.setEnabled(false);
        }
        if (joueur != 'N') {
            File file = new File("ressources/sndBRAVO.wav");
            try {
                playSound(file);
            } catch (Exception e1) {
                System.out.println("Il y a eu une erreur");
                System.exit(1);
            }
        } else {
            File file = new File("ressources/sndnula.wav");
            try {
                playSound(file);
            } catch (Exception e1) {
                System.out.println("Il y a eu une erreur");
                System.exit(1);
            }
        }
        switch (c) {
            case 'N':
            labelJOUEUR.setText("Personne n'a gagné :(");
            labelJOUEUR.setForeground(Color.lightGray);
            return;
            case 'O':
            labelJOUEUR.setText("Victoire du joueur O");
            labelJOUEUR.setForeground(Color.green);
            return;
            case 'X':
            labelJOUEUR.setText("Victoire du joueur X");
            labelJOUEUR.setForeground(Color.green);
            return;
        }
    }


    static void playSound(File f) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(f);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }


    private void restartGame() {
        for (int  i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                Main.grille[i][j] = '\u0000';
            }
        }
        joueur = 'X';
        switchLabel();
        for (JButton b : button) {
            b.setEnabled(true);
            ImageIcon voidimg = new ImageIcon("ressources/imgvoid.png");
            b.setIcon(voidimg);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonRESTART) {
            restartGame();
        } else if (e.getSource() == buttonQUIT) {
            System.exit(0);
        } else if (e.getSource() == buttonGIVRA) {
            File file = new File("ressources/sndpampampamchouk.wav");
            try {
                playSound(file);
            } catch (Exception e1) {
                System.out.println("Il y a eu une erreur");
                System.exit(1);
            }
        }
        for (int i=0; i<button.length; i++) {
            if (e.getSource() == button[i]) {
                caseValue(button[i]);
                switch (i) {
                    case 0:
                    Main.grille[0][0] = joueur;
                    break;
                    case 1:
                    Main.grille[0][1] = joueur;
                    break;
                    case 2:
                    Main.grille[0][2] = joueur;
                    break;
                    case 3:
                    Main.grille[1][0] = joueur;
                    break;
                    case 4:
                    Main.grille[1][1] = joueur;
                    break;
                    case 5:
                    Main.grille[1][2] = joueur;
                    break;
                    case 6:
                    Main.grille[2][0] = joueur;
                    break;
                    case 7:
                    Main.grille[2][1] = joueur;
                    break;
                    case 8:
                    Main.grille[2][2] = joueur;
                    break;
                }
                if (Main.checkVictoire()) {
                    FinDePartie(joueur);
                    return;
                }
                if (joueur == 'X') {
                    joueur = 'O';
                    File file = new File("ressources/sndcroix.wav");
                    try {
                        playSound(file);
                    } catch (Exception e1) {
                        System.out.println("Il y a eu une erreur");
                        System.exit(1);
                    }
                } else if (joueur == 'O') {
                    joueur = 'X';
                    File file = new File("ressources/sndrond.wav");
                    try {
                        playSound(file);
                    } catch (Exception e1) {
                        System.out.println("Il y a eu une erreur");
                        System.exit(1);
                    }
                }
                switchLabel();
            }
        } 
    }
}