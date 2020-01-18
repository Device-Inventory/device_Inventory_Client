/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.client;

import fr.freeboxos.ftb.client.dlg.AddHDDDlg;
import fr.freeboxos.ftb.client.model.HDDTableModel;
import fr.freeboxos.ftb.metier.HDDService;
import fr.freeboxos.ftb.metier.MetierFactory;
import fr.freeboxos.ftb.metier.entitys.HDD;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author alan
 */
public class HDDIhm extends javax.swing.JDialog {

    private final HDDService hDDService;
    private final HDDTableModel model;

    /**
     * Creates new form HDDIhm
     *
     * @param parent
     * @param modal
     * @throws java.lang.Exception
     */
    public HDDIhm(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
//        this.setSize(1920, 1080);
        this.hDDService = MetierFactory.getHDDService();
        this.model = new HDDTableModel(this.hDDService.sort());
        this.jTable1.setModel(model);
        Image icone = Toolkit.getDefaultToolkit().getImage("./icone.png");
        this.setIconImage(icone);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
        getContentPane().setLayout(layout);

        jLabel1.setText("Liste des disque dur");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 359;
        gridBagConstraints.ipady = 186;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jButton1, gridBagConstraints);

        jButton2.setText("Modifier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jButton2, gridBagConstraints);

        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jButton3, gridBagConstraints);

        jButton4.setText("Quitter");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        getContentPane().add(jButton4, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Bouton quitter
     *
     * @param evt
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            MainIhm ihm = new MainIhm();
            ihm.setVisible(true);
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(HDDIhm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * Bouton supprimer
     *
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if (this.jTable1.getSelectedRow() == -1) {
                throw new Exception("Veuillez selectionner un disque dur");
            }

            HDD hdd = this.model.getHddAt(this.jTable1.getSelectedRow());

            try {
                this.hDDService.remove(hdd);
                this.model.update(this.hDDService.sort());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Bouton ajouter
     *
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

        AddHDDDlg addHDDDlg;
        addHDDDlg = new AddHDDDlg(frame, true);
        addHDDDlg.setVisible(true);

        HDD hdd = addHDDDlg.getHdd();
        if (hdd != null) {
            try {
                this.hDDService.add(hdd);
                this.model.update(this.hDDService.sort());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erreur pendant l'ajout du disque dur", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Bouton modifier
     *
     * @param evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (this.jTable1.getSelectedRow() == -1) {
                throw new Exception("Veuillez selectionner un disque dur");
            }

            HDD hdd = this.model.getHddAt(this.jTable1.getSelectedRow());
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            AddHDDDlg addHDDDlg;
            addHDDDlg = new AddHDDDlg(frame, true, hdd);
            addHDDDlg.setVisible(true);

            hdd = addHDDDlg.getHdd();

            if (hdd != null) {
                try {
                    this.hDDService.update(hdd);
                    this.model.update(this.hDDService.sort());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erreur pendant le mise a jour du disque dur", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);

            Logger.getLogger(HDDIhm.class.getName()).log(Level.SEVERE, null, e);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            MainIhm ihm = new MainIhm();
            ihm.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(HDDIhm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("Convert2Lambda")
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HDDIhm.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    HDDIhm dialog;

                    dialog = new HDDIhm(new javax.swing.JFrame(), true);

                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(HDDIhm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
