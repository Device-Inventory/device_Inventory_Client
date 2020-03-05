/*
 * Copyright (C) 2019 alan
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
package fr.freeboxos.ftb.client.dlg;

import fr.freeboxos.ftb.client.ihm.LoginIhm;
import fr.freeboxos.ftb.metier.MetierFactory;
import fr.freeboxos.ftb.metier.entitys.HDD;
import fr.freeboxos.ftb.metier.entitys.Memoire;
import fr.freeboxos.ftb.metier.entitys.Ordinateur;
import fr.freeboxos.ftb.metier.entitys.Processeur;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author alan
 */
public class AddOrdinateurDlg extends javax.swing.JDialog {

    private Ordinateur ordinateur = null;
    @SuppressWarnings("FieldMayBeFinal")
    private List<Processeur> processeurs;
    @SuppressWarnings("FieldMayBeFinal")
    private List<Memoire> memoires;
    @SuppressWarnings("FieldMayBeFinal")
    private List<HDD> hdds;
    @SuppressWarnings("FieldMayBeFinal")
    private List<Ordinateur> ordinateurs;
    private long id = 0;

    /**
     * Creates new form AddOrdinateurDlg
     *
     * @param parent
     * @param modal
     * @throws java.lang.Exception
     */
    public AddOrdinateurDlg(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.jLabelTitre.setText("Ajout d'un ordinateur");
        this.ordinateurs = MetierFactory.getOrdinateurService().getAll();

        Processeur p;
        this.processeurs = MetierFactory.getProcesseurService().getAll();

        Memoire m;
        this.memoires = MetierFactory.getMemoireService().getAll();

        HDD hdd;
        this.hdds = MetierFactory.getHDDService().getAll();

        for (Ordinateur ordinateur1 : this.ordinateurs) {
            for (int i = 0; i < this.processeurs.size(); i++) {

                p = this.processeurs.get(i);

                if (ordinateur1.getProcesseur().getId() == p.getId()) {
                    this.processeurs.remove(p);
                }
            }

            for (int i = 0; i < this.memoires.size(); i++) {
                m = this.memoires.get(i);
                if (ordinateur1.getMemoire().getId() == m.getId()) {
                    this.memoires.remove(m);
                }
            }

            for (int i = 0; i < this.hdds.size(); i++) {
                hdd = this.hdds.get(i);
                if (ordinateur1.getHdd().getId() == hdd.getId()) {
                    this.hdds.remove(hdd);
                }
            }
        }

        Object[] objects = this.processeurs.toArray();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(objects);
        this.jComboBoxProcesseur.setModel(dcbm);

        objects = this.memoires.toArray();
        DefaultComboBoxModel dcbm1 = new DefaultComboBoxModel(objects);
        this.jComboBoxMemoire.setModel(dcbm1);

        objects = this.hdds.toArray();
        DefaultComboBoxModel dcbm2 = new DefaultComboBoxModel(objects);
        this.jComboBoxDisqueDur.setModel(dcbm2);

        this.repaint();
        this.pack();
    }

    public AddOrdinateurDlg(JFrame frame, boolean b, Ordinateur ordinateur) throws Exception {
        super(frame, b);
        initComponents();
        this.setLocationRelativeTo(null);
        this.jLabelTitre.setText("Modification d'un ordinateur");
        this.id = ordinateur.getId();
        this.ordinateurs = MetierFactory.getOrdinateurService().getAll();

//        Processeur p;
        this.processeurs = MetierFactory.getProcesseurService().getAll();

//        Memoire m;
        this.memoires = MetierFactory.getMemoireService().getAll();

//        HDD hdd;
        this.hdds = MetierFactory.getHDDService().getAll();

//        for (Ordinateur ordinateur1 : this.ordinateurs) {
//            for (int i = 0; i < this.processeurs.size(); i++) {
//
//                p = this.processeurs.get(i);
//
//                if (ordinateur1.getProcesseur().getId() == p.getId()) {
//                    this.processeurs.remove(p);
//                }
//            }
//
//            for (int i = 0; i < this.memoires.size(); i++) {
//                m = this.memoires.get(i);
//                if (ordinateur1.getMemoire().getId() == m.getId()) {
//                    this.memoires.remove(m);
//                }
//            }
//
//            for (int i = 0; i < this.hdds.size(); i++) {
//                hdd = this.hdds.get(i);
//                if (ordinateur1.getHdd().getId() == hdd.getId()) {
//                    this.hdds.remove(hdd);
//                }
//            }
//        }
        Object[] objects = this.processeurs.toArray();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(objects);
        this.jComboBoxProcesseur.setModel(dcbm);

        objects = this.memoires.toArray();
        DefaultComboBoxModel dcbm1 = new DefaultComboBoxModel(objects);
        this.jComboBoxMemoire.setModel(dcbm1);

        objects = this.hdds.toArray();
        DefaultComboBoxModel dcbm2 = new DefaultComboBoxModel(objects);
        this.jComboBoxDisqueDur.setModel(dcbm2);

        this.jComboBoxProcesseur.setSelectedItem(ordinateur.getProcesseur());
        this.jComboBoxMemoire.setSelectedItem(ordinateur.getMemoire());
        this.jComboBoxDisqueDur.setSelectedItem(ordinateur.getHdd());

        this.repaint();
        this.pack();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxMemoire = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxProcesseur = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxDisqueDur = new javax.swing.JComboBox<>();
        jButtonValider = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabelTitre.setText("jLabel4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        jPanel1.add(jLabelTitre, gridBagConstraints);

        jLabel1.setText("Processeur");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jComboBoxMemoire, gridBagConstraints);

        jLabel2.setText("Memoire");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jComboBoxProcesseur, gridBagConstraints);

        jLabel3.setText("Disque dur");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jComboBoxDisqueDur, gridBagConstraints);

        jButtonValider.setText("Ajouter");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        jPanel1.add(jButtonValider, gridBagConstraints);

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        jPanel1.add(jButtonAnnuler, gridBagConstraints);

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        this.ordinateur = null;
        this.dispose();
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        this.ordinateur = new Ordinateur();

        String processeurSelected = this.jComboBoxProcesseur.getSelectedItem().toString();

        String processeurId = processeurSelected.replaceAll("[^0-9]", "");

        Processeur processeur = null;

        try {
            processeur = MetierFactory.getProcesseurService().getById(Long.parseLong(processeurId));
        } catch (Exception ex) {
            Logger.getLogger(AddOrdinateurDlg.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.ordinateur.setProcesseur(processeur);

        String memoireSelected = this.jComboBoxMemoire.getSelectedItem().toString();

        String memoireId = memoireSelected.replaceAll("[^0-9]", "");

        Memoire memoire = null;

        try {
            memoire = MetierFactory.getMemoireService().getById(Long.parseLong(memoireId));
        } catch (Exception ex) {
            Logger.getLogger(AddOrdinateurDlg.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.ordinateur.setMemoire(memoire);

        String hddSelected = this.jComboBoxDisqueDur.getSelectedItem().toString();

        String hddId = hddSelected.replaceAll("[^0-9]", "");

        HDD hdd = null;

        try {
            hdd = MetierFactory.getHDDService().getById(Long.parseLong(hddId));
        } catch (Exception ex) {
            Logger.getLogger(AddOrdinateurDlg.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.ordinateur.setHdd(hdd);
        this.ordinateur.setId(id);
        this.dispose();
    }//GEN-LAST:event_jButtonValiderActionPerformed

    public Ordinateur getOrdinateur() {
        return ordinateur;
    }

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
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LoginIhm.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    AddOrdinateurDlg dialog = new AddOrdinateurDlg(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(AddOrdinateurDlg.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JComboBox<String> jComboBoxDisqueDur;
    private javax.swing.JComboBox<String> jComboBoxMemoire;
    private javax.swing.JComboBox<String> jComboBoxProcesseur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
