/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.client.ihm;

import fr.freeboxos.ftb.client.ihm.config.ConfigList;
import fr.freeboxos.ftb.metier.MetierFactory;
import fr.freeboxos.ftb.metier.entitys.Autre;
import fr.freeboxos.ftb.metier.entitys.Cable;
import fr.freeboxos.ftb.metier.entitys.CarteGraphique;
import fr.freeboxos.ftb.metier.entitys.HDD;
import fr.freeboxos.ftb.metier.entitys.Memoire;
import fr.freeboxos.ftb.metier.entitys.Processeur;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author alan
 */
public class MainIhm extends javax.swing.JFrame {

    /**
     * Creates new form MainIhm
     *
     * @throws java.lang.Exception
     */
    public MainIhm() throws Exception {
        super("Inventaire informatique");
        initComponents();
        this.setLocationRelativeTo(null);
        this.getNombreAll();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel_cpu = new javax.swing.JLabel();
        jLabel_ram = new javax.swing.JLabel();
        jLabel_hdd = new javax.swing.JLabel();
        jLabel_cable = new javax.swing.JLabel();
        jLabel_autre = new javax.swing.JLabel();
        jLabel_prixTotal = new javax.swing.JLabel();
        jButton_Quitter = new javax.swing.JButton();
        jButtonUtilisateur = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabelOrdinateur = new javax.swing.JLabel();
        jLabelGpu = new javax.swing.JLabel();
        jButtonGpu = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        getContentPane().setLayout(layout);

        jLabel1.setText("Inventaire");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 15;
        getContentPane().add(jLabel1, gridBagConstraints);

        jButton1.setText("Processeur");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jButton1, gridBagConstraints);

        jButton2.setText("Memoire");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jButton2, gridBagConstraints);

        jButton3.setText("Disque dur");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jButton3, gridBagConstraints);

        jButton4.setText("Cable");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jButton4, gridBagConstraints);

        jButton5.setText("Autre");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jButton5, gridBagConstraints);

        jLabel_cpu.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jLabel_cpu, gridBagConstraints);

        jLabel_ram.setText("jLabel3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jLabel_ram, gridBagConstraints);

        jLabel_hdd.setText("jLabel4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jLabel_hdd, gridBagConstraints);

        jLabel_cable.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jLabel_cable, gridBagConstraints);

        jLabel_autre.setText("jLabel6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jLabel_autre, gridBagConstraints);

        jLabel_prixTotal.setText("jLabel7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 15;
        getContentPane().add(jLabel_prixTotal, gridBagConstraints);

        jButton_Quitter.setText("Quitter");
        jButton_Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_QuitterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 15;
        getContentPane().add(jButton_Quitter, gridBagConstraints);

        jButtonUtilisateur.setText("Utilisateur");
        jButtonUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUtilisateurActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        getContentPane().add(jButtonUtilisateur, gridBagConstraints);

        jButton6.setText("Ordinateur");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        getContentPane().add(jButton6, gridBagConstraints);

        jLabelOrdinateur.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jLabelOrdinateur, gridBagConstraints);

        jLabelGpu.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jLabelGpu, gridBagConstraints);

        jButtonGpu.setText("Carte graphique");
        jButtonGpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGpuActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 2;
        getContentPane().add(jButtonGpu, gridBagConstraints);

        jButton7.setText("Carte mère");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        getContentPane().add(jButton7, gridBagConstraints);

        jLabel2.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jLabel2, gridBagConstraints);

        jMenu2.setText("File");

        jMenuItem1.setText("Quitter");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");

        jMenuItem2.setText("Marque processeur");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_QuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton_QuitterActionPerformed

    private float getPrix() throws Exception {
        float prix = 0;
        List<Processeur> processeurs = MetierFactory.getProcesseurService().getAll();
        List<Memoire> memoires = MetierFactory.getMemoireService().getAll();
        List<HDD> hdds = MetierFactory.getHDDService().getAll();
        List<CarteGraphique> carteGraphiques = MetierFactory.getCarteGraphiqueService().getAll();

        Processeur processeur;
        Memoire memoire;
        HDD hdd;
        CarteGraphique carteGraphique;

        for (int i = 0; i < processeurs.size(); i++) {
            processeur = processeurs.get(i);
            prix = prix + Float.valueOf(processeur.getPrix());
        }

        for (int i = 0; i < memoires.size(); i++) {
            memoire = memoires.get(i);
            prix = prix + Float.valueOf(memoire.getPrix());
        }

        for (int i = 0; i < hdds.size(); i++) {
            hdd = hdds.get(i);
            prix = prix + Float.valueOf(hdd.getPrix());
        }

        for (int i = 0; i < carteGraphiques.size(); i++) {
            carteGraphique = carteGraphiques.get(i);
            prix = prix + carteGraphique.getPrix();
        }
        return prix;
    }

    private int getAutres() throws Exception {
        int nombre = 0;
        List<Autre> a = MetierFactory.getAutreService().getAll();
        Autre autre;
        for (int i = 0; i < a.size(); i++) {
            autre = a.get(i);
            nombre = nombre + autre.getNombre();
        }
        return nombre;
    }

    private int getCable() throws Exception {
        int nombre = 0;
        List<Cable> cables = MetierFactory.getCableService().getAll();
        Cable cable;
        for (int i = 0; i < cables.size(); i++) {
            cable = cables.get(i);
            nombre = (int) (nombre + cable.getNombre());
        }
        return nombre;
    }

    private void getNombreAll() {
        try {
            this.jLabel_cpu.setText(String.valueOf(MetierFactory.getProcesseurService().getCount()));
        } catch (Exception ex) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erreur de lecture du nombre de processeur", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        try {
            this.jLabel_autre.setText(String.valueOf(this.getAutres()));
        } catch (Exception ex) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erreur de lecture du nombre d'autre élément", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        try {
            this.jLabel_cable.setText(String.valueOf(this.getCable()));
        } catch (Exception ex) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erreur de lecture du nombre de cable", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        try {
            this.jLabel_hdd.setText(String.valueOf(MetierFactory.getHDDService().getCount()));
        } catch (Exception ex) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erreur de lecture du nombre de disque dur", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        try {
            this.jLabel_ram.setText(String.valueOf(MetierFactory.getMemoireService().getCount()));
        } catch (Exception ex) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erreur de lecture du nombre de barrette de mémoire", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        try {
            this.jLabelOrdinateur.setText(String.valueOf(MetierFactory.getOrdinateurService().getCount()));
        } catch (Exception ex) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erreur de lecture du nombre d'ordinateur", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        try {
            this.jLabelGpu.setText(String.valueOf(MetierFactory.getCarteGraphiqueService().getCount()));
        } catch (Exception e) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erreur de lecture du nombre de carte graphique", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        try {
            this.jLabel_prixTotal.setText("Le prix totale est de " + this.getPrix() + "€");
        } catch (Exception ex) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erreur de lecture du prix", "Erreur", JOptionPane.ERROR_MESSAGE);
            this.jLabel_prixTotal.setText("Erreur");
        }

        try {
            this.jLabel2.setText(String.valueOf(MetierFactory.getCarteMereService().getCount()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur de lecture du nombre de carte mère", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            ProcesseurIhm processeurIHM = new ProcesseurIhm(this, true);
            processeurIHM.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, ex);
            //todo : corriger le catch processeur
        }
        this.getNombreAll();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonUtilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUtilisateurActionPerformed

        try {
            AdministrateurIhm administrateurIHM = new AdministrateurIhm(this, true);
            administrateurIHM.setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, e);
            //todo : corriger le catch admin
        }
        this.getNombreAll();
    }//GEN-LAST:event_jButtonUtilisateurActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            CableIhm cableIhm = new CableIhm(this, true);
            cableIhm.setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, e);
            //todo : corriger le catch cable
        }
        this.getNombreAll();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            AutreIhm autreIhm = new AutreIhm(this, true);
            autreIhm.setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, e);
            //todo : corriger le catch autre
        }
        this.getNombreAll();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            HddIhm hDDIhm = new HddIhm(this, true);
            hDDIhm.setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, e);
            //todo : corriger le catch hdd
        }
        this.getNombreAll();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            MemoireIhm memoireIhm = new MemoireIhm(this, true);
            memoireIhm.setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, e);
            //todo : corriger le catch memoire
        }
        this.getNombreAll();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            OrdinateurIhm ordinateurIhm = new OrdinateurIhm(this, true);
            ordinateurIhm.setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, e);
            //todo : corriger le catch ordinateur
        }
        this.getNombreAll();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButtonGpuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGpuActionPerformed
        try {
            CarteGraphiqueIhm carteGraphiqueIhm = new CarteGraphiqueIhm(this, true);
            carteGraphiqueIhm.setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, e);
            //todo : corriger le catch gpu
        }
        this.getNombreAll();
    }//GEN-LAST:event_jButtonGpuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            CarteMereIhm carteMereIhm = new CarteMereIhm(this, true);
            carteMereIhm.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, ex);
            //todo : corriger le catch carteMere
        }
        this.getNombreAll();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            ConfigList configList = new ConfigList(this, true, "Marque cpu");
            configList.setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("Convert2Lambda")
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MainIhm().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(MainIhm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonGpu;
    private javax.swing.JButton jButtonUtilisateur;
    private javax.swing.JButton jButton_Quitter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelGpu;
    private javax.swing.JLabel jLabelOrdinateur;
    private javax.swing.JLabel jLabel_autre;
    private javax.swing.JLabel jLabel_cable;
    private javax.swing.JLabel jLabel_cpu;
    private javax.swing.JLabel jLabel_hdd;
    private javax.swing.JLabel jLabel_prixTotal;
    private javax.swing.JLabel jLabel_ram;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
