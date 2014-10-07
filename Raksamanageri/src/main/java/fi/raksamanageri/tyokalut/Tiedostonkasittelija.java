/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.raksamanageri.tyokalut;

import fi.raksamanageri.domain.Peli;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

/**
 * Lataa ja tallentaa raksamanagerin pelin
 *
 */
public class Tiedostonkasittelija {

    /**
     * Tallentaa peli-argumentin pelin annettuun tiedostoon
     * 
     * @param tallennettava tiedosto johon peli tallennetaan
     * @param peli tallennettava peli
     * 
     * @return onnistuiko tallennus
     */
    public boolean tallennaPeli(File tallennettava, Peli peli) {
        try {
            FileOutputStream fileOut
                    = new FileOutputStream(tallennettava.getAbsolutePath());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(peli);
            out.close();
            fileOut.close();
//            System.out.printf("Tallennettu tiedostoon " + tallennettava);
        } catch (IOException i) {
//            i.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Yrittää ladata ladattava-argumentin osoittaman tiedoston ja palauttaa
     * siitä pelin
     * 
     * @param ladattava (tallennus)tiedosto josta peli ladataan
     * 
     * @return onnistuiko lataus 
     */
    public Peli lataaPeli(File ladattava) {
        Peli p = null;
        try {
            FileInputStream fileIn = new FileInputStream(ladattava.getAbsolutePath());
            ObjectInputStream in = new ObjectInputStream(fileIn);
            p = (Peli) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
//            i.printStackTrace();
            JOptionPane.showMessageDialog(null, "Tiedostoa " + ladattava.getAbsolutePath() +
                    " ei löytynyt tai se on vahingoittunut!", "Tiedostovirhe",  WARNING_MESSAGE);
            return null;
        } catch (ClassNotFoundException c) {
//            System.out.println("Peli-luokkaa ei löytynyt");
//            c.printStackTrace();
            return null;
        } 
        return p;
    }
}
