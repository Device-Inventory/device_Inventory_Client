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
package fr.freeboxos.ftb.client.dlg;

import com.bulenkov.darcula.DarculaLaf;
import fr.freeboxos.ftb.metier.MetierFactory;
import fr.freeboxos.ftb.metier.entitys.CarteMere;
import fr.freeboxos.ftb.metier.entitys.config.ConfigChipsetCpu;
import fr.freeboxos.ftb.metier.entitys.config.ConfigFormatCarteMere;
import fr.freeboxos.ftb.metier.entitys.config.ConfigMarqueCarteMere;
import fr.freeboxos.ftb.metier.entitys.config.ConfigSupportDuProcesseur;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author alan
 */
public class AddCarteMereDlg extends javax.swing.JDialog {

    private CarteMere carteMere;
    private long id = 0;

    /**
     * Creates new form AddCarteMereDlg
     *
     * @param parent
     * @param modal
     * @throws java.lang.Exception
     */
    public AddCarteMereDlg(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(jButtonOk);
        Image icone = Toolkit.getDefaultToolkit().getImage("./icone.png");
        this.setIconImage(icone);
        this.jLabelTitre.setText("Ajout d'une carte mère");
        this.setAllModelJSpinner();
        //todo : seter les jcombobox
        this.setAllList();
        this.repaint();
        this.pack();
        this.setSize(this.getWidth() + 10, this.getHeight());
    }

    public AddCarteMereDlg(JFrame frame, boolean b, CarteMere carteMere) throws Exception {
        super(frame, b);
        initComponents();
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(jButtonOk);
        Image icone = Toolkit.getDefaultToolkit().getImage("./icone.png");
        this.setIconImage(icone);
        this.setAllElements(carteMere);
        this.setAllModelJSpinner();
        this.setAllList();
        this.repaint();
        this.pack();
        this.setSize(this.getWidth() + 10, this.getHeight());
    }

    public CarteMere getCarteMere() {
        return carteMere;
    }

    /**
     * Cette methode va appeller tous les jspinner du jdialog et il vas setter
     * la valeur min et max.
     */
    private void setAllModelJSpinner() {
        Integer value = 0;
        Integer min = 0;
        Integer max = 99;
        Integer step = 1;
        SpinnerNumberModel model = new SpinnerNumberModel(value, min, max, step);
        this.jSpinnerNombreDeCpu.setModel(model);
        this.jSpinnerCapaciteMaximaleRamSlot.setModel(model);
        this.jSpinnerCapaciteMaximaleRamTotale.setModel(model);
//        this.jSpinnerModeRaid.setModel(model);
        this.jSpinnerNombreCanauxAudio.setModel(model);
        this.jSpinnerPci.setModel(model);
        this.jSpinnerPciE16x20.setModel(model);
        this.jSpinnerPciE16x30.setModel(model);
        this.jSpinnerPciE1x20.setModel(model);
        this.jSpinnerPciE1x30.setModel(model);
        this.jSpinnerTailleMemoireVideo.setModel(model);
    }

    /**
     * Set toutes les list du dialog
     *
     * @throws Exception
     */
    private void setAllList() throws Exception {
        DefaultListModel<String> modelMarqueCarteMere = new DefaultListModel<>();

        List<ConfigMarqueCarteMere> configMarqueCarteMeres = MetierFactory.getConfigMarqueCarteMereService().getAll();
        configMarqueCarteMeres.forEach((configMarqueCarteMere) -> {
            modelMarqueCarteMere.addElement(configMarqueCarteMere.getMarqueCarteMere());
        });
        this.jListMarque.setModel(modelMarqueCarteMere);

        DefaultListModel<String> modelSupportDuProcesseur = new DefaultListModel<>();

        List<ConfigSupportDuProcesseur> configSupportDuProcesseurs = MetierFactory.getConfigSupportDuProcesseurService().getAll();
        configSupportDuProcesseurs.forEach((configSupportDuProcesseur) -> {
            modelSupportDuProcesseur.addElement(configSupportDuProcesseur.getSupportDuProcesseur());
        });
        this.jListSupportDuProcesseur.setModel(modelSupportDuProcesseur);

        DefaultListModel<String> modelFormatCarteMere = new DefaultListModel<>();

        List<ConfigFormatCarteMere> configFormatCarteMeres = MetierFactory.getConfigFormatCarteMereService().getAll();
        configFormatCarteMeres.forEach((configFormatCarteMere) -> {
            modelFormatCarteMere.addElement(configFormatCarteMere.getFormatCarteMere());
        });
        this.jListFormatCarteMere.setModel(modelFormatCarteMere);

        DefaultListModel<String> modelChipset = new DefaultListModel<>();

        List<ConfigChipsetCpu> configChipsetCpus = MetierFactory.getConfigChipsetCpuService().getAll();
        configChipsetCpus.forEach((configChipsetCpu) -> {
            modelChipset.addElement(configChipsetCpu.getChipsetCpu());
        });
        this.jListChipset.setModel(modelChipset);

//todo : faire le set de toutes les listes.
    }

    /**
     * Appelle tous les elements pour une modification de celui-ci.
     */
    private void setAllElements(CarteMere carteMere) throws Exception {
        this.jTextFieldModele.setText(carteMere.getModele());
        this.jTextFieldDesignation.setText(carteMere.getDesignation());
        this.jSpinnerNombreDeCpu.setValue(carteMere.getNombreDeCpu());
        //todo : jcombobox format de la carte mère
        //todo : jcombobox chipset
        //todo : jcombobox type de memoire
//        this.jTextFieldFrequenceMemoire.setText(carteMere.getFrequenceMemoire());
        //todo : jcombobox technologie memoire
        this.jSpinnerCapaciteMaximaleRamSlot.setValue(carteMere.getCapaciteMaximaleRamSlot());
        this.jSpinnerCapaciteMaximaleRamTotale.setValue(carteMere.getCapaciteMaximaleRam());
        this.jCheckBoxControleurGpuIntegre.setSelected(carteMere.getControleurGraphiqueIntegre());
        this.jCheckBoxGpuDansCpu.setSelected(carteMere.getGpuInCpu());
        //todo : jcombobox chipset graphique
        this.jSpinnerTailleMemoireVideo.setValue(carteMere.getTailleMemoireVideo());
        //todo : jcombobox type de multi-gpu
        //todo : jcombobox connecteur graphique
        this.jCheckBoxPci.setSelected(carteMere.getPci());
        this.jSpinnerPci.setValue(carteMere.getPciNum());
        this.jCheckBoxPciE1x20.setSelected(carteMere.getPciExpress1x20());
        this.jSpinnerPciE1x20.setValue(carteMere.getPciExpress1x20Num());
        this.jCheckBoxPciE16x20.setSelected(carteMere.getPciExpress16x20());
        this.jSpinnerPciE16x20.setValue(carteMere.getPciExpress16x20Num());
        this.jCheckBoxPciE1x30.setSelected(carteMere.getPciExpress1x30());
        this.jSpinnerPciE1x30.setValue(carteMere.getPciExpress1x30Num());
        this.jCheckBoxPciE16x30.setSelected(carteMere.getPciExpress16x30());
        this.jSpinnerPciE16x30.setValue(carteMere.getPciExpress16x30Num());
        //todo : jcombobox chipset audio
        this.jSpinnerNombreCanauxAudio.setValue(carteMere.getNombreCanauxAudio());
        this.jTextFieldControleurEthernet.setText(carteMere.getControleurEthernet());
        //todo : jcombobox norme réseaux
        this.jCheckBoxRaid.setSelected(carteMere.getRaid());
        //todo : jcombobox mode raid
        this.jCheckBoxLed.setSelected(carteMere.getLed());
        this.jSpinnerPrix.setValue(carteMere.getPrix());
        this.id = carteMere.getId();
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
        jLabelMarque = new javax.swing.JLabel();
        jLabelModele = new javax.swing.JLabel();
        jTextFieldModele = new javax.swing.JTextField();
        jLabelDesignation = new javax.swing.JLabel();
        jTextFieldDesignation = new javax.swing.JTextField();
        jLabelSupportDuProcesseur = new javax.swing.JLabel();
        jLabelNombreDeCpu = new javax.swing.JLabel();
        jSpinnerNombreDeCpu = new javax.swing.JSpinner();
        jLabelFormatCarteMere = new javax.swing.JLabel();
        jLabelChipset = new javax.swing.JLabel();
        jLabelFrequenceMemoire = new javax.swing.JLabel();
        jLabelTechnologieMemoire = new javax.swing.JLabel();
        jLabelCapaciteMaximaleRamSlot = new javax.swing.JLabel();
        jSpinnerCapaciteMaximaleRamSlot = new javax.swing.JSpinner();
        jLabelCapaciteMaximaleRamTotale = new javax.swing.JLabel();
        jSpinnerCapaciteMaximaleRamTotale = new javax.swing.JSpinner();
        jLabelTypeDeMemoire = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jCheckBoxControleurGpuIntegre = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jCheckBoxGpuDansCpu = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSpinnerTailleMemoireVideo = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jCheckBoxPci = new javax.swing.JCheckBox();
        jSpinnerPci = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jCheckBoxPciE1x20 = new javax.swing.JCheckBox();
        jSpinnerPciE1x20 = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        jCheckBoxPciE16x20 = new javax.swing.JCheckBox();
        jSpinnerPciE16x20 = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        jCheckBoxPciE1x30 = new javax.swing.JCheckBox();
        jSpinnerPciE1x30 = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        jCheckBoxPciE16x30 = new javax.swing.JCheckBox();
        jSpinnerPciE16x30 = new javax.swing.JSpinner();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSpinnerNombreCanauxAudio = new javax.swing.JSpinner();
        jLabel25 = new javax.swing.JLabel();
        jTextFieldControleurEthernet = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jCheckBoxRaid = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jCheckBoxLed = new javax.swing.JCheckBox();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListMarque = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListFormatCarteMere = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListChipset = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListTypeRam = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListTechnoMemoire = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListChipsetGpu = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        jListChipsetAudio = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        jListNormeRéseau = new javax.swing.JList<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        jListTypeMultiGpu = new javax.swing.JList<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        jListConnecteurGpu = new javax.swing.JList<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        jListSupportDuProcesseur = new javax.swing.JList<>();
        jScrollPane13 = new javax.swing.JScrollPane();
        jListFrequenceMemoire = new javax.swing.JList<>();
        jScrollPane14 = new javax.swing.JScrollPane();
        jListConnecteurHdd = new javax.swing.JList<>();
        jScrollPane15 = new javax.swing.JScrollPane();
        jListModeRaid = new javax.swing.JList<>();
        jSpinnerPrix = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jButtonAnnuler = new javax.swing.JButton();
        jButtonOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel1Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel1.setLayout(jPanel1Layout);

        jLabelTitre.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        jPanel1.add(jLabelTitre, gridBagConstraints);

        jLabelMarque.setText("Marque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabelMarque, gridBagConstraints);

        jLabelModele.setText("Modèle");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabelModele, gridBagConstraints);

        jTextFieldModele.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldModeleKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jTextFieldModele, gridBagConstraints);

        jLabelDesignation.setText("Désignation");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabelDesignation, gridBagConstraints);

        jTextFieldDesignation.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jTextFieldDesignation, gridBagConstraints);

        jLabelSupportDuProcesseur.setText("Support du processeur");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabelSupportDuProcesseur, gridBagConstraints);

        jLabelNombreDeCpu.setText("Nombre de cpu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabelNombreDeCpu, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jSpinnerNombreDeCpu, gridBagConstraints);

        jLabelFormatCarteMere.setText("Format de la carte mère");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabelFormatCarteMere, gridBagConstraints);

        jLabelChipset.setText("Chipset");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabelChipset, gridBagConstraints);

        jLabelFrequenceMemoire.setText("Fréquence mémoire");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabelFrequenceMemoire, gridBagConstraints);

        jLabelTechnologieMemoire.setText("Téchnologie mémoire");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabelTechnologieMemoire, gridBagConstraints);

        jLabelCapaciteMaximaleRamSlot.setText("Capacité maximale ram slot");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabelCapaciteMaximaleRamSlot, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jSpinnerCapaciteMaximaleRamSlot, gridBagConstraints);

        jLabelCapaciteMaximaleRamTotale.setText("Capacité maximale ram totale");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabelCapaciteMaximaleRamTotale, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jSpinnerCapaciteMaximaleRamTotale, gridBagConstraints);

        jLabelTypeDeMemoire.setText("Type de mémoire");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabelTypeDeMemoire, gridBagConstraints);

        jLabel12.setText("Controleur graphique intégrer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel12, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jCheckBoxControleurGpuIntegre, gridBagConstraints);

        jLabel13.setText("GPU dans le CPU");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel13, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jCheckBoxGpuDansCpu, gridBagConstraints);

        jLabel14.setText("Chipset graphique");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel14, gridBagConstraints);

        jLabel15.setText("Taille mémoire vidéo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 34;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel15, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 34;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jSpinnerTailleMemoireVideo, gridBagConstraints);

        jLabel16.setText("Type de multi-GPU");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 36;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel16, gridBagConstraints);

        jLabel17.setText("Connecteur graphique");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 38;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel17, gridBagConstraints);

        jLabel18.setText("Pci");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel18, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jCheckBoxPci, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 40;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel1.add(jSpinnerPci, gridBagConstraints);

        jLabel19.setText("PciExpress 1x 2.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 42;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel19, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 42;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jCheckBoxPciE1x20, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 42;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel1.add(jSpinnerPciE1x20, gridBagConstraints);

        jLabel20.setText("PciExpress 16x 2.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel20, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jCheckBoxPciE16x20, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 44;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel1.add(jSpinnerPciE16x20, gridBagConstraints);

        jLabel21.setText("PciExpress 1x 3.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 46;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel21, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 46;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jCheckBoxPciE1x30, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 46;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel1.add(jSpinnerPciE1x30, gridBagConstraints);

        jLabel22.setText("PciExpress 16x 3.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel22, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jCheckBoxPciE16x30, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 48;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel1.add(jSpinnerPciE16x30, gridBagConstraints);

        jLabel23.setText("Chipset Audio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel23, gridBagConstraints);

        jLabel24.setText("Nombre de canaux audio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 52;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel24, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 52;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jSpinnerNombreCanauxAudio, gridBagConstraints);

        jLabel25.setText("Controleur ethernet");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 54;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel25, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 54;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jTextFieldControleurEthernet, gridBagConstraints);

        jLabel26.setText("Norme réseau");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 56;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel26, gridBagConstraints);

        jLabel27.setText("Raid");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 58;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel27, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 58;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jCheckBoxRaid, gridBagConstraints);

        jLabel28.setText("Connecteur disque dur");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 60;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel28, gridBagConstraints);

        jLabel29.setText("Mode raid");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 62;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel29, gridBagConstraints);

        jLabel30.setText("Led");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 64;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel30, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 64;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jCheckBoxLed, gridBagConstraints);

        jLabel31.setText("Prix");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 66;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel31, gridBagConstraints);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(150, 60));

        jListMarque.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListMarque.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListMarqueValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jListMarque);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jScrollPane2, gridBagConstraints);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(150, 60));

        jListFormatCarteMere.setMaximumSize(new java.awt.Dimension(10, 0));
        jListFormatCarteMere.setPreferredSize(new java.awt.Dimension(39, 34));
        jScrollPane3.setViewportView(jListFormatCarteMere);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jScrollPane3, gridBagConstraints);

        jScrollPane4.setPreferredSize(new java.awt.Dimension(150, 60));

        jListChipset.setMaximumSize(new java.awt.Dimension(10, 0));
        jScrollPane4.setViewportView(jListChipset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jScrollPane4, gridBagConstraints);

        jScrollPane5.setPreferredSize(new java.awt.Dimension(150, 60));

        jListTypeRam.setMaximumSize(new java.awt.Dimension(10, 0));
        jScrollPane5.setViewportView(jListTypeRam);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jScrollPane5, gridBagConstraints);

        jScrollPane6.setPreferredSize(new java.awt.Dimension(150, 60));

        jListTechnoMemoire.setMaximumSize(new java.awt.Dimension(10, 0));
        jScrollPane6.setViewportView(jListTechnoMemoire);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jScrollPane6, gridBagConstraints);

        jScrollPane7.setPreferredSize(new java.awt.Dimension(150, 60));

        jListChipsetGpu.setMaximumSize(new java.awt.Dimension(10, 0));
        jScrollPane7.setViewportView(jListChipsetGpu);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 32;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jScrollPane7, gridBagConstraints);

        jScrollPane8.setPreferredSize(new java.awt.Dimension(150, 60));

        jListChipsetAudio.setMaximumSize(new java.awt.Dimension(10, 0));
        jScrollPane8.setViewportView(jListChipsetAudio);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 50;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jScrollPane8, gridBagConstraints);

        jScrollPane9.setPreferredSize(new java.awt.Dimension(150, 60));

        jListNormeRéseau.setMaximumSize(new java.awt.Dimension(10, 0));
        jScrollPane9.setViewportView(jListNormeRéseau);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 56;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jScrollPane9, gridBagConstraints);

        jScrollPane10.setPreferredSize(new java.awt.Dimension(150, 60));

        jListTypeMultiGpu.setMaximumSize(new java.awt.Dimension(10, 0));
        jScrollPane10.setViewportView(jListTypeMultiGpu);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 36;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jScrollPane10, gridBagConstraints);

        jScrollPane11.setPreferredSize(new java.awt.Dimension(150, 60));

        jListConnecteurGpu.setMaximumSize(new java.awt.Dimension(10, 0));
        jScrollPane11.setViewportView(jListConnecteurGpu);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 38;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jScrollPane11, gridBagConstraints);

        jScrollPane12.setPreferredSize(new java.awt.Dimension(150, 60));

        jListSupportDuProcesseur.setMaximumSize(new java.awt.Dimension(0, 10));
        jListSupportDuProcesseur.setPreferredSize(new java.awt.Dimension(0, 10));
        jScrollPane12.setViewportView(jListSupportDuProcesseur);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jScrollPane12, gridBagConstraints);

        jScrollPane13.setPreferredSize(new java.awt.Dimension(150, 60));

        jListFrequenceMemoire.setMaximumSize(new java.awt.Dimension(10, 0));
        jScrollPane13.setViewportView(jListFrequenceMemoire);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jScrollPane13, gridBagConstraints);

        jScrollPane14.setPreferredSize(new java.awt.Dimension(150, 60));

        jListConnecteurHdd.setMaximumSize(new java.awt.Dimension(10, 0));
        jScrollPane14.setViewportView(jListConnecteurHdd);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 60;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jScrollPane14, gridBagConstraints);

        jScrollPane15.setPreferredSize(new java.awt.Dimension(150, 60));

        jListModeRaid.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1", "5", "10" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListModeRaid.setMaximumSize(new java.awt.Dimension(10, 0));
        jListModeRaid.setMinimumSize(new java.awt.Dimension(0, 0));
        jScrollPane15.setViewportView(jListModeRaid);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 62;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jScrollPane15, gridBagConstraints);

        jSpinnerPrix.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 0.01f));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 66;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jSpinnerPrix, gridBagConstraints);

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAnnuler);

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonOk);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        carteMere = null;
        dispose();
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        try {
            List<String> marque = this.jListMarque.getSelectedValuesList();
            String modele = this.jTextFieldModele.getText();
            String designation = this.jTextFieldDesignation.getText();
            List<String> supportDuProcesseur = this.jListSupportDuProcesseur.getSelectedValuesList();
            int nombreDeCpu = (int) this.jSpinnerNombreDeCpu.getValue();
            List<String> formatCarteMere = this.jListFormatCarteMere.getSelectedValuesList();
            List<String> chipset = this.jListChipset.getSelectedValuesList();
            List<String> typeMemoire = this.jListTypeRam.getSelectedValuesList();
            List<String> frequenceMemoire = this.jListFrequenceMemoire.getSelectedValuesList();
            List<String> technologieMemoire = this.jListTechnoMemoire.getSelectedValuesList();
            int ramSlot = (int) this.jSpinnerCapaciteMaximaleRamSlot.getValue();
            int ramTotal = (int) this.jSpinnerCapaciteMaximaleRamTotale.getValue();
            boolean controleurGpuIntegrer = this.jCheckBoxControleurGpuIntegre.isSelected();
            boolean GpuInCpu = this.jCheckBoxGpuDansCpu.isSelected();
            List<String> chipsetGraphique = this.jListChipsetGpu.getSelectedValuesList();
            int tailleMemoireVideo = (int) this.jSpinnerTailleMemoireVideo.getValue();
            List<String> typeMultiGpu = this.jListTypeMultiGpu.getSelectedValuesList();
            List<String> connecteurGraphique = this.jListConnecteurGpu.getSelectedValuesList();
            boolean pci = this.jCheckBoxPci.isSelected();
            int pciNombre = (int) this.jSpinnerPci.getValue();
            boolean pciE1x20 = this.jCheckBoxPciE1x20.isSelected();
            int pciE1x20Nombre = (int) this.jSpinnerPciE1x20.getValue();
            boolean pciE1x30 = this.jCheckBoxPciE1x30.isSelected();
            int pciE1x30Nombre = (int) this.jSpinnerPciE1x30.getValue();
            boolean pciE16x20 = this.jCheckBoxPciE16x20.isSelected();
            int pciE16x20Nombre = (int) this.jSpinnerPciE16x20.getValue();
            boolean pciE16x30 = this.jCheckBoxPciE16x30.isSelected();
            int pciE16x30Nombre = (int) this.jSpinnerPciE16x30.getValue();
            List<String> chipsetAudio = this.jListChipsetAudio.getSelectedValuesList();
            int nombreCanaux = (int) this.jSpinnerNombreCanauxAudio.getValue();
            String controleurEthernet = this.jTextFieldControleurEthernet.getText();
            List<String> normeReseaux = this.jListNormeRéseau.getSelectedValuesList();
            boolean raid = this.jCheckBoxRaid.isSelected();
            List<String> connecteurDisqueDur = this.jListConnecteurHdd.getSelectedValuesList();
            List<String> modeRaid = this.jListModeRaid.getSelectedValuesList();
            boolean led = this.jCheckBoxLed.isSelected();
            float prix = (float) this.jSpinnerPrix.getValue();

            if (marque.isEmpty()) {
                throw new Exception("Veuillez selectionner une marque");
            }

            if (modele.isEmpty()) {
                throw new Exception("Veuillez mettre un modèle valide");
            }

            if (controleurEthernet.isEmpty()) {
                throw new Exception("Veuillez mettre un controleur Ethernet");
            }
            carteMere = new CarteMere(marque, modele, designation, supportDuProcesseur, nombreDeCpu, formatCarteMere, chipset, frequenceMemoire, technologieMemoire, ramSlot, ramTotal, typeMemoire, controleurGpuIntegrer, GpuInCpu, chipsetGraphique, tailleMemoireVideo, typeMultiGpu, connecteurGraphique, pci, pciE1x20, pciE16x20, pciE1x30, pciE16x30, pciNombre, pciE1x20Nombre, pciE16x20Nombre, pciE1x30Nombre, pciE16x30Nombre, chipsetAudio, nombreCanaux, controleurEthernet, normeReseaux, raid, connecteurDisqueDur, modeRaid, led, prix);
            this.carteMere.setId(id);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jListMarqueValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListMarqueValueChanged
        String marqueTemp = this.jListMarque.getSelectedValue();
        this.jTextFieldDesignation.setText(marqueTemp + " " + this.jTextFieldModele.getText());
    }//GEN-LAST:event_jListMarqueValueChanged

    private void jTextFieldModeleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldModeleKeyReleased
        String modeleTemp = this.jTextFieldModele.getText();
        if (this.jListMarque.getSelectedIndex() == -1) {
            this.jTextFieldDesignation.setText(modeleTemp);
        } else {
            this.jTextFieldDesignation.setText(this.jListMarque.getSelectedValue() + " " + modeleTemp);
        }
    }//GEN-LAST:event_jTextFieldModeleKeyReleased

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("Convert2Lambda")
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(new DarculaLaf());
                    break;
                }
            }
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCarteMereDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    AddCarteMereDlg dialog = new AddCarteMereDlg(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(AddCarteMereDlg.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JCheckBox jCheckBoxControleurGpuIntegre;
    private javax.swing.JCheckBox jCheckBoxGpuDansCpu;
    private javax.swing.JCheckBox jCheckBoxLed;
    private javax.swing.JCheckBox jCheckBoxPci;
    private javax.swing.JCheckBox jCheckBoxPciE16x20;
    private javax.swing.JCheckBox jCheckBoxPciE16x30;
    private javax.swing.JCheckBox jCheckBoxPciE1x20;
    private javax.swing.JCheckBox jCheckBoxPciE1x30;
    private javax.swing.JCheckBox jCheckBoxRaid;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabelCapaciteMaximaleRamSlot;
    private javax.swing.JLabel jLabelCapaciteMaximaleRamTotale;
    private javax.swing.JLabel jLabelChipset;
    private javax.swing.JLabel jLabelDesignation;
    private javax.swing.JLabel jLabelFormatCarteMere;
    private javax.swing.JLabel jLabelFrequenceMemoire;
    private javax.swing.JLabel jLabelMarque;
    private javax.swing.JLabel jLabelModele;
    private javax.swing.JLabel jLabelNombreDeCpu;
    private javax.swing.JLabel jLabelSupportDuProcesseur;
    private javax.swing.JLabel jLabelTechnologieMemoire;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JLabel jLabelTypeDeMemoire;
    private javax.swing.JList<String> jListChipset;
    private javax.swing.JList<String> jListChipsetAudio;
    private javax.swing.JList<String> jListChipsetGpu;
    private javax.swing.JList<String> jListConnecteurGpu;
    private javax.swing.JList<String> jListConnecteurHdd;
    private javax.swing.JList<String> jListFormatCarteMere;
    private javax.swing.JList<String> jListFrequenceMemoire;
    private javax.swing.JList<String> jListMarque;
    private javax.swing.JList<String> jListModeRaid;
    private javax.swing.JList<String> jListNormeRéseau;
    private javax.swing.JList<String> jListSupportDuProcesseur;
    private javax.swing.JList<String> jListTechnoMemoire;
    private javax.swing.JList<String> jListTypeMultiGpu;
    private javax.swing.JList<String> jListTypeRam;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSpinner jSpinnerCapaciteMaximaleRamSlot;
    private javax.swing.JSpinner jSpinnerCapaciteMaximaleRamTotale;
    private javax.swing.JSpinner jSpinnerNombreCanauxAudio;
    private javax.swing.JSpinner jSpinnerNombreDeCpu;
    private javax.swing.JSpinner jSpinnerPci;
    private javax.swing.JSpinner jSpinnerPciE16x20;
    private javax.swing.JSpinner jSpinnerPciE16x30;
    private javax.swing.JSpinner jSpinnerPciE1x20;
    private javax.swing.JSpinner jSpinnerPciE1x30;
    private javax.swing.JSpinner jSpinnerPrix;
    private javax.swing.JSpinner jSpinnerTailleMemoireVideo;
    private javax.swing.JTextField jTextFieldControleurEthernet;
    private javax.swing.JTextField jTextFieldDesignation;
    private javax.swing.JTextField jTextFieldModele;
    // End of variables declaration//GEN-END:variables
}
