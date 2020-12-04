package game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class Historique {
    public static void writeLog(String informations){
        File fichier =  new File("Etape1/log.txt") ;
        Writer writer = null ;
        try {
            writer =  new FileWriter(fichier,true);
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

    public static void writeNameType(String name,String type,int player){
        String msg = "Joueur " + player +" est " + type +" " + name;
        writeLog(msg);
    }

    public static void writeRoundVictory(int player,int res){
        if (res == 0){
            String msg = "Joueur " + player + "gagne";
            writeLog(msg);
            return;
        }
        else{
            String msg = "Egalité";
            writeLog(msg);
            return;
        }
    }

    public static void writePlayedCoin(int column, int player){
        String msg = "Joueur " + player + " joue " + column;
        writeLog(msg);
    }
}
