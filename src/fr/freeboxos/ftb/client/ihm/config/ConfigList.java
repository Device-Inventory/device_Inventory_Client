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
package fr.freeboxos.ftb.client.ihm.config;

import fr.freeboxos.ftb.client.dlg.config.AddConfigDlg;
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
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author alan
 */
public class ConfigList extends javax.swing.JDialog {

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
    private List<ConfigChipsetCpu> configChipsetCpus;
    private List<ConfigFormatCarteMere> configFormatCarteMeres;
    private List<ConfigMarqueCarteMere> configMarqueCarteMeres;
    private List<ConfigMarqueChipsetGpu> configMarqueChipsetGpus;
    private List<ConfigMarqueCpu> configMarqueCpus;
    private List<ConfigMarqueGpu> configMarqueGpus;
    private List<ConfigMarqueHdd> configMarqueHdds;
    private List<ConfigMarqueRam> configMarqueRams;
    private List<ConfigSupportDuProcesseur> configSupportDuProcesseurs;
    private List<ConfigTypeCable> configTypeCables;
    private List<ConfigTypeMemoire> configTypeMemoires;
    private List<ConfigTypeSsd> configTypeSsds;
    private String paramAll;

    /**
     * Creates new form ConfigList
     *
     * @param parent
     * @param modal
     * @param param
     * @throws java.lang.Exception
     */
    public ConfigList(java.awt.Frame parent, boolean modal, String param) throws Exception {
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
        Image icone = Toolkit.getDefaultToolkit().getImage("./icone.png");
        this.setIconImage(icone);
        this.setAllElements(param);
        this.repaint();
        this.pack();
        this.paramAll = param;
    }

    public ConfigList(JFrame jFrame, boolean b) {
        super(jFrame, b);
        initComponents();
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
    }

    private void setAllElements(String param) throws Exception {

        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        switch (param) {
            case "Marque cpu":
                this.jLabel1.setText("Liste des marques de processeur");
                this.configMarqueCpus = this.configMarqueCpuService.getAll();
                configMarqueCpus.forEach((configMarqueCpu) -> {
                    defaultListModel.addElement(configMarqueCpu.getMarqueCpu());
                });

                this.jList1.setModel(defaultListModel);
                break;

            case "Chipset cpu":
                this.jLabel1.setText("Liste des chipsets cpu");
                this.configChipsetCpus = this.configChipsetCpuService.getAll();
                configChipsetCpus.forEach((configChipsetCpu) -> {
                    defaultListModel.addElement(configChipsetCpu.getChipsetCpu());
                });

                this.jList1.setModel(defaultListModel);
                break;

            case "Format carte mere":
                this.jLabel1.setText("Liste des formats de carte mère");
                this.configFormatCarteMeres = this.configFormatCarteMereService.getAll();
                configFormatCarteMeres.forEach((configFormatCarteMere) -> {
                    defaultListModel.addElement(configFormatCarteMere.getFormatCarteMere());
                });

                this.jList1.setModel(defaultListModel);
                break;

            case "Marque carte mere":
                this.jLabel1.setText("Liste des marques de carte mère");
                this.configMarqueCarteMeres = this.configMarqueCarteMereService.getAll();
                configMarqueCarteMeres.forEach((configMarqueCarteMere) -> {
                    defaultListModel.addElement(configMarqueCarteMere.getMarqueCarteMere());
                });

                this.jList1.setModel(defaultListModel);
                break;

            case "Marque chipset gpu":
                this.jLabel1.setText("Liste des marques de chipset gpu");
                this.configMarqueChipsetGpus = this.configMarqueChipsetGpuService.getAll();
                configMarqueChipsetGpus.forEach((configMarqueChipsetGpu) -> {
                    defaultListModel.addElement(configMarqueChipsetGpu.getMarqueChipsetGpu());
                });

                this.jList1.setModel(defaultListModel);
                break;

            case "Marque gpu":
                this.jLabel1.setText("Liste des marques de gpu");
                this.configMarqueGpus = this.configMarqueGpuService.getAll();
                configMarqueGpus.forEach((configMarqueGpu) -> {
                    defaultListModel.addElement(configMarqueGpu.getMarqueGpu());
                });

                this.jList1.setModel(defaultListModel);
                break;

            case "Marque hdd":
                this.jLabel1.setText("Liste des marques de disque dur");
                this.configMarqueHdds = this.configMarqueHddService.getAll();
                configMarqueHdds.forEach((configMarqueHdd) -> {
                    defaultListModel.addElement(configMarqueHdd.getMarqueHdd());
                });

                this.jList1.setModel(defaultListModel);
                break;

            case "Marque ram":
                this.jLabel1.setText("Liste des marques de barrette de mémoire");
                this.configMarqueRams = this.configMarqueRamService.getAll();
                configMarqueRams.forEach((configMarqueRam) -> {
                    defaultListModel.addElement(configMarqueRam.getMarqueRam());
                });

                this.jList1.setModel(defaultListModel);
                break;

            case "Type cable":
                this.jLabel1.setText("Liste des types de cable");
                this.configTypeCables = this.configTypeCableService.getAll();
                configTypeCables.forEach((configTypeCable) -> {
                    defaultListModel.addElement(configTypeCable.getTypeCable());
                });

                this.jList1.setModel(defaultListModel);
                break;

            case "Type ram":
                this.jLabel1.setText("Liste des types de barrette de mémoire");
                this.configTypeMemoires = this.configTypeMemoireService.getAll();
                configTypeMemoires.forEach((configTypeRam) -> {
                    defaultListModel.addElement(configTypeRam.getTypeMemoire());
                });

                this.jList1.setModel(defaultListModel);
                break;

            case "Type ssd":
                this.jLabel1.setText("Liste des types de ssd");
                this.configTypeSsds = this.configTypeSsdService.getAll();
                configTypeSsds.forEach((configTypeSsd) -> {
                    defaultListModel.addElement(configTypeSsd.getTypeSsd());
                });

                this.jList1.setModel(defaultListModel);
                break;

            case "Support du processeur":
                this.jLabel1.setText("Liste des supports du processeur");
                this.configSupportDuProcesseurs = this.configSupportDuProcesseurService.getAll();
                configSupportDuProcesseurs.forEach((configSupportDuProcesseur) -> {
                    defaultListModel.addElement(configSupportDuProcesseur.getSupportDuProcesseur());
                });

                this.jList1.setModel(defaultListModel);
                break;

        }
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
        jList1 = new javax.swing.JList<>();
        jButtonAdd = new javax.swing.JButton();
        jButtonQuit = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Test marque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(jLabel1, gridBagConstraints);

        jScrollPane1.setViewportView(jList1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jButtonAdd.setText("Ajouter");
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

        jButtonQuit.setText("Quitter");
        jButtonQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(jButtonQuit, gridBagConstraints);

        jButtonRemove.setText("Supprimer");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        getContentPane().add(jButtonRemove, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

        switch (this.paramAll) {
            case "Marque cpu":
                AddConfigDlg addConfigMarqueCpuDlg = new AddConfigDlg(frame, true, this.paramAll);
                addConfigMarqueCpuDlg.setVisible(true);
                try {
                    this.setAllElements(this.paramAll);
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jList1.repaint();
                break;

            case "Chipset cpu":
                AddConfigDlg addConfigChipsetCpuDlg = new AddConfigDlg(frame, true, this.paramAll);
                addConfigChipsetCpuDlg.setVisible(true);
                try {
                    this.setAllElements(this.paramAll);
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jList1.repaint();
                break;

            case "Format carte mere":
                AddConfigDlg addConfigFormatCarteMereDlg = new AddConfigDlg(frame, true, this.paramAll);
                addConfigFormatCarteMereDlg.setVisible(true);
                try {
                    this.setAllElements(this.paramAll);
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jList1.repaint();
                break;

            case "Marque carte mere":
                AddConfigDlg addConfigMarqueCarteMereDlg = new AddConfigDlg(frame, true, this.paramAll);
                addConfigMarqueCarteMereDlg.setVisible(true);
                try {
                    this.setAllElements(this.paramAll);
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jList1.repaint();
                break;

            case "Marque chipset gpu":
                AddConfigDlg addConfigMarqueChipsetGpuDlg = new AddConfigDlg(frame, true, this.paramAll);
                addConfigMarqueChipsetGpuDlg.setVisible(true);
                try {
                    this.setAllElements(this.paramAll);
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jList1.repaint();
                break;

            case "Marque gpu":
                AddConfigDlg addConfigMarqueGpuDlg = new AddConfigDlg(frame, true, this.paramAll);
                addConfigMarqueGpuDlg.setVisible(true);
                try {
                    this.setAllElements(this.paramAll);
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jList1.repaint();
                break;

            case "Marque hdd":
                AddConfigDlg addConfigMarqueHddDlg = new AddConfigDlg(frame, true, this.paramAll);
                addConfigMarqueHddDlg.setVisible(true);
                try {
                    this.setAllElements(this.paramAll);
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jList1.repaint();
                break;

            case "Marque ram":
                AddConfigDlg addConfigMarqueRamDlg = new AddConfigDlg(frame, true, this.paramAll);
                addConfigMarqueRamDlg.setVisible(true);
                try {
                    this.setAllElements(this.paramAll);
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jList1.repaint();
                break;

            case "Type cable":
                AddConfigDlg addConfigTypeCableDlg = new AddConfigDlg(frame, true, this.paramAll);
                addConfigTypeCableDlg.setVisible(true);
                try {
                    this.setAllElements(this.paramAll);
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jList1.repaint();
                break;

            case "Type ram":
                AddConfigDlg addConfigTypeRamDlg = new AddConfigDlg(frame, true, this.paramAll);
                addConfigTypeRamDlg.setVisible(true);
                try {
                    this.setAllElements(this.paramAll);
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jList1.repaint();
                break;

            case "Type ssd":
                AddConfigDlg addConfigTypeSsdDlg = new AddConfigDlg(frame, true, this.paramAll);
                addConfigTypeSsdDlg.setVisible(true);
                try {
                    this.setAllElements(this.paramAll);
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jList1.repaint();
                break;

            case "Support du processeur":
                AddConfigDlg addConfigSupportDuProcesseurDlg = new AddConfigDlg(frame, true, this.paramAll);
                addConfigSupportDuProcesseurDlg.setVisible(true);
                try {
                    this.setAllElements(this.paramAll);
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jList1.repaint();
                break;
        }

    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonQuitActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        switch (this.paramAll) {
            case "Marque cpu":
                try {
                    if (this.jList1.getSelectedValue() == null) {
                        throw new Exception("Veuillez selectionner un élément");
                    }

                    ConfigMarqueCpu configMarqueCpu;
                    if (this.jList1.getSelectedValuesList() != null) {
                        List<String> marqueTemp = this.jList1.getSelectedValuesList();
                        for (int i = 0; i < marqueTemp.size(); i++) {
                            configMarqueCpu = configMarqueCpuService.getByMarque(marqueTemp.get(i));
                            configMarqueCpuService.remove(configMarqueCpu);
                        }
                    } else {
                        String marqueTemp = this.jList1.getSelectedValue();
                        configMarqueCpu = configMarqueCpuService.getByMarque(marqueTemp);
                        configMarqueCpuService.remove(configMarqueCpu);
                    }
                    this.setAllElements(paramAll);
                    this.jList1.repaint();
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "Chipset cpu":
                try {
                    if (this.jList1.getSelectedValue() == null) {
                        throw new Exception("Veuillez selectionner un élément");
                    }

                    ConfigChipsetCpu configChipsetCpu;
                    if (this.jList1.getSelectedValuesList() != null) {
                        List<String> chipsetTemp = this.jList1.getSelectedValuesList();
                        for (int i = 0; i < chipsetTemp.size(); i++) {
                            configChipsetCpu = configChipsetCpuService.getByChipset(chipsetTemp.get(i));
                            configChipsetCpuService.remove(configChipsetCpu);
                        }
                    } else {
                        String chipsetTemp = this.jList1.getSelectedValue();
                        configChipsetCpu = configChipsetCpuService.getByChipset(chipsetTemp);
                        configChipsetCpuService.remove(configChipsetCpu);
                    }
                    this.setAllElements(paramAll);
                    this.jList1.repaint();
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Format carte mere":
                try {
                    if (this.jList1.getSelectedValue() == null) {
                        throw new Exception("Veuillez selectionner un élément");
                    }

                    ConfigFormatCarteMere configFormatCarteMere;
                    if (this.jList1.getSelectedValuesList() != null) {
                        List<String> formatTemp = this.jList1.getSelectedValuesList();
                        for (int i = 0; i < formatTemp.size(); i++) {
                            configFormatCarteMere = configFormatCarteMereService.getByFormatCarteMere(formatTemp.get(i));
                            configFormatCarteMereService.remove(configFormatCarteMere);
                        }
                    } else {
                        String formatTemp = this.jList1.getSelectedValue();
                        configFormatCarteMere = configFormatCarteMereService.getByFormatCarteMere(formatTemp);
                        configFormatCarteMereService.remove(configFormatCarteMere);
                    }
                    this.setAllElements(paramAll);
                    this.jList1.repaint();
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Marque carte mere":
                try {
                    if (this.jList1.getSelectedValue() == null) {
                        throw new Exception("Veuillez selectionner un élément");
                    }

                    ConfigMarqueCarteMere configMarqueCarteMere;
                    if (this.jList1.getSelectedValuesList() != null) {
                        List<String> marqueTemp = this.jList1.getSelectedValuesList();
                        for (int i = 0; i < marqueTemp.size(); i++) {
                            configMarqueCarteMere = configMarqueCarteMereService.getByMarqueCarteMere(marqueTemp.get(i));
                            configMarqueCarteMereService.remove(configMarqueCarteMere);
                        }
                    } else {
                        String marqueTemp = this.jList1.getSelectedValue();
                        configMarqueCarteMere = configMarqueCarteMereService.getByMarqueCarteMere(marqueTemp);
                        configMarqueCarteMereService.remove(configMarqueCarteMere);
                    }
                    this.setAllElements(paramAll);
                    this.jList1.repaint();
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Marque chipset gpu":
                try {
                    if (this.jList1.getSelectedValue() == null) {
                        throw new Exception("Veuillez selectionner un élément");
                    }

                    ConfigMarqueChipsetGpu configMarqueChipsetGpu;
                    if (this.jList1.getSelectedValuesList() != null) {
                        List<String> marqueTemp = this.jList1.getSelectedValuesList();
                        for (int i = 0; i < marqueTemp.size(); i++) {
                            configMarqueChipsetGpu = configMarqueChipsetGpuService.getByMarqueChipsetGpu(marqueTemp.get(i));
                            configMarqueChipsetGpuService.remove(configMarqueChipsetGpu);
                        }
                    } else {
                        String marqueTemp = this.jList1.getSelectedValue();
                        configMarqueChipsetGpu = configMarqueChipsetGpuService.getByMarqueChipsetGpu(marqueTemp);
                        configMarqueChipsetGpuService.remove(configMarqueChipsetGpu);
                    }
                    this.setAllElements(paramAll);
                    this.jList1.repaint();
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Marque gpu":
                try {
                    if (this.jList1.getSelectedValue() == null) {
                        throw new Exception("Veuillez selectionner un élément");
                    }

                    ConfigMarqueGpu configMarqueGpu;
                    if (this.jList1.getSelectedValuesList() != null) {
                        List<String> marqueTemp = this.jList1.getSelectedValuesList();
                        for (int i = 0; i < marqueTemp.size(); i++) {
                            configMarqueGpu = configMarqueGpuService.getByMarqueGpu(marqueTemp.get(i));
                            configMarqueGpuService.remove(configMarqueGpu);
                        }
                    } else {
                        String marqueTemp = this.jList1.getSelectedValue();
                        configMarqueGpu = configMarqueGpuService.getByMarqueGpu(marqueTemp);
                        configMarqueGpuService.remove(configMarqueGpu);
                    }
                    this.setAllElements(paramAll);
                    this.jList1.repaint();
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Marque hdd":
                try {
                    if (this.jList1.getSelectedValue() == null) {
                        throw new Exception("Veuillez selectionner un élément");
                    }

                    ConfigMarqueHdd configMarqueHdd;
                    if (this.jList1.getSelectedValuesList() != null) {
                        List<String> marqueTemp = this.jList1.getSelectedValuesList();
                        for (int i = 0; i < marqueTemp.size(); i++) {
                            configMarqueHdd = configMarqueHddService.getByMarqueHdd(marqueTemp.get(i));
                            configMarqueHddService.remove(configMarqueHdd);
                        }
                    } else {
                        String marqueTemp = this.jList1.getSelectedValue();
                        configMarqueHdd = configMarqueHddService.getByMarqueHdd(marqueTemp);
                        configMarqueHddService.remove(configMarqueHdd);
                    }
                    this.setAllElements(paramAll);
                    this.jList1.repaint();
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Marque ram":
                try {
                    if (this.jList1.getSelectedValue() == null) {
                        throw new Exception("Veuillez selectionner un élément");
                    }

                    ConfigMarqueRam configMarqueRam;
                    if (this.jList1.getSelectedValuesList() != null) {
                        List<String> marqueTemp = this.jList1.getSelectedValuesList();
                        for (int i = 0; i < marqueTemp.size(); i++) {
                            configMarqueRam = configMarqueRamService.getByMarqueRam(marqueTemp.get(i));
                            configMarqueRamService.remove(configMarqueRam);
                        }
                    } else {
                        String marqueTemp = this.jList1.getSelectedValue();
                        configMarqueRam = configMarqueRamService.getByMarqueRam(marqueTemp);
                        configMarqueRamService.remove(configMarqueRam);
                    }
                    this.setAllElements(paramAll);
                    this.jList1.repaint();
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Type cable":
                try {
                    if (this.jList1.getSelectedValue() == null) {
                        throw new Exception("Veuillez selectionner un élément");
                    }

                    ConfigTypeCable configTypeCable;
                    if (this.jList1.getSelectedValuesList() != null) {
                        List<String> typeTemp = this.jList1.getSelectedValuesList();
                        for (int i = 0; i < typeTemp.size(); i++) {
                            configTypeCable = configTypeCableService.getByTypeCable(typeTemp.get(i));
                            configTypeCableService.remove(configTypeCable);
                        }
                    } else {
                        String typeTemp = this.jList1.getSelectedValue();
                        configTypeCable = configTypeCableService.getByTypeCable(typeTemp);
                        configTypeCableService.remove(configTypeCable);
                    }
                    this.setAllElements(paramAll);
                    this.jList1.repaint();
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Type ram":
                try {
                    if (this.jList1.getSelectedValue() == null) {
                        throw new Exception("Veuillez selectionner un élément");
                    }

                    ConfigTypeMemoire configTypeMemoire;
                    if (this.jList1.getSelectedValuesList() != null) {
                        List<String> typeTemp = this.jList1.getSelectedValuesList();
                        for (int i = 0; i < typeTemp.size(); i++) {
                            configTypeMemoire = configTypeMemoireService.getByTypeMemoire(typeTemp.get(i));
                            configTypeMemoireService.remove(configTypeMemoire);
                        }
                    } else {
                        String typeTemp = this.jList1.getSelectedValue();
                        configTypeMemoire = configTypeMemoireService.getByTypeMemoire(typeTemp);
                        configTypeMemoireService.remove(configTypeMemoire);
                    }
                    this.setAllElements(paramAll);
                    this.jList1.repaint();
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Type ssd":
                try {
                    if (this.jList1.getSelectedValue() == null) {
                        throw new Exception("Veuillez selectionner un élément");
                    }

                    ConfigTypeSsd configTypeSsd;
                    if (this.jList1.getSelectedValuesList() != null) {
                        List<String> typeTemp = this.jList1.getSelectedValuesList();
                        for (int i = 0; i < typeTemp.size(); i++) {
                            configTypeSsd = configTypeSsdService.getByTypeSsd(typeTemp.get(i));
                            configTypeSsdService.remove(configTypeSsd);
                        }
                    } else {
                        String typeTemp = this.jList1.getSelectedValue();
                        configTypeSsd = configTypeSsdService.getByTypeSsd(typeTemp);
                        configTypeSsdService.remove(configTypeSsd);
                    }
                    this.setAllElements(paramAll);
                    this.jList1.repaint();
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Support du processeur":
                try {
                    if (this.jList1.getSelectedValue() == null) {
                        throw new Exception("Veuillez selectionner un élément");
                    }

                    ConfigSupportDuProcesseur configSupportDuProcesseur;
                    if (this.jList1.getSelectedValuesList() != null) {
                        List<String> supportTemp = this.jList1.getSelectedValuesList();
                        for (int i = 0; i < supportTemp.size(); i++) {
                            configSupportDuProcesseur = configSupportDuProcesseurService.getByConfigSupportDuProcesseur(supportTemp.get(i));
                            configSupportDuProcesseurService.remove(configSupportDuProcesseur);
                        }
                    } else {
                        String supportTemp = this.jList1.getSelectedValue();
                        configSupportDuProcesseur = configSupportDuProcesseurService.getByConfigSupportDuProcesseur(supportTemp);
                        configSupportDuProcesseurService.remove(configSupportDuProcesseur);
                    }
                    this.setAllElements(paramAll);
                    this.jList1.repaint();
                } catch (Exception ex) {
                    Logger.getLogger(ConfigList.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }

    }//GEN-LAST:event_jButtonRemoveActionPerformed

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
            java.util.logging.Logger.getLogger(ConfigList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConfigList dialog = new ConfigList(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonQuit;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
