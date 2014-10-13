package fi.raksamanageri.domain;

import fi.raksamanageri.gui.Aloitus;

/**
 * Aloittaa pelin graafisen käyttöliittymän
 */
public class App {

    /**
     * Kutsutaan peli käyntiin komennolla App.main(null);
     * 
     * @param args null
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aloitus().setVisible(true);
            }
        });
    }
}
