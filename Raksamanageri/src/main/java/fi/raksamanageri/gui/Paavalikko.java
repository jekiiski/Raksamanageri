package fi.raksamanageri.gui;

import fi.raksamanageri.domain.Peli;
import fi.raksamanageri.tyokalut.Tiedostonkasittelija;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class Paavalikko extends javax.swing.JFrame {
    
    private Peli peli;

    public Paavalikko(Peli p) {
        this.peli = p;
        initComponents();
        this.label_pelaajanRahat.setText("" + this.peli.getPelaaja().annaRahamaara());
        this.label_pelaajallaTyontekijoita.setText("" + this.peli.getPelaaja().annaTyontekijat().size());
        this.label_pelaajanTyomaidenMaara.setText("" + this.peli.getPelaaja().annaTyomaat().size());
        
        // debug
        for (int i=0; i<3; i++) {
            this.peli.arvoUusiTyontekija();
            this.peli.arvoUusiTyomaa();
        }
        
    }
    
    // koe 
    public void updatePaavalikko() {
        this.label_pelaajanRahat.setText("" + this.peli.getPelaaja().annaRahamaara());
        this.label_pelaajallaTyontekijoita.setText("" + this.peli.getPelaaja().annaTyontekijat().size());
        this.label_pelaajanTyomaidenMaara.setText("" + this.peli.getPelaaja().annaTyomaat().size());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_hallitseTyontekijoita = new javax.swing.JButton();
        button_hallitseTyomaita = new javax.swing.JButton();
        button_palkkaaTyontekijoita = new javax.swing.JButton();
        button_etsiTyomaita = new javax.swing.JButton();
        button_tallennaJaLopeta = new javax.swing.JButton();
        button_lopeta = new javax.swing.JButton();
        button_seuraavaVuoro = new javax.swing.JButton();
        label_staticRahaa = new javax.swing.JLabel();
        label_pelaajanRahat = new javax.swing.JLabel();
        label_staticTyontekijoita = new javax.swing.JLabel();
        label_pelaajallaTyontekijoita = new javax.swing.JLabel();
        label_staticAloitettujaTyomaita = new javax.swing.JLabel();
        label_pelaajanTyomaidenMaara = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Päävalikko");
        setResizable(false);

        button_hallitseTyontekijoita.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button_hallitseTyontekijoita.setText("Hallitse työntekijöitäsi");
        button_hallitseTyontekijoita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_hallitseTyontekijoitaActionPerformed(evt);
            }
        });

        button_hallitseTyomaita.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button_hallitseTyomaita.setText("Hallitse työmaitasi");
        button_hallitseTyomaita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_hallitseTyomaitaActionPerformed(evt);
            }
        });

        button_palkkaaTyontekijoita.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button_palkkaaTyontekijoita.setText("Palkkaa työntekijöitä");
        button_palkkaaTyontekijoita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_palkkaaTyontekijoitaActionPerformed(evt);
            }
        });

        button_etsiTyomaita.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button_etsiTyomaita.setText("Etsi uusia työmaita");
        button_etsiTyomaita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_etsiTyomaitaActionPerformed(evt);
            }
        });

        button_tallennaJaLopeta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button_tallennaJaLopeta.setText("Tallenna ja lopeta");
        button_tallennaJaLopeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tallennaJaLopetaActionPerformed(evt);
            }
        });

        button_lopeta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button_lopeta.setText("Lopeta");
        button_lopeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_lopetaActionPerformed(evt);
            }
        });

        button_seuraavaVuoro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button_seuraavaVuoro.setText("Seuraava vuoro");
        button_seuraavaVuoro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_seuraavaVuoroActionPerformed(evt);
            }
        });

        label_staticRahaa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_staticRahaa.setText("Rahaa");

        label_pelaajanRahat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_pelaajanRahat.setText("jLabel1");

        label_staticTyontekijoita.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_staticTyontekijoita.setText("Työntekijöitä");

        label_pelaajallaTyontekijoita.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_pelaajallaTyontekijoita.setText("jLabel2");

        label_staticAloitettujaTyomaita.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_staticAloitettujaTyomaita.setText("Aloitettuja työmaita");

        label_pelaajanTyomaidenMaara.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_pelaajanTyomaidenMaara.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(button_hallitseTyontekijoita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button_palkkaaTyontekijoita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(196, 196, 196))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_staticRahaa)
                                    .addComponent(label_pelaajanRahat))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_staticTyontekijoita)
                                    .addComponent(label_pelaajallaTyontekijoita))
                                .addGap(90, 90, 90)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_pelaajanTyomaidenMaara)
                            .addComponent(label_staticAloitettujaTyomaita)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(button_etsiTyomaita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_hallitseTyomaita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 113, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(button_lopeta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_tallennaJaLopeta)
                        .addGap(141, 141, 141)
                        .addComponent(button_seuraavaVuoro)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_hallitseTyontekijoita)
                    .addComponent(button_hallitseTyomaita))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_palkkaaTyontekijoita)
                    .addComponent(button_etsiTyomaita))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_staticRahaa)
                    .addComponent(label_staticTyontekijoita)
                    .addComponent(label_staticAloitettujaTyomaita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_pelaajanRahat)
                    .addComponent(label_pelaajallaTyontekijoita)
                    .addComponent(label_pelaajanTyomaidenMaara))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_seuraavaVuoro)
                    .addComponent(button_tallennaJaLopeta)
                    .addComponent(button_lopeta))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_lopetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_lopetaActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_button_lopetaActionPerformed

    private void button_hallitseTyontekijoitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_hallitseTyontekijoitaActionPerformed
        // TODO add your handling code here:
        HallitseTyontekijoita ht = new HallitseTyontekijoita(this.peli, this);
        this.setVisible(false);
        ht.setLocation(this.getLocation().x, this.getLocation().y);
        ht.setVisible(true);
    }//GEN-LAST:event_button_hallitseTyontekijoitaActionPerformed

    private void button_hallitseTyomaitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_hallitseTyomaitaActionPerformed
        // TODO add your handling code here:
        HallitseTyomaita htm = new HallitseTyomaita(this.peli, this);
        this.setVisible(false);
        htm.setLocation(this.getLocation().x, this.getLocation().y);
        htm.setVisible(true);
    }//GEN-LAST:event_button_hallitseTyomaitaActionPerformed

    private void button_palkkaaTyontekijoitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_palkkaaTyontekijoitaActionPerformed
        // TODO add your handling code here:
        PalkkaaTyontekijoita pte = new PalkkaaTyontekijoita(this.peli, this);
        this.setVisible(false);
        pte.setLocation(this.getLocation().x, this.getLocation().y);
        pte.setVisible(true);
    }//GEN-LAST:event_button_palkkaaTyontekijoitaActionPerformed

    private void button_etsiTyomaitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_etsiTyomaitaActionPerformed
        // TODO add your handling code here:
        ValitseUusiTyomaa vtm = new ValitseUusiTyomaa(this.peli, this);
        this.setVisible(false);
        vtm.setLocation(this.getLocation().x, this.getLocation().y);
        vtm.setVisible(true);
    }//GEN-LAST:event_button_etsiTyomaitaActionPerformed

    private void button_seuraavaVuoroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_seuraavaVuoroActionPerformed
        // TODO add your handling code here:
        this.peli.seuraavaVuoro();
        updatePaavalikko();
        
        if (this.peli.onkoVoitettu()) {
            JOptionPane.showMessageDialog(null, "Saavutit tavoitteesi 1000000",
                            "Voitto", INFORMATION_MESSAGE);
            this.setVisible(false);
            Aloitus.main(null);
        } else if (this.peli.onkoHavittu()) {
            JOptionPane.showMessageDialog(null, "Olet vararikossa!", "Häviö", INFORMATION_MESSAGE);
            this.setVisible(false);
            Aloitus.main(null);
        }
    }//GEN-LAST:event_button_seuraavaVuoroActionPerformed

    private void button_tallennaJaLopetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tallennaJaLopetaActionPerformed
        // TODO add your handling code here:
        Tiedostonkasittelija k = new Tiedostonkasittelija();
        
        JFileChooser lataaja = new JFileChooser();
        int paluuArvo = lataaja.showDialog(this, "Tallenna");
        
        if (paluuArvo == JFileChooser.APPROVE_OPTION) {
                File file = lataaja.getSelectedFile();
                k.tallennaPeli(file, peli);
        }
        
        System.exit(0);
    }//GEN-LAST:event_button_tallennaJaLopetaActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Paavalikko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Paavalikko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Paavalikko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Paavalikko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Paavalikko(new Peli()).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_etsiTyomaita;
    private javax.swing.JButton button_hallitseTyomaita;
    private javax.swing.JButton button_hallitseTyontekijoita;
    private javax.swing.JButton button_lopeta;
    private javax.swing.JButton button_palkkaaTyontekijoita;
    private javax.swing.JButton button_seuraavaVuoro;
    private javax.swing.JButton button_tallennaJaLopeta;
    private javax.swing.JLabel label_pelaajallaTyontekijoita;
    private javax.swing.JLabel label_pelaajanRahat;
    private javax.swing.JLabel label_pelaajanTyomaidenMaara;
    private javax.swing.JLabel label_staticAloitettujaTyomaita;
    private javax.swing.JLabel label_staticRahaa;
    private javax.swing.JLabel label_staticTyontekijoita;
    // End of variables declaration//GEN-END:variables
}
