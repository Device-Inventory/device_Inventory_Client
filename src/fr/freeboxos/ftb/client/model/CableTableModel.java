/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.client.model;

import fr.freeboxos.ftb.metier.MetierFactory;
import fr.freeboxos.ftb.metier.entitys.Cable;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alan
 */
public class CableTableModel extends AbstractTableModel {

    private final String[] header = {"Type", "Prise A", "Prise B", "Nombre"};
    private Cable[] cables;

    public CableTableModel(Cable[] cables) {
        this.cables = cables;
    }

    @Override
    public String getColumnName(int column) {
        return this.header[column];
    }

    @Override
    public int getRowCount() {
        return this.cables.length;
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cable cable = this.cables[rowIndex];
        switch (columnIndex) {
            case 0:
                return cable.getType();
            case 1:
                return cable.getPrise_a();
            case 2:
                return cable.getPrise_b();
            case 3:
                return cable.getNombre();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Cable cable = this.cables[rowIndex];
            switch (columnIndex) {
                case 0:
                    cable.setType((String) aValue);
                case 1:
                    cable.setPrise_a((String) aValue);
                case 2:
                    cable.setPrise_b((String) aValue);
                case 3:
                    cable.setNombre((long) aValue);
            }
            MetierFactory.getCableService().update(cable);
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
            case 3:
                return Long.class;
            default:
                return String.class;
        }
    }

    public Cable getCableAt(int rowIndex) {
        return this.cables[rowIndex];
    }

    public void update(Cable[] cables) {
        this.cables = cables;
        this.fireTableDataChanged();
    }

}
