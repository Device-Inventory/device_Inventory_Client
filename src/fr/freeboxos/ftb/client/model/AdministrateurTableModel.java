/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.freeboxos.ftb.client.model;

import fr.freeboxos.ftb.metier.MetierFactory;
import fr.freeboxos.ftb.metier.entitys.Administrateur;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alan
 */
public class AdministrateurTableModel extends AbstractTableModel {

    private final String[] header = {"Nom d'utilisateur", "Mot de passe"};
    private Administrateur[] administrateurs;

    public AdministrateurTableModel(Administrateur[] administrateurs) {
        this.administrateurs = administrateurs;
    }

    @Override
    public String getColumnName(int column) {
        return this.header[column];
    }

    @Override
    public int getRowCount() {
        return this.administrateurs.length;
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Administrateur administrateur = this.administrateurs[rowIndex];
        switch (columnIndex) {
            case 0:
                return administrateur.getLogin();
            case 1:
                return administrateur.getMdp();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Administrateur administrateur = this.administrateurs[rowIndex];
            switch (columnIndex) {
                case 0:
                    administrateur.setLogin((String) aValue);
                case 1:
                    administrateur.setMdp((String) aValue);
            }
            MetierFactory.getAdministrateurService().update(administrateur);
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

    public Administrateur getAdministrateurAt(int rowIndex) {
        return this.administrateurs[rowIndex];
    }

    public void update(Administrateur[] administrateurs) {
        this.administrateurs = administrateurs;
        this.fireTableDataChanged();
    }

}
