package fi.raksamanageri.logiikka;

import java.util.ArrayList;

public class Tyontekija {

    private int palkka;
    private final boolean kotimainen;
    private int tyoteho;
    private ArrayList patevyydet;
    private Tyomaa tyoMaa;
    private String nimi;

    public Tyontekija(boolean onkoKotimainen, String nimi) {
        this.kotimainen = onkoKotimainen;
        this.patevyydet = new ArrayList<Patevyys>();
        this.tyoMaa = null;
        this.nimi = nimi;

        if (onkoKotimainen) {
            this.palkka = 1000;
            this.tyoteho = 10;
        } else {
            this.palkka = 400;
            this.tyoteho = 8;
        }
    }

    public ArrayList annaPatevyydet() {
        return this.patevyydet;
    }

    public void lisaaPatevyys(Patevyys patevyys) {
        if (!this.patevyydet.contains(patevyys)) {
            this.patevyydet.add(patevyys);
            this.tyoteho++;
            this.palkka += 100;
        }
    }

    public int getPalkka() {
        return this.palkka;
    }

    public void setPalkka(int maara) {
        if (maara > 0) {
            this.palkka = maara;
        }
    }

    public int getTyoteho() {
        return this.tyoteho;
    }

    public void setTyoTeho(int tyoteho) {
        if (tyoteho > 0) {
            this.tyoteho = tyoteho;
        } 
    }

    public boolean onkoKotimainen() {
        return this.kotimainen;
    }
    
    public void laitaToihin(Tyomaa maa) {
        this.tyoMaa = maa;
    }
    
    public void poistaTyomaalta() {
        this.tyoMaa = null;
    }
    
    public Tyomaa missaToissa() {
        return this.tyoMaa;
    }
    
    @Override
    public String toString() {
        String koti = "";
        if (this.onkoKotimainen()) {
            koti = "Kotimainen";
        } else {
            koti = "Ulkomainen";
        }
        return koti + " työntekijä, palkka: " + this.palkka
                + ", työteho: " + this.tyoteho;
    }

}
