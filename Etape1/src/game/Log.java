package game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class Log {
    String log;

    void writeLog(String informations){
        File file =  new File("Etape1/log.txt") ;
        Writer writer = null ;

        try {
            writer =  new FileWriter(file,true);
            writer.write(informations + "\n");
        }
        catch (IOException e) {
            System.out.println("Erreur " + e.getMessage()) ;
            e.printStackTrace() ;
        }
        finally {
            if (writer != null) {
                try {
                    writer.close() ;
                }
                catch (IOException e) {
                    System.out.println("Erreur " + e.getMessage()) ;
                    e.printStackTrace() ;
                }
            }
        }
    }

    void writeNameType(String name,String type,int player){
        this.log = "Joueur " + player +" est " + type +" " + name;
    }

    void writeRoundVictory(int player,int res, int round){
        if (res == 0){
            this.log = "Joueur " + player + " gagne";
        }
        else{
            this.log = "Egalité";
        }
    }

    void writePlayedCoin(int column, int player){
        this.log = "Joueur " + player + " joue " + column;
    }

    void writeWinGame(){
        this.log = "Partie finie";
        File file =  new File("Etape1/log.txt") ;
        file.delete();
    }

    void writeInputError(int player){
        this.log = "Erreur saisie Joueur " + player;
    }
    void writeColumnErrorXyz(String error){
        this.log = "Erreur saisie colonne " + error;
    }
    void writeColumnErrorOut(int column){
        this.log = "Erreur colonne non valide " + column;
    }
    void writeColumnErrorFull(int column){
        this.log = "Erreur colonne pleine " + column;
    }
}
