/*
 * Copyright (C) 2020 alan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.freeboxos.ftb.client.dlg.config;

import fr.freeboxos.ftb.metier.MetierFactory;
import fr.freeboxos.ftb.metier.config.ConfigMarqueCpuService;
import fr.freeboxos.ftb.metier.entitys.config.ConfigMarqueCpu;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author alan
 */
public class AddConfigMarqueCpuDlg extends javax.swing.JDialog {

    private ConfigMarqueCpu configMarqueCpu = null;
    private final ConfigMarqueCpuService configMarqueCpuService;
    private String paramAll;

    /**
     * Creates new form AddConfigMarqueCpuDlg
     *
     * @param parent
     * @param modal
     */
    public AddConfigMarqueCpuDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.configMarqueCpuService = MetierFactory.getConfigMarqueCpuService();
        this.jLabelTitre.setText("Ajout d'une marque de processeur");
        this.getRootPane().setDefaultButton(jButtonAdd);
        this.repaint();
        this.pack();
    }

    public AddConfigMarqueCpuDlg(JFrame frame, boolean b, String paramAll) {
        super(frame, b);
        initComponents();
        this.setLocationRelativeTo(null);
        this.configMarqueCpuService = MetierFactory.getConfigMarqueCpuService();
        Image icone = Toolkit.getDefaultToolkit().getImage("./icone.png");
        this.setIconImage(icone);
        this.setAllElements(paramAll);
        this.getRootPane().setDefaultButton(jButtonAdd);
        this.repaint();
        this.pack();
        this.paramAll = paramAll;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelTitre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldMarqueProcesseur = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0};
        getContentPane().setLayout(layout);

        jLabelTitre.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(jLabelTitre, gridBagConstraints);

        jLabel2.setText("Marque du processeur");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(jTextFieldMarqueProcesseur, gridBagConstraints);

        jButtonAdd.setText("Ok");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(jButtonAdd, gridBagConstraints);

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        getContentPane().add(jButtonAnnuler, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        configMarqueCpu = null;
        dispose();
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        try {
            String marque = this.jTextFieldMarqueProcesseur.getText();

            List<ConfigMarqueCpu> configMarqueCpus = this.configMarqueCpuService.getAll();

            if (marque.isEmpty()) {
                throw new Exception("Veuillez remplir une marque");
            }

            for (int i = 0; i < configMarqueCpus.size(); i++) {
                if (marque.equals(configMarqueCpus.get(i).toString())) {
                    throw new Exception("Veuillez entrer une autre marque");
                }
            }

            this.configMarqueCpu = new ConfigMarqueCpu(marque);
            configMarqueCpuService.add(configMarqueCpu);
            this.dispose();
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, "Veuillez entre une autre marque", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AddConfigMarqueCpuDlg.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("Convert2Lambda")
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddConfigMarqueCpuDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AddConfigMarqueCpuDlg dialog = new AddConfigMarqueCpuDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JTextField jTextFieldMarqueProcesseur;
    // End of variables declaration//GEN-END:variables

    private void setAllElements(String paramAll) {
        switch (paramAll) {
            case "Marque cpu":
                this.jLabelTitre.setText("Ajout d'une marque de processeur");
                break;
        }
    }
}
