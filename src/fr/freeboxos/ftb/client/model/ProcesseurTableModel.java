/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.client.model;

import fr.freeboxos.ftb.metier.MetierFactory;
import fr.freeboxos.ftb.metier.entitys.Processeur;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alan
 */
public class ProcesseurTableModel extends AbstractTableModel {

    private final String[] header = {"Marque", "Modele", "Socket", "Frequence normal", "Fréquence turbo", "Nombre de core", "Nombre de thread", "Nom de la plateforme", "Finesse de gravure", "TDP", "Cache L1", "L2", "L3", "Prix"};
    private Processeur[] processeurs;

    public ProcesseurTableModel(Processeur[] processeurs) {
        this.processeurs = processeurs;
    }

    @Override
    public String getColumnName(int column) {
        return this.header[column];
    }

    @Override
    public int getRowCount() {
        return this.processeurs.length;
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Processeur processeur = this.processeurs[rowIndex];
        switch (columnIndex) {
            case 0:
                return processeur.getMarque();
            case 1:
                return processeur.getModele();
            case 2:
                return processeur.getSocket();
            case 3:
                return processeur.getFrequence();
            case 4:
                return processeur.getTurbo();
            case 5:
                return processeur.getCore();
            case 6:
                return processeur.getThread();
            case 7:
                return processeur.getPlateforme_nom();
            case 8:
                return processeur.getFinesse_gravure();
            case 9:
                return processeur.getTDP();
            case 10:
                return processeur.getL1();
            case 11:
                return processeur.getL2();
            case 12:
                return processeur.getL3();
            case 13:
                return processeur.getPrix();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Processeur processeur = this.processeurs[rowIndex];
            switch (columnIndex) {
                case 0:
                    processeur.setMarque((String) aValue);
                case 1:
                    processeur.setModele((String) aValue);
                case 2:
                    processeur.setSocket((String) aValue);
                case 3:
                    processeur.setFrequence((String) aValue);
                case 4:
                    processeur.setTurbo((String) aValue);
                case 5:
                    processeur.setCore((int) aValue);
                case 6:
                    processeur.setThread((int) aValue);
                case 7:
                    processeur.setPlateforme_nom((String) aValue);
                case 8:
                    processeur.setFinesse_gravure((String) aValue);
                case 9:
                    processeur.setTDP((String) aValue);
                case 10:
                    processeur.setL1((String) aValue);
                case 11:
                    processeur.setL2((String) aValue);
                case 12:
                    processeur.setL3((String) aValue);
                case 13:
                    processeur.setPrix((String) aValue);
            }
            MetierFactory.getProcesseurService().update(processeur);
            this.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return false;
            default:
                return true;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 5:
            case 6:
                return Integer.class;
            default:
                return String.class;
        }
    }

    public Processeur getProcesseurAt(int rowIndex) {
        return this.processeurs[rowIndex];
    }

    public void update(Processeur[] processeurs) {
        this.processeurs = processeurs;
        this.fireTableDataChanged();
    }
}
