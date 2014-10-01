package fi.raksamanageri.gui;

import fi.raksamanageri.domain.Peli;
import fi.raksamanageri.logiikka.Tiedostonkasittelija;
import java.awt.Dimension;
import java.io.File;
import javax.swing.JFileChooser;

public class Aloitus extends javax.swing.JFrame {

    public Aloitus() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_uusiPeli = new javax.swing.JButton();
        button_lataaPeli = new javax.swing.JButton();
        button_lopeta = new javax.swing.JButton();
        label_pelinNimiJaVersio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Raksamanageri v.0.1");
        setResizable(false);

        button_uusiPeli.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button_uusiPeli.setText("Uusi peli");
        button_uusiPeli.setToolTipText("Aloita uusi peli");
        button_uusiPeli.setActionCommand("uusiPeli");
        button_uusiPeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_uusiPeliActionPerformed(evt);
            }
        });

        button_lataaPeli.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button_lataaPeli.setText("Lataa peli");
        button_lataaPeli.setToolTipText("Lataa vanha peli");
        button_lataaPeli.setActionCommand("lataaPeli");
        button_lataaPeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_lataaPeliActionPerformed(evt);
            }
        });

        button_lopeta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button_lopeta.setText("Lopeta");
        button_lopeta.setActionCommand("lopeta");
        button_lopeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_lopetaActionPerformed(evt);
            }
        });

        label_pelinNimiJaVersio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_pelinNimiJaVersio.setText("Raksamanageri v.0.1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(293, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_uusiPeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_lataaPeli, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(288, 288, 288))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(button_lopeta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label_pelinNimiJaVersio)
                        .addGap(316, 316, 316))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(label_pelinNimiJaVersio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(button_uusiPeli, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(button_lataaPeli, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181)
                .addComponent(button_lopeta)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_uusiPeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_uusiPeliActionPerformed
        this.setVisible(false);
        Peli uusiPeli = new Peli();
        Paavalikko p = new Paavalikko(uusiPeli);
        p.setPreferredSize(new Dimension(800, 600));
        p.setLocation(this.getLocation().x, this.getLocation().y);
        p.setVisible(true);
    }//GEN-LAST:event_button_uusiPeliActionPerformed

    private void button_lataaPeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_lataaPeliActionPerformed
        // TODO add your handling code here:
        Tiedostonkasittelija k = new Tiedostonkasittelija();

        JFileChooser lataaja = new JFileChooser();
        int paluuArvo = lataaja.showDialog(this, "Lataa");

        Peli peli = null;

        if (paluuArvo == JFileChooser.APPROVE_OPTION) {
            File file = lataaja.getSelectedFile();
            try {
                peli = k.lataaPeli(file);
            } catch (Exception e) {
                // Tiedostonkäsittelijä käy läpi virheet
                // tänne ehkä throws exception? koska try/catch tarpeeton
            }
        }

        if (peli != null) {
            this.setVisible(false);
            Paavalikko p = new Paavalikko(peli);
            p.setPreferredSize(new Dimension(800, 600));
            p.setLocation(this.getLocation().x, this.getLocation().y);
            p.setVisible(true);
        }


    }//GEN-LAST:event_button_lataaPeliActionPerformed

    private void button_lopetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_lopetaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_button_lopetaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Aloitus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aloitus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aloitus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aloitus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aloitus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_lataaPeli;
    private javax.swing.JButton button_lopeta;
    private javax.swing.JButton button_uusiPeli;
    private javax.swing.JLabel label_pelinNimiJaVersio;
    // End of variables declaration//GEN-END:variables
}
