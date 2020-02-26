/*
 * Copyright (C) 2019 alan
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
package fr.freeboxos.ftb.client.model;

import fr.freeboxos.ftb.metier.MetierFactory;
import fr.freeboxos.ftb.metier.entitys.HDD;
import fr.freeboxos.ftb.metier.entitys.Memoire;
import fr.freeboxos.ftb.metier.entitys.Ordinateur;
import fr.freeboxos.ftb.metier.entitys.Processeur;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alan
 */
public class OrdinateurTableModel extends AbstractTableModel {

    private final String[] header = {"Processeur", "RAM", "Disque dur"};
    private Ordinateur[] ordinateurs;

    public OrdinateurTableModel(Ordinateur[] ordinateurs) {
        this.ordinateurs = ordinateurs;
    }

    @Override
    public String getColumnName(int column) {
        return this.header[column];
    }

    @Override
    public int getRowCount() {
        return this.ordinateurs.length;
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ordinateur ordinateur = this.ordinateurs[rowIndex];
        switch (columnIndex) {
            case 0:
                return ordinateur.getProcesseur().getMarque() + " " + ordinateur.getProcesseur().getModele();
            case 1:
                return ordinateur.getMemoire().getMarque() + " " + ordinateur.getMemoire().getModele();
            case 2:
                return ordinateur.getHdd().getMarque() + " " + ordinateur.getHdd().getModele();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Ordinateur ordinateur = this.ordinateurs[rowIndex];
            switch (columnIndex) {
                case 0:
                    ordinateur.setProcesseur((Processeur) aValue);
                    break;
                case 1:
                    ordinateur.setMemoire((Memoire) aValue);
                    break;
                case 2:
                    ordinateur.setHdd((HDD) aValue);
            }
            MetierFactory.getOrdinateurService().update(ordinateur);
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
            case 0:
                return Processeur.class;
            case 1:
                return Memoire.class;
            case 2:
                return HDD.class;
            default:
                return String.class;
        }
    }

    public Ordinateur getOrdinateurAt(int rowIndex) {
        return this.ordinateurs[rowIndex];
    }

    public void update(Ordinateur[] ordinateurs) {
        this.ordinateurs = ordinateurs;
        this.fireTableDataChanged();
    }
}
