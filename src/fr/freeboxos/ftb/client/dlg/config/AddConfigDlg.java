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
import fr.freeboxos.ftb.metier.config.ConfigChipsetCpuService;
import fr.freeboxos.ftb.metier.config.ConfigFormatCarteMereService;
import fr.freeboxos.ftb.metier.config.ConfigMarqueCarteMereService;
import fr.freeboxos.ftb.metier.config.ConfigMarqueChipsetGpuService;
import fr.freeboxos.ftb.metier.config.ConfigMarqueCpuService;
import fr.freeboxos.ftb.metier.config.ConfigMarqueGpuService;
import fr.freeboxos.ftb.metier.config.ConfigMarqueHddService;
import fr.freeboxos.ftb.metier.config.ConfigMarqueRamService;
import fr.freeboxos.ftb.metier.config.ConfigSupportDuProcesseurService;
import fr.freeboxos.ftb.metier.config.ConfigTypeCableService;
import fr.freeboxos.ftb.metier.config.ConfigTypeMemoireService;
import fr.freeboxos.ftb.metier.config.ConfigTypeSsdService;
import fr.freeboxos.ftb.metier.entitys.config.ConfigChipsetCpu;
import fr.freeboxos.ftb.metier.entitys.config.ConfigFormatCarteMere;
import fr.freeboxos.ftb.metier.entitys.config.ConfigMarqueCarteMere;
import fr.freeboxos.ftb.metier.entitys.config.ConfigMarqueChipsetGpu;
import fr.freeboxos.ftb.metier.entitys.config.ConfigMarqueCpu;
import fr.freeboxos.ftb.metier.entitys.config.ConfigMarqueGpu;
import fr.freeboxos.ftb.metier.entitys.config.ConfigMarqueHdd;
import fr.freeboxos.ftb.metier.entitys.config.ConfigMarqueRam;
import fr.freeboxos.ftb.metier.entitys.config.ConfigSupportDuProcesseur;
import fr.freeboxos.ftb.metier.entitys.config.ConfigTypeCable;
import fr.freeboxos.ftb.metier.entitys.config.ConfigTypeMemoire;
import fr.freeboxos.ftb.metier.entitys.config.ConfigTypeSsd;
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
public class AddConfigDlg extends javax.swing.JDialog {

    private ConfigChipsetCpu configFormatcarteMere;
    private ConfigFormatCarteMere configFormatCarteMere;
    private ConfigMarqueCarteMere configMarqueCarteMere;
    private ConfigMarqueChipsetGpu configMarqueChipsetGpu;
    private ConfigMarqueCpu configMarqueCpu;
    private ConfigMarqueGpu configMarqueGpu;
    private ConfigMarqueHdd configMarqueHdd;
    private ConfigMarqueRam configMarqueRam;
    private ConfigSupportDuProcesseur configSupportDuProcesseur;
    private ConfigTypeCable configTypeCable;
    private ConfigTypeMemoire configTypeMemoire;
    private ConfigTypeSsd configTypeSsd;
    private final ConfigChipsetCpuService configChipsetCpuService;
    private final ConfigFormatCarteMereService configFormatCarteMereService;
    private final ConfigMarqueCarteMereService configMarqueCarteMereService;
    private final ConfigMarqueChipsetGpuService configMarqueChipsetGpuService;
    private final ConfigMarqueCpuService configMarqueCpuService;
    private final ConfigMarqueGpuService configMarqueGpuService;
    private final ConfigMarqueHddService configMarqueHddService;
    private final ConfigMarqueRamService configMarqueRamService;
    private final ConfigSupportDuProcesseurService configSupportDuProcesseurService;
    private final ConfigTypeCableService configTypeCableService;
    private final ConfigTypeMemoireService configTypeMemoireService;
    private final ConfigTypeSsdService configTypeSsdService;
    private String paramAll;

    /**
     * Creates new form AddConfigMarqueCpuDlg
     *
     * @param parent
     * @param modal
     */
    public AddConfigDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.configChipsetCpuService = MetierFactory.getConfigChipsetCpuService();
        this.configFormatCarteMereService = MetierFactory.getConfigFormatCarteMereService();
        this.configMarqueCarteMereService = MetierFactory.getConfigMarqueCarteMereService();
        this.configMarqueChipsetGpuService = MetierFactory.getConfigMarqueChipsetGpuService();
        this.configMarqueCpuService = MetierFactory.getConfigMarqueCpuService();
        this.configMarqueGpuService = MetierFactory.getConfigMarqueGpuService();
        this.configMarqueHddService = MetierFactory.getConfigMarqueHddService();
        this.configMarqueRamService = MetierFactory.getConfigMarqueRamService();
        this.configSupportDuProcesseurService = MetierFactory.getConfigSupportDuProcesseurService();
        this.configTypeCableService = MetierFactory.getConfigTypeCableService();
        this.configTypeMemoireService = MetierFactory.getConfigTypeMemoireService();
        this.configTypeSsdService = MetierFactory.getConfigTypeSsdService();
        this.getRootPane().setDefaultButton(jButtonAdd);
        this.repaint();
        this.pack();
    }

    public AddConfigDlg(JFrame frame, boolean b, String paramAll) {
        super(frame, b);
        initComponents();
        this.setLocationRelativeTo(null);
        this.configChipsetCpuService = MetierFactory.getConfigChipsetCpuService();
        this.configFormatCarteMereService = MetierFactory.getConfigFormatCarteMereService();
        this.configMarqueCarteMereService = MetierFactory.getConfigMarqueCarteMereService();
        this.configMarqueChipsetGpuService = MetierFactory.getConfigMarqueChipsetGpuService();
        this.configMarqueCpuService = MetierFactory.getConfigMarqueCpuService();
        this.configMarqueGpuService = MetierFactory.getConfigMarqueGpuService();
        this.configMarqueHddService = MetierFactory.getConfigMarqueHddService();
        this.configMarqueRamService = MetierFactory.getConfigMarqueRamService();
        this.configSupportDuProcesseurService = MetierFactory.getConfigSupportDuProcesseurService();
        this.configTypeCableService = MetierFactory.getConfigTypeCableService();
        this.configTypeMemoireService = MetierFactory.getConfigTypeMemoireService();
        this.configTypeSsdService = MetierFactory.getConfigTypeSsdService();
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
        switch (paramAll) {
            case "Marque cpu":
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
                    this.configMarqueCpu = null;
                    this.dispose();
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(this, "Veuillez entre une autre marque", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(AddConfigDlg.class.getName()).log(Level.SEVERE, null, e);
                }
                break;

            case "Chipset cpu":
                try {
                    String chipset = this.jTextFieldMarqueProcesseur.getText();

                    List<ConfigChipsetCpu> configChipsetCpus = this.configChipsetCpuService.getAll();

                    if (chipset.isEmpty()) {
                        throw new Exception("Veuillez remplir un chipset");
                    }

                    for (int i = 0; i < configChipsetCpus.size(); i++) {
                        if (chipset.equals(configChipsetCpus.get(i).toString())) {
                            throw new Exception("Veuillez entrer un autre chipset");
                        }
                    }

                    this.configFormatcarteMere = new ConfigChipsetCpu(chipset);
                    configChipsetCpuService.add(configFormatcarteMere);
                    this.configFormatcarteMere = null;
                    this.dispose();
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(this, "Veuillez entre un autre chipset", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(AddConfigDlg.class.getName()).log(Level.SEVERE, null, e);
                }
                break;

            case "Format carte mere":
                try {
                    String format = this.jTextFieldMarqueProcesseur.getText();

                    List<ConfigFormatCarteMere> configFormatCarteMeres = this.configFormatCarteMereService.getAll();

                    if (format.isEmpty()) {
                        throw new Exception("Veuillez remplir un format de carte mère");
                    }

                    for (int i = 0; i < configFormatCarteMeres.size(); i++) {
                        if (format.equals(configFormatCarteMeres.get(i).toString())) {
                            throw new Exception("Veuillez entrer un autre format de carte mère");
                        }
                    }

                    this.configFormatCarteMere = new ConfigFormatCarteMere(format);
                    configFormatCarteMereService.add(configFormatCarteMere);
                    this.configFormatCarteMere = null;
                    this.dispose();
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(this, "Veuillez entre un autre format de carte mère", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(AddConfigDlg.class.getName()).log(Level.SEVERE, null, e);
                }
                break;

            case "Marque carte mere":
                try {
                    String marque = this.jTextFieldMarqueProcesseur.getText();

                    List<ConfigMarqueCarteMere> configMarqueCarteMeres = this.configMarqueCarteMereService.getAll();

                    if (marque.isEmpty()) {
                        throw new Exception("Veuillez remplir une marque");
                    }

                    for (int i = 0; i < configMarqueCarteMeres.size(); i++) {
                        if (marque.equals(configMarqueCarteMeres.get(i).toString())) {
                            throw new Exception("Veuillez entrer une autre marque");
                        }
                    }

                    this.configMarqueCarteMere = new ConfigMarqueCarteMere(marque);
                    configMarqueCarteMereService.add(configMarqueCarteMere);
                    this.configMarqueCarteMere = null;
                    this.dispose();
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(this, "Veuillez entre une autre marque", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(AddConfigDlg.class.getName()).log(Level.SEVERE, null, e);
                }
                break;

            case "Marque chipset gpu":
                try {
                    String marque = this.jTextFieldMarqueProcesseur.getText();

                    List<ConfigMarqueChipsetGpu> configMarqueChipsetGpus = this.configMarqueChipsetGpuService.getAll();

                    if (marque.isEmpty()) {
                        throw new Exception("Veuillez remplir une marque");
                    }

                    for (int i = 0; i < configMarqueChipsetGpus.size(); i++) {
                        if (marque.equals(configMarqueChipsetGpus.get(i).toString())) {
                            throw new Exception("Veuillez entrer une autre marque");
                        }
                    }

                    this.configMarqueChipsetGpu = new ConfigMarqueChipsetGpu(marque);
                    configMarqueChipsetGpuService.add(configMarqueChipsetGpu);
                    this.configMarqueChipsetGpu = null;
                    this.dispose();
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(this, "Veuillez entre une autre marque", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(AddConfigDlg.class.getName()).log(Level.SEVERE, null, e);
                }
                break;

            case "Marque gpu":
                try {
                    String marque = this.jTextFieldMarqueProcesseur.getText();

                    List<ConfigMarqueGpu> configMarqueGpus = this.configMarqueGpuService.getAll();

                    if (marque.isEmpty()) {
                        throw new Exception("Veuillez remplir une marque");
                    }

                    for (int i = 0; i < configMarqueGpus.size(); i++) {
                        if (marque.equals(configMarqueGpus.get(i).toString())) {
                            throw new Exception("Veuillez entrer une autre marque");
                        }
                    }

                    this.configMarqueGpu = new ConfigMarqueGpu(marque);
                    configMarqueGpuService.add(configMarqueGpu);
                    this.configMarqueGpu = null;
                    this.dispose();
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(this, "Veuillez entre une autre marque", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(AddConfigDlg.class.getName()).log(Level.SEVERE, null, e);
                }
                break;

            case "Marque hdd":
                try {
                    String marque = this.jTextFieldMarqueProcesseur.getText();

                    List<ConfigMarqueHdd> configMarqueHdds = this.configMarqueHddService.getAll();

                    if (marque.isEmpty()) {
                        throw new Exception("Veuillez remplir une marque");
                    }

                    for (int i = 0; i < configMarqueHdds.size(); i++) {
                        if (marque.equals(configMarqueHdds.get(i).toString())) {
                            throw new Exception("Veuillez entrer une autre marque");
                        }
                    }

                    this.configMarqueHdd = new ConfigMarqueHdd(marque);
                    configMarqueHddService.add(configMarqueHdd);
                    this.configMarqueHdd = null;
                    this.dispose();
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(this, "Veuillez entre une autre marque", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(AddConfigDlg.class.getName()).log(Level.SEVERE, null, e);
                }
                break;

            case "Marque ram":
                try {
                    String marque = this.jTextFieldMarqueProcesseur.getText();

                    List<ConfigMarqueRam> configMarqueRams = this.configMarqueRamService.getAll();

                    if (marque.isEmpty()) {
                        throw new Exception("Veuillez remplir une marque");
                    }

                    for (int i = 0; i < configMarqueRams.size(); i++) {
                        if (marque.equals(configMarqueRams.get(i).toString())) {
                            throw new Exception("Veuillez entrer une autre marque");
                        }
                    }

                    this.configMarqueRam = new ConfigMarqueRam(marque);
                    configMarqueRamService.add(configMarqueRam);
                    this.configMarqueRam = null;
                    this.dispose();
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(this, "Veuillez entre une autre marque", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(AddConfigDlg.class.getName()).log(Level.SEVERE, null, e);
                }
                break;

            case "Type cable":
                try {
                    String marque = this.jTextFieldMarqueProcesseur.getText();

                    List<ConfigTypeCable> configTypeCables = this.configTypeCableService.getAll();

                    if (marque.isEmpty()) {
                        throw new Exception("Veuillez remplir un type de cable");
                    }

                    for (int i = 0; i < configTypeCables.size(); i++) {
                        if (marque.equals(configTypeCables.get(i).toString())) {
                            throw new Exception("Veuillez entrer un autre type de cable");
                        }
                    }

                    this.configTypeCable = new ConfigTypeCable(marque);
                    configTypeCableService.add(configTypeCable);
                    this.configTypeCable = null;
                    this.dispose();
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(this, "Veuillez entre un autre type de cable", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(AddConfigDlg.class.getName()).log(Level.SEVERE, null, e);
                }
                break;

            case "Type ram":
                try {
                    String marque = this.jTextFieldMarqueProcesseur.getText();

                    List<ConfigTypeMemoire> configTypeMemoires = this.configTypeMemoireService.getAll();

                    if (marque.isEmpty()) {
                        throw new Exception("Veuillez remplir un type de memoire");
                    }

                    for (int i = 0; i < configTypeMemoires.size(); i++) {
                        if (marque.equals(configTypeMemoires.get(i).toString())) {
                            throw new Exception("Veuillez entrer un autre type de memoire");
                        }
                    }

                    this.configTypeMemoire = new ConfigTypeMemoire(marque);
                    configTypeMemoireService.add(configTypeMemoire);
                    this.configTypeMemoire = null;
                    this.dispose();
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(this, "Veuillez entre un autre type de memoire", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(AddConfigDlg.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "Type ssd":
                try {
                    String marque = this.jTextFieldMarqueProcesseur.getText();

                    List<ConfigTypeSsd> configTypeSsds = this.configTypeSsdService.getAll();

                    if (marque.isEmpty()) {
                        throw new Exception("Veuillez remplir un type de ssd");
                    }

                    for (int i = 0; i < configTypeSsds.size(); i++) {
                        if (marque.equals(configTypeSsds.get(i).toString())) {
                            throw new Exception("Veuillez entrer un autre type de ssd");
                        }
                    }

                    this.configTypeSsd = new ConfigTypeSsd(marque);
                    configTypeSsdService.add(configTypeSsd);
                    this.configTypeSsd = null;
                    this.dispose();
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(this, "Veuillez entre un autre type ssd", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(AddConfigDlg.class.getName()).log(Level.SEVERE, null, e);
                }
                break;

            case "Support du processeur":
                try {
                    String marque = this.jTextFieldMarqueProcesseur.getText();

                    List<ConfigSupportDuProcesseur> configSupportDuProcesseurs = this.configSupportDuProcesseurService.getAll();

                    if (marque.isEmpty()) {
                        throw new Exception("Veuillez remplir un type de memoire");
                    }

                    for (int i = 0; i < configSupportDuProcesseurs.size(); i++) {
                        if (marque.equals(configSupportDuProcesseurs.get(i).toString())) {
                            throw new Exception("Veuillez entrer un autre type de memoire");
                        }
                    }

                    this.configSupportDuProcesseur = new ConfigSupportDuProcesseur(marque);
                    configSupportDuProcesseurService.add(configSupportDuProcesseur);
                    this.configSupportDuProcesseur = null;
                    this.dispose();
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(this, "Veuillez entre une autre marque", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(AddConfigDlg.class.getName()).log(Level.SEVERE, null, e);
                }
                break;

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
            java.util.logging.Logger.getLogger(AddConfigDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AddConfigDlg dialog = new AddConfigDlg(new javax.swing.JFrame(), true);
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

            case "Chipset cpu":
                this.jLabelTitre.setText("Ajout d'un chipset de processeur");
                break;
            case "Format carte mere":
                this.jLabelTitre.setText("Ajout d'un format de carte mère");
                break;

            case "Marque carte mere":
                this.jLabelTitre.setText("Ajout d'une marque de carte mère");
                break;

            case "Marque chipset gpu":
                this.jLabelTitre.setText("Ajout d'une marque de chipset gpu");
                break;

            case "Marque gpu":
                this.jLabelTitre.setText("Ajout d'une marque d'une carte graphique");
                break;

            case "Marque hdd":
                this.jLabelTitre.setText("Ajout d'une marque de disque dur");
                break;

            case "Marque ram":
                this.jLabelTitre.setText("Ajout d'une marque de barette mémoire");
                break;

            case "Type cable":
                this.jLabelTitre.setText("Ajout d'un type de cable");
                break;

            case "Type ram":
                this.jLabelTitre.setText("Ajout d'un type de barette mémoire");
                break;

            case "Type ssd":
                this.jLabelTitre.setText("Ajout d'un type de ssd");
                break;

            case "Support du processeur":
                this.jLabelTitre.setText("Ajout d'un type de support du processeur");
                break;

        }
    }
}
