package fi.raksamanageri.logiikka;

import java.util.ArrayList;

public class Tyontekija {
    private final int palkka;
    private final boolean kotimainen;
    private int tyoteho;
    //private final ArrayList patevyydet;
    
    public Tyontekija(boolean onkoKotimainen) {
        this.kotimainen = onkoKotimainen;
        //this.patevyydet = new ArrayList<Patevyys>();
        
        if (onkoKotimainen) {
            this.palkka = 1000;
            this.tyoteho = 10;
        } else {
            this.palkka = 400;
            this.tyoteho = 8;
        }
    }
    
//    public ArrayList annaPatevyydet() {
//        return this.patevyydet;
//    }
    
//    public void lisaaPatevyys(Patevyys patevyys) {
//        if (!this.patevyydet.contains(patevyys)) {
//            this.patevyydet.add(patevyys);
//            this.tyoteho++;
//            this.palkka += 100;
//        }
//    }
    
    public int getPalkka() {
        return this.palkka;
    }
    
    public int getTyoteho() {
        return this.tyoteho;
    }
    
    public boolean onkoKotimainen() {
        return this.kotimainen;
    }
    
    @Override
    public String toString() {
        String koti = "";
        if (this.onkoKotimainen()) {
            koti = "Kotimainen";
        } else {
            koti = "Ulkomainen";
        }
        return koti + " työntekija, palkka: " + this.palkka +
                    ", työteho: " + this.tyoteho;
    }
    
}
