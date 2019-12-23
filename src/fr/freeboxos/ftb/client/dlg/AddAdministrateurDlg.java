/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.client.dlg;

import fr.freeboxos.ftb.metier.entitys.Administrateur;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author alan
 */
public class AddAdministrateurDlg extends javax.swing.JDialog {

    private long id = 0;
    private Administrateur administrateur = null;

    /**
     * Creates new form AddAdministrateurDlg
     *
     * @param parent
     * @param modal
     */
    public AddAdministrateurDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(445, 190);
        this.jLabelTitre.setText("Ajout d'un utilisateur");
        this.jLabelNom.setText("Nom d'utilisateur :");
        this.jLabelPassword.setText("Mot de passe");
        this.getRootPane().setDefaultButton(jButtonOK);
    }

    public AddAdministrateurDlg(java.awt.Frame parent, boolean modal, Administrateur administrateur) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
        this.setSize(445, 176);
        this.jLabelTitre.setText("Modification d'un utilisateur");
        this.jLabelNom.setText("Nom d'utilisateur :");
        this.jLabelPassword.setText("Mot de passe");
        this.getRootPane().setDefaultButton(jButtonOK);

        this.id = administrateur.getId();
        this.jTextFieldNom.setText(administrateur.getLogin());
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
        jLabelNom = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButtonOK = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
        getContentPane().setLayout(layout);

        jLabelTitre.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(jLabelTitre, gridBagConstraints);

        jLabelNom.setText("Nom d'utilisateur");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabelNom, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 277;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jTextFieldNom, gridBagConstraints);

        jLabelPassword.setText("Mot de passe");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabelPassword, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 277;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jPasswordField1, gridBagConstraints);

        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jButtonOK, gridBagConstraints);

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        getContentPane().add(jButtonAnnuler, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        try {

            String nom = this.jTextFieldNom.getText();
            String password = new String(this.jPasswordField1.getPassword());

            if (nom.length() == 0) {
                throw new Exception("Veuillez mettre un nom d'utilisateur");
            }

            if (password.length() == 0) {
                throw new Exception("Veuillez mettre un mot de passe");
            }

            administrateur = new Administrateur();
            this.administrateur.setLogin(nom);
            this.administrateur.setMdp(password);
            this.administrateur.setId(id);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonOKActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AddAdministrateurDlg.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AddAdministrateurDlg dialog = new AddAdministrateurDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldNom;
    // End of variables declaration//GEN-END:variables

    public Administrateur getAdministrateur() {
        return this.administrateur;
    }
}
