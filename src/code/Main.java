package code;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("ressources/sndbackground.wav");
        try {
            gui.playSound(file);
        } catch (Exception e1) {
            System.out.println("Il y a eu une erreur");
            System.exit(1);
        }
        new gui();
    }

    static char[][] grille = new char[3][3];
    
    static boolean checkVictoire() {
        for (int i=0; i<3; i++) {
            if (grille[0][i] == grille[1][i] && grille[0][i] == grille[2][i] && grille[0][i] != '\u0000') return true;
            if (grille[i][0] == grille[i][1] && grille[i][0] == grille[i][2] && grille[i][0] != '\u0000') return true;
        }
        if (grille[0][0] == grille[1][1] && grille[0][0] == grille[2][2] && grille[0][0] != '\u0000') return true;
        if (grille[0][2] == grille[1][1] && grille[0][2] == grille[2][0] && grille[0][2] != '\u0000') return true;
        for (int  i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (grille[i][j] == '\u0000') return false;
            }
        }
        gui.joueur = 'N';
        return true;
    }
}