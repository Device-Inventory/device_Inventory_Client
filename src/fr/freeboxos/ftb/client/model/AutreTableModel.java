/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.client.model;

import fr.freeboxos.ftb.metier.MetierFactory;
import fr.freeboxos.ftb.metier.entitys.Autre;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alan
 */
public class AutreTableModel extends AbstractTableModel {

    private final String[] header = {"Type", "Nombre"};
    private Autre[] autres;

    public AutreTableModel(Autre[] autres) {
        this.autres = autres;
    }

    @Override
    public String getColumnName(int column) {
        return this.header[column];
    }

    @Override
    public int getRowCount() {
        return this.autres.length;
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autre autre = this.autres[rowIndex];
        switch (columnIndex) {
            case 0:
                return autre.getElement();
            case 1:
                return autre.getNombre();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Autre autre = this.autres[rowIndex];
            switch (columnIndex) {
                case 0:
                    autre.setElement((String) aValue);
                case 1:
                    autre.setNombre((int) aValue);
            }
            MetierFactory.getAutreService().update(autre);
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
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            default:
                return String.class;
        }
    }

    public Autre getAutreAt(int rowIndex) {
        return this.autres[rowIndex];
    }

    public void update(Autre[] autres) {
        this.autres = autres;
        this.fireTableDataChanged();
    }

}
