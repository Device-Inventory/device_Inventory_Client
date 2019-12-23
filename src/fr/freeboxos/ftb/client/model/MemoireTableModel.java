/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.client.model;

import fr.freeboxos.ftb.metier.MetierFactory;
import fr.freeboxos.ftb.metier.entitys.Memoire;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alan
 */
public class MemoireTableModel extends AbstractTableModel {

    private final String[] header = {"Marque", "Modèle", "Type", "Format", "Capacité", "Fréquence mémoire", "ECC", "Radiateur", "Tension", "Prix"};
    private Memoire[] memoires;

    public MemoireTableModel(Memoire[] memoires) {
        this.memoires = memoires;
    }

    @Override
    public String getColumnName(int column) {
        return this.header[column];
    }

    @Override
    public int getRowCount() {
        return this.memoires.length;
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Memoire memoire = this.memoires[rowIndex];
        switch (columnIndex) {
            case 0:
                return memoire.getMarque();
            case 1:
                return memoire.getModele();
            case 2:
                return memoire.getType();
            case 3:
                return memoire.getFormat();
            case 4:
                return memoire.getCapacite();
            case 5:
                return memoire.getFrequence_memoire();
            case 6:
                return memoire.getECC();
            case 7:
                return memoire.getRadiateur();
            case 8:
                return memoire.getTension();
            case 9:
                return memoire.getPrix();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Memoire memoire = this.memoires[rowIndex];
            switch (columnIndex) {
                case 0:
                    memoire.setMarque((String) aValue);
                case 1:
                    memoire.setModele((String) aValue);
                case 2:
                    memoire.setType((String) aValue);
                case 3:
                    memoire.setFormat((String) aValue);
                case 4:
                    memoire.setCapacite((String) aValue);
                case 5:
                    memoire.setFrequence_memoire((String) aValue);
                case 6:
                    memoire.setECC((String) aValue);
                case 7:
                    memoire.setRadiateur((String) aValue);
                case 8:
                    memoire.setTension((String) aValue);
                case 9:
                    memoire.setPrix((String) aValue);
            }
            MetierFactory.getMemoireService().update(memoire);
            this.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            default:
                return false;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        switch (columnIndex) {
            default:
                return String.class;
        }
    }

    public Memoire getMemoireAt(int rowIndex) {
        return this.memoires[rowIndex];
    }

    public void update(Memoire[] memoires) {
        this.memoires = memoires;
        this.fireTableDataChanged();
    }
}
